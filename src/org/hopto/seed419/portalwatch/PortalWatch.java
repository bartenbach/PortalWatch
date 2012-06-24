/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hopto.seed419.portalwatch;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;

/**
 *
 * @author seed419
 */
public class PortalWatch {


    private static final double version = 0.1;
    private static Map<String,URL> mainList;
    private static final int DESKTOP_UNSUPPORTED = 54;
    private static final int CANNOT_OPEN_BROWSER = 72;
    private static final UI u = new UI();
    private static final Thread thread = new RefreshThread();


    public static void main(String[] args) {
        /*Init logger, system tray, icon, and set visible*/
        final Log log = new Log();
        u.setupSysTray();
        u.hideStuff();
        u.setLocation(400, 400);
        u.setVisible(true);
        u.setIconImage(new ImageIcon(u.getClass().getResource("../img/icon.png")).getImage());

        /*Fill list on startup*/
        refreshList();

        /*Start polling thread*/
        thread.start();
    }

    /*Returns the main hashmap of URLs to strings that sit in the UI's JList*/
    public static Map<String,URL> getMainList() {
        return Collections.unmodifiableMap(mainList);
    }

    /*Opens a URL.  This method is fired from the UI class - mouseClicked*/
    public static void openURL(URL url) {
        if (!Desktop.isDesktopSupported()) {
            int workaround = unsupportedDesktopWorkaround(url);
            if (workaround > 0) {
                Log.severe("Couldn't get a browser to open, sorry.  Report this!");
                System.exit(DESKTOP_UNSUPPORTED);
            }
            return;
        }
       Desktop desktop = Desktop.getDesktop();
        if(!desktop.isSupported(Desktop.Action.BROWSE)) {
            Log.severe("Can't open web browser with your OS, sorry :(");
            System.exit(CANNOT_OPEN_BROWSER);
        }
        try {
            desktop.browse(url.toURI());
        } catch (URISyntaxException ex) {
            Log.severe("Can't navigate to that URL, sorry :(",ex);
        } catch (IOException ex) {
            Log.severe("Can't navigate to that URL, sorry :(",ex);
        }
    }

    /*Workaround for unsupported linux desktops*/
    public static int unsupportedDesktopWorkaround(URL url) {
        try {
            Process chrom = Runtime.getRuntime().exec("/usr/bin/chromium " + url.toString());
            int exit = chrom.waitFor();
            if (exit == 0) {return 0;} else {
                Process ff = Runtime.getRuntime().exec("/usr/bin/firefox " + url.toString());
                int exit2 = ff.waitFor();
                if (exit == 0) {return 0;}
            }
        } catch (IOException ex) {
            Log.severe("Workaround failed :( Sorry");
        } catch (InterruptedException ie) {
            Log.warning("Interrupted.");
        }
        return CANNOT_OPEN_BROWSER;
    }

    /*Updates the list with the newest flashes from the portal*/
    public static void refreshList() {
        try {
            List<CharSequence> data = HTMLParser.getHTML("http://www.newgrounds.com/portal/", "li[class$=judgement]");
            List<URL> urls = HTMLParser.applyURLRegex(data);
            List<String> descriptions = HTMLParser.applyDescriptionRegex(data);
            mainList = HTMLParser.linkLists(urls, descriptions);
            u.fillUIList(descriptions);
        } catch (NullPointerException npe) {
            Log.severe("Couldn't get links sorry :(", npe);
        }
    }

    public static double getVersion() {
        return version;
    }
}
