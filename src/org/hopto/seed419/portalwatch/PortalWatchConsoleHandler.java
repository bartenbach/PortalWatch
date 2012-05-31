/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hopto.seed419.portalwatch;

import java.util.logging.ConsoleHandler;

/**
 *
 * @author seed419
 */
public class PortalWatchConsoleHandler extends ConsoleHandler {

    public PortalWatchConsoleHandler(){
        super();
        this.setOutputStream(System.out);
    }
}
