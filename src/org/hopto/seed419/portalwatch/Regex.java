package org.hopto.seed419.portalwatch;

/**
 * Created with IntelliJ IDEA.
 * User: seed419
 * Date: 5/28/12
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class Regex {


    /* In the event that Newgrounds has a web redesign, these regexes
       will need to be modified to parse the new HTML */
    public final static String getURLs = "\\/\\w+\\/\\w+\\/\\d*";
    public final static String getStats= "<dd>\\s+([^<a][a-zA-Z,0-9\\s/.]+)";


}
