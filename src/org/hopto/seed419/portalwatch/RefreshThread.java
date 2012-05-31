/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hopto.seed419.portalwatch;

/**
 *
 * @author seed419
 */
public class RefreshThread extends Thread {

    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep(UI.getRefreshTime());
                PortalWatch.refreshList();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
