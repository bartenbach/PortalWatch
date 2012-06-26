package org.hopto.seed419.portalwatch;

/**
 *
 * @author seed419
 */
public class RefreshThread extends Thread {


    private ListHandler lh;
    private UI u;


    public RefreshThread(ListHandler lh, UI u) {
        this.lh = lh;
        this.u = u;
    }

    @Override
    public void run() {

        while(true) {
            try {
                Thread.sleep(u.getRefreshTime());
                lh.refreshList();
            } catch (InterruptedException ex) {
                Log.warning("Refresh thread interrupted", ex);
            }
        }
    }

}
