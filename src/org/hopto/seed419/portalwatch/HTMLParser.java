/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hopto.seed419.portalwatch;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author seed419
 */
public class HTMLParser {

    /*Grabs the specified selection of HTML from the specified url*/
    public static List<CharSequence> getHTML(String url, String selection) {
        try {
            URL ng = new URL(url);
            Document doc = Jsoup.parse(ng, 10000);
            Elements links = doc.select(selection);
            links.toArray();

            List<CharSequence> charSeq = new ArrayList<CharSequence>();
            for (Object x : links) {
                charSeq.add(x.toString());
            }
            return charSeq;
        } catch (MalformedURLException mal) {
            Log.warning("Invalid URL", mal);
        } catch (IOException ex) {
            Log.warning("IOException thrown", ex);
        }
        return null;
    }

    /*Grabs URLs from HTML*/
    public static List<URL> applyURLRegex(List<CharSequence> data) {
        List<URL> links = new ArrayList<URL>();
        Pattern pat = Pattern.compile(Regex.getURLs);

        for (CharSequence x : data) {
            Matcher mat = pat.matcher(x);
            if (mat.find()) {
                StringBuilder sb = new StringBuilder(mat.group());
                sb.insert(0, "http://www.newgrounds.com");
                try {
                links.add(new URL(sb.toString()));
                } catch (MalformedURLException mfe) {
                    Log.warning("Invalid URL parsed.", mfe);
                }
            }
        }
        return links;
    }

    /*Grabs link description from HTML*/
    public static List<String> applyDescriptionRegex(List<CharSequence> data) {
        List<String> descriptions = new ArrayList<String>();
        for (CharSequence x : data) {
            String[] split = x.toString().split(">");
            String[] split2 = split[2].split("<");
            descriptions.add(split2[0]);
        }
        return descriptions;
    }

    /*Link the the URLs to their descriptions*/
    public static Map<String,URL> linkLists(List<URL> urls, List<String> descriptions) {
        Map<String,URL> mainList = new HashMap<String,URL>();
        for (int i = 0; i < urls.size(); i++) {
            if (i < descriptions.size()) {
                mainList.put(descriptions.get(i), urls.get(i));
            }
        }
        return mainList;
    }

    /*Gets stats from Newgrounds HTML*/
    public static List<String> applyStatRegex(List<CharSequence> data) {
        List<String> stats = new ArrayList<String>();
        Pattern pat = Pattern.compile(Regex.getStats);
        for (CharSequence x : data) {
            //System.out.println(x.toString());
            Matcher mat = pat.matcher(x);
            while(mat.find()) {
                String[] split = mat.group().split(">");
                //System.out.println(split[1]);
                if (split[1] != null && !split[1].isEmpty() && !split[1].contains(">") && !split[1].contains("<")) {
                    stats.add(split[1].trim());
                }
            }
        }
        return stats;
    }

}
