/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hopto.seed419.portalwatch;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import javax.swing.UIManager;

/**
 *
 * @author seed419
 */
public class UI extends javax.swing.JFrame {


    private static final long serialVersionUID = 1L;


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        UIList = new javax.swing.JList();
        underJudgement = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        refreshTimeField = new javax.swing.JTextField();
        errorRefresh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Portal Watch - Version " + PortalWatch.getVersion());
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(579, 214));
        setMinimumSize(new java.awt.Dimension(578, 213));
        setPreferredSize(new java.awt.Dimension(578, 213));
        setResizable(false);

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setDoubleBuffered(true);
        jTabbedPane1.setFocusable(false);

        jPanel2.setFocusable(false);

        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(0, 10));

        UIList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UIList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        UIList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        UIList.setDoubleBuffered(true);
        jScrollPane2.setViewportView(UIList);

        underJudgement.setForeground(new java.awt.Color(255, 204, 0));
        underJudgement.setText("Under Judgement: 0");
        underJudgement.setFocusable(false);

        refreshButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/hopto/seed419/img/refreshreallysmall.png"))); // NOI18N
        refreshButton.setMnemonic('r');
        refreshButton.setText("Refresh");
        refreshButton.setFocusable(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(underJudgement, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(refreshButton)
                    .addComponent(underJudgement))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        jTabbedPane1.addTab("Portal", jPanel2);

        jPanel1.setFocusable(false);
        jPanel1.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/hopto/seed419/img/web.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 0, 620, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/hopto/seed419/img/pod.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(-10, 40, 630, 140);

        jTabbedPane1.addTab("Stats", jPanel1);

        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel1.setText("Auto-Refresh Time ( Seconds ) :");

        refreshTimeField.setText("120");
        refreshTimeField.setToolTipText("Time between auto-refreshes of the portal list");
        refreshTimeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                refreshTimeFieldFocusLost(evt);
            }
        });

        errorRefresh.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        errorRefresh.setForeground(new java.awt.Color(255, 51, 0));
        errorRefresh.setText("Refresh time must be an integer");
        errorRefresh.setFocusable(false);

        jLabel2.setText("Your Newgrounds Username:");

        userNameField.setToolTipText("Enter your NG Username here to get access to your stats");
        userNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameFieldFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(refreshTimeField, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(userNameField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(userNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(refreshTimeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(errorRefresh))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Configure", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        PortalWatch.refreshList();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void refreshTimeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refreshTimeFieldFocusLost
        if (!refreshTimeField.getText().isEmpty()) {
            try {
                int time = Integer.parseInt(refreshTimeField.getText());
                if (time >= 30) {
                    errorRefresh.setVisible(false);
                    return;
                }
                showRefreshError("Refresh time should be at least 30");
            } catch (NumberFormatException ne) {
                showRefreshError("Refresh time not a valid integer");
            }
        }
    }//GEN-LAST:event_refreshTimeFieldFocusLost

    private void showRefreshError(String error) {
        errorRefresh.setText(error);
        errorRefresh.setVisible(true);
        refreshTimeField.setText("120");
    }

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        jPanel3.requestFocus();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void userNameFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFieldFocusLost
        if (!userNameField.getText().isEmpty()) {
            String url = "http://" + userNameField.getText() + ".newgrounds.com/stats";
            List<CharSequence> html = HTMLParser.getHTML(url, "dl.communitystats");
            List<String> stats = HTMLParser.applyStatRegex(html);
        }

    }//GEN-LAST:event_userNameFieldFocusLost

    public UI() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        hideErrors();
        UIList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    int index = UIList.getSelectedIndex();
                    String desc = (String) UIList.getModel().getElementAt(index);
                    URL url = PortalWatch.getMainList().get(desc);
                    PortalWatch.openURL(url);
                }
            }

        });

    }

    /*Fills UI List on first run, and adds the click listener*/
    public void fillUIList(List<String> descriptions) {
        UIList.setListData(descriptions.toArray());
        setUnderJudgement(descriptions.size());

    }

    public static int getRefreshTime() {
        return (Integer.parseInt(refreshTimeField.getText())*1000);
    }

    public void setUnderJudgement(int flashes) {
        underJudgement.setText("Under Judgement: " + flashes);
    }

    public void hideErrors() {
        errorRefresh.setVisible(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList UIList;
    private javax.swing.JLabel errorRefresh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton refreshButton;
    private static javax.swing.JTextField refreshTimeField;
    private javax.swing.JLabel underJudgement;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables
}
