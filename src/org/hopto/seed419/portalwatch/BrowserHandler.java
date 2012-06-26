package org.hopto.seed419.portalwatch;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 *
 * @author seed419
 */
public class BrowserHandler {


    private static final int DESKTOP_UNSUPPORTED = 54;
    private static final int CANNOT_OPEN_BROWSER = 72;


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

    /*Workaround for unsupported linux desktops. Messy, but necessary*/
    public static int unsupportedDesktopWorkaround(URL url) {
        try {
            Process chromium = Runtime.getRuntime().exec("/usr/bin/chromium " + url.toString());
            int exit = chromium.waitFor();
            if (exit == 0) {
                return 0;
            } else {
                Process ff = Runtime.getRuntime().exec("/usr/bin/firefox " + url.toString());
                int exit2 = ff.waitFor();
                if (exit == 0) {
                    return 0;
                }
            }
        } catch (IOException ex) {
            Log.severe("Workaround failed :( Sorry");
        } catch (InterruptedException ie) {
            Log.warning("Interrupted.");
        }
        return CANNOT_OPEN_BROWSER;
    }

}
