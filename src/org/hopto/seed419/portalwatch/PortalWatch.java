package org.hopto.seed419.portalwatch;

import org.hopto.seed419.file.OSUtils;
import org.hopto.seed419.file.SettingsFile;

/**
 *
 * @author seed419
 *
 *
    PortalWatch

    Attribute Only (Public) License
        Version 0.a5, Feb 07, 2012

    Copyright (C) Blake Bartenbach <seed419@gmail.com> (@SeeD419)

    Anyone is allowed to copy and distribute verbatim or modified
    copies of this license document and altering is allowed as long
    as you attribute the author(s) of this license document / files.

    ATTRIBUTE ONLY PUBLIC LICENSE
    TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION

    1. Attribute anyone attached to the license document.
        * Do not remove pre-existing attributes.

        Plausible attribution methods:
            1. Through comment header / license text.
            2. Referencing on a site, wiki, or about page.

        Example of comment attribute:
            @attribution _name_ <_email_> (_desc_of_attr_)

    2. Do whatever you want as long as you don't invalidate 1.

    @license AOL v.a5 <http://aol.nexua.org>

 */

public class PortalWatch {


    public static final double version = 0.1;
    private static final Log log = new Log();
    private static final UI u = new UI();
    private static final SettingsFile sf = new SettingsFile(u);


    public static void main(String[] args) {
        System.out.println("Testing Environment...");
        System.out.println("You're running " + OSUtils.getOsName());
        System.out.println("Your home directory is " + OSUtils.getUserHome());
        u.init();
    }

}
