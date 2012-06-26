package org.hopto.seed419.portalwatch;

import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 *
 * @author seed419
 *
 * The function of this class is to single-handedly handle the portal list.
 * It keeps the logic of the list and hashmap out of the UI class.
 *
 */
public class ListHandler {


    private Map<String,URL> mainList;
    private UI ui;
    private RefreshThread r;


    public ListHandler(UI ui) {
        this.ui = ui;
        r = new RefreshThread(this, ui);
    }

    public void startRefreshThread() {
        r.start();
    }


    /*Updates the list with the newest flashes from the portal*/
    public void refreshList() {
        try {
            List<CharSequence> data = HTMLParser.getHTML("http://www.newgrounds.com/portal/", "li[class$=judgement]");
            List<URL> urls = HTMLParser.applyURLRegex(data);
            List<String> descriptions = HTMLParser.applyDescriptionRegex(data);
            mainList = HTMLParser.linkLists(urls, descriptions);
            ui.fillUIList(descriptions);
        } catch (Exception ex) {
            Log.severe("Couldn't get links sorry :(", ex);
        }
    }

    /*Returns the main hashmap of URLs to strings that sit in the UI's JList*/
    public Map<String,URL> getMainList() {
        return Collections.unmodifiableMap(mainList);
    }

}
