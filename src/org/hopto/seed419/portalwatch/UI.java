package org.hopto.seed419.portalwatch;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.List;
import javax.swing.UIManager;
import net.sf.jcarrierpigeon.WindowPosition;
import net.sf.jtelegraph.Telegraph;
import net.sf.jtelegraph.TelegraphQueue;
import net.sf.jtelegraph.TelegraphType;

/**
 *
 * @author seed419
 */
public class UI extends javax.swing.JFrame {


    private static final long serialVersionUID = 1L;
    private MenuItem exit;
    private boolean statsVisibleFlag = false;
    private ListHandler lh;
    private TrayIcon trayIcon;
    private final TelegraphQueue queue = new TelegraphQueue();


    /*Sets look and feel to jTattoo's HiFi laf, and inits components*/
    public UI() {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
            //UIManager.setLookAndFeel("Nimbus");
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
    }

    /*Starts list handling class, and other housekeeping*/
    public void init() {
        this.setupSysTray();
        lh = new ListHandler(this);
        lh.startRefreshThread();
        lh.refreshList();
        this.hideStuff();
        this.setLocation(400, 400);
        this.setVisible(true);
        this.setIconImage(this.getToolkit().getImage(getClass().getResource("/img/icon.png")));
        UIList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() > 1) {
                    int index = UIList.getSelectedIndex();
                    String desc = (String) UIList.getModel().getElementAt(index);
                    ListRenderer.addViewedFlash(desc);
                    URL url = lh.getMainList().get(desc);
                    BrowserHandler.openURL(url);
                }
            }

        });
    }


    /*System Tray*/
    public void setupSysTray() {
        if (!SystemTray.isSupported()) {
            Log.severe("System tray returned 'unsupported'!  Please report this along with your operating system.");
            return;
        }
        final PopupMenu popup = new PopupMenu();
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getClassLoader().getResource("img/icon.png"));
        trayIcon = new TrayIcon(image);
        final SystemTray tray = SystemTray.getSystemTray();

        ActionListener listener = getMenuListener();
        trayIcon.addMouseListener(getTrayListener());

        exit = new MenuItem("Exit");
        exit.addActionListener(listener);
        popup.add(exit);

        trayIcon.setPopupMenu(popup);

        try {
            tray.add(trayIcon);
        } catch (Exception e) {
            Log.severe("The system tray could not be initialized.", e);
        }
    }

    private ActionListener getMenuListener() {
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == exit) {
                    System.exit(0);
                }
            }
        };
        return listener;
    }

    private MouseAdapter getTrayListener() {
        MouseAdapter listener2 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    showFrame();
                }
            }
        };
        return listener2;
    }

    private void showFrame() {
        this.setVisible(true);
    }

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
        refreshStatsButton = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        labelLevel = new javax.swing.JLabel();
        statLevel = new javax.swing.JLabel();
        labelExperience = new javax.swing.JLabel();
        statExperience = new javax.swing.JLabel();
        labelWhistle = new javax.swing.JLabel();
        labelExpRank = new javax.swing.JLabel();
        statExpRank = new javax.swing.JLabel();
        labelVP = new javax.swing.JLabel();
        statVP = new javax.swing.JLabel();
        statWhistle = new javax.swing.JLabel();
        statClass = new javax.swing.JLabel();
        errorNoName = new javax.swing.JLabel();
        labelRank = new javax.swing.JLabel();
        labelPosts = new javax.swing.JLabel();
        labelGlobalRank = new javax.swing.JLabel();
        labelBlams = new javax.swing.JLabel();
        labelSaves = new javax.swing.JLabel();
        statRank = new javax.swing.JLabel();
        statGlobalRank = new javax.swing.JLabel();
        statBlams = new javax.swing.JLabel();
        statSaves = new javax.swing.JLabel();
        statPosts = new javax.swing.JLabel();
        podPanel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        refreshTimeField = new javax.swing.JTextField();
        errorRefresh = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameField = new javax.swing.JTextField();
        refreshTimeUnit = new javax.swing.JComboBox();

        setTitle("Portal Watch - Version " + PortalWatch.getVersion());
        setBackground(new java.awt.Color(0, 0, 0));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(578, 213));
        setResizable(false);

        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setDoubleBuffered(true);
        jTabbedPane1.setFocusable(false);

        jPanel2.setFocusable(false);
        jPanel2.setLayout(null);

        jScrollPane2.setBorder(null);
        jScrollPane2.setForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(0, 10));

        UIList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        UIList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        UIList.setCellRenderer(new ListRenderer());
        UIList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        UIList.setDoubleBuffered(true);
        jScrollPane2.setViewportView(UIList);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(12, 38, 549, 115);

        underJudgement.setForeground(new java.awt.Color(255, 204, 0));
        underJudgement.setText("Under Judgement: 0");
        underJudgement.setFocusable(false);
        jPanel2.add(underJudgement);
        underJudgement.setBounds(12, 17, 161, 15);

        refreshButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        refreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refreshreallysmall.png"))); // NOI18N
        refreshButton.setMnemonic('r');
        refreshButton.setText("Refresh");
        refreshButton.setFocusable(false);
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });
        jPanel2.add(refreshButton);
        refreshButton.setBounds(463, 6, 98, 26);

        jTabbedPane1.addTab("Portal", jPanel2);

        jPanel1.setFocusable(false);
        jPanel1.setLayout(null);

        refreshStatsButton.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        refreshStatsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refreshreallysmall.png"))); // NOI18N
        refreshStatsButton.setMnemonic('r');
        refreshStatsButton.setText("Refresh");
        refreshStatsButton.setFocusable(false);
        refreshStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshStatsButtonActionPerformed(evt);
            }
        });
        jPanel1.add(refreshStatsButton);
        refreshStatsButton.setBounds(463, 6, 98, 26);

        header.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/web.png"))); // NOI18N
        jPanel1.add(header);
        header.setBounds(0, 0, 620, 40);

        labelLevel.setForeground(new java.awt.Color(255, 153, 0));
        labelLevel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelLevel.setText("Level:");
        jPanel1.add(labelLevel);
        labelLevel.setBounds(20, 50, 110, 15);

        statLevel.setForeground(new java.awt.Color(255, 255, 255));
        statLevel.setText("N/A");
        jPanel1.add(statLevel);
        statLevel.setBounds(150, 50, 60, 15);

        labelExperience.setForeground(new java.awt.Color(255, 153, 0));
        labelExperience.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelExperience.setText("Experience:");
        jPanel1.add(labelExperience);
        labelExperience.setBounds(20, 70, 110, 15);

        statExperience.setForeground(new java.awt.Color(255, 255, 255));
        statExperience.setText("N/A");
        jPanel1.add(statExperience);
        statExperience.setBounds(150, 70, 140, 15);

        labelWhistle.setForeground(new java.awt.Color(255, 153, 0));
        labelWhistle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelWhistle.setText("Whistle:");
        labelWhistle.setFocusable(false);
        jPanel1.add(labelWhistle);
        labelWhistle.setBounds(20, 130, 110, 15);

        labelExpRank.setForeground(new java.awt.Color(255, 153, 0));
        labelExpRank.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelExpRank.setText("Exp Rank:");
        jPanel1.add(labelExpRank);
        labelExpRank.setBounds(20, 90, 110, 15);

        statExpRank.setForeground(new java.awt.Color(255, 255, 255));
        statExpRank.setText("N/A");
        jPanel1.add(statExpRank);
        statExpRank.setBounds(150, 90, 130, 15);

        labelVP.setForeground(new java.awt.Color(255, 153, 0));
        labelVP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelVP.setText("Voting Power:");
        jPanel1.add(labelVP);
        labelVP.setBounds(20, 110, 110, 15);

        statVP.setForeground(new java.awt.Color(255, 255, 255));
        statVP.setText("N/A");
        jPanel1.add(statVP);
        statVP.setBounds(150, 110, 120, 15);

        statWhistle.setForeground(new java.awt.Color(255, 255, 255));
        statWhistle.setText("N/A");
        jPanel1.add(statWhistle);
        statWhistle.setBounds(150, 130, 100, 15);

        statClass.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        statClass.setForeground(new java.awt.Color(153, 153, 153));
        statClass.setText("N/A");
        jPanel1.add(statClass);
        statClass.setBounds(173, 52, 130, 13);

        errorNoName.setForeground(new java.awt.Color(153, 153, 153));
        errorNoName.setText("Enter a username in the Configure tab for stats");
        jPanel1.add(errorNoName);
        errorNoName.setBounds(130, 90, 390, 15);

        labelRank.setForeground(new java.awt.Color(255, 153, 0));
        labelRank.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelRank.setText("Rank:");
        jPanel1.add(labelRank);
        labelRank.setBounds(260, 50, 110, 15);

        labelPosts.setForeground(new java.awt.Color(255, 153, 0));
        labelPosts.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelPosts.setText("Posts:");
        labelPosts.setFocusable(false);
        jPanel1.add(labelPosts);
        labelPosts.setBounds(260, 130, 110, 15);

        labelGlobalRank.setForeground(new java.awt.Color(255, 153, 0));
        labelGlobalRank.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelGlobalRank.setText("Global Rank:");
        jPanel1.add(labelGlobalRank);
        labelGlobalRank.setBounds(260, 70, 110, 15);

        labelBlams.setForeground(new java.awt.Color(255, 153, 0));
        labelBlams.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelBlams.setText("Blams:");
        jPanel1.add(labelBlams);
        labelBlams.setBounds(260, 90, 110, 15);

        labelSaves.setForeground(new java.awt.Color(255, 153, 0));
        labelSaves.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSaves.setText("Saves:");
        jPanel1.add(labelSaves);
        labelSaves.setBounds(260, 110, 110, 15);

        statRank.setForeground(new java.awt.Color(255, 255, 255));
        statRank.setText("N/A");
        jPanel1.add(statRank);
        statRank.setBounds(380, 50, 150, 15);

        statGlobalRank.setForeground(new java.awt.Color(255, 255, 255));
        statGlobalRank.setText("N/A");
        jPanel1.add(statGlobalRank);
        statGlobalRank.setBounds(380, 70, 140, 15);

        statBlams.setForeground(new java.awt.Color(255, 255, 255));
        statBlams.setText("N/A");
        jPanel1.add(statBlams);
        statBlams.setBounds(380, 90, 130, 15);

        statSaves.setForeground(new java.awt.Color(255, 255, 255));
        statSaves.setText("N/A");
        jPanel1.add(statSaves);
        statSaves.setBounds(380, 110, 140, 15);

        statPosts.setForeground(new java.awt.Color(255, 255, 255));
        statPosts.setText("N/A");
        jPanel1.add(statPosts);
        statPosts.setBounds(380, 130, 130, 15);

        podPanel.setForeground(new java.awt.Color(204, 204, 204));
        podPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pod.jpg"))); // NOI18N
        podPanel.setText("Exp rank:");
        jPanel1.add(podPanel);
        podPanel.setBounds(-10, 40, 630, 140);

        jTabbedPane1.addTab("Stats", jPanel1);

        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(null);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Auto-Refresh Timer:");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(12, 40, 210, 15);

        refreshTimeField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        refreshTimeField.setText("120");
        refreshTimeField.setToolTipText("Time between auto-refreshes of the portal list");
        refreshTimeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                refreshTimeFieldFocusLost(evt);
            }
        });
        jPanel3.add(refreshTimeField);
        refreshTimeField.setBounds(237, 40, 100, 19);

        errorRefresh.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        errorRefresh.setForeground(new java.awt.Color(255, 51, 0));
        errorRefresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        errorRefresh.setText("Refresh time must be an integer");
        errorRefresh.setFocusable(false);
        jPanel3.add(errorRefresh);
        errorRefresh.setBounds(70, 150, 440, 13);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Your Newgrounds Username:");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(12, 14, 210, 15);

        userNameField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        userNameField.setToolTipText("Enter your NG Username here to get access to your stats");
        userNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameFieldFocusLost(evt);
            }
        });
        jPanel3.add(userNameField);
        userNameField.setBounds(237, 14, 100, 19);

        refreshTimeUnit.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        refreshTimeUnit.setMaximumRowCount(2);
        refreshTimeUnit.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seconds", "Minutes" }));
        refreshTimeUnit.setToolTipText("Unit of time for the refresh timer");
        refreshTimeUnit.setDoubleBuffered(true);
        refreshTimeUnit.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                refreshTimeUnitItemStateChanged(evt);
            }
        });
        jPanel3.add(refreshTimeUnit);
        refreshTimeUnit.setBounds(350, 40, 75, 20);

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
        lh.refreshList();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void validateRefreshTime() {
        if (!refreshTimeField.getText().isEmpty()) {
            try {
                int time = Integer.parseInt(refreshTimeField.getText());
                if ((time >= 30 && refreshTimeUnit.getSelectedIndex() == 0) || refreshTimeUnit.getSelectedIndex() == 1) {
                    errorRefresh.setVisible(false);
                } else {
                    showRefreshError("Refresh time should be at least 30 seconds");
                }
            } catch (NumberFormatException ne) {
                showRefreshError("Refresh time not a valid integer");
            }
        }
    }

    private void refreshTimeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_refreshTimeFieldFocusLost
        validateRefreshTime();
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
        getAndFillStats();
    }//GEN-LAST:event_userNameFieldFocusLost

    private void getAndFillStats() {
        if (!userNameField.getText().isEmpty()) {
            String url = "http://" + userNameField.getText() + ".newgrounds.com/stats";
            List<CharSequence> html = HTMLParser.getHTML(url, "dl.communitystats");
            List<String> stats = HTMLParser.applyStatRegex(html);
            statClass.setText(stats.get(0));
            statLevel.setText(stats.get(1));
            statExperience.setText(stats.get(3));
            statExpRank.setText(stats.get(5));
            statVP.setText(stats.get(7));
            statWhistle.setText(stats.get(9));
            statRank.setText(stats.get(11));
            statGlobalRank.setText(stats.get(13));
            statBlams.setText(stats.get(15));
            statSaves.setText(stats.get(17));
            statPosts.setText(stats.get(19));
            if (!statsVisibleFlag) {
                showStats();
            }
        } else {
            hideStuff();
        }
    }

    private void refreshStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshStatsButtonActionPerformed
        getAndFillStats();
    }//GEN-LAST:event_refreshStatsButtonActionPerformed

    private void refreshTimeUnitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_refreshTimeUnitItemStateChanged
        validateRefreshTime();
    }//GEN-LAST:event_refreshTimeUnitItemStateChanged

    /*Fills UI List with provided List of String Objects*/
    public void fillUIList(List<String> descriptions) {
        checkForNewUJFlashes(descriptions);
        UIList.setListData(descriptions.toArray());
        setUnderJudgement(descriptions.size());
    }

    public void checkForNewUJFlashes(List<String> desc) {
        int items = UIList.getModel().getSize();
        int newItems = desc.size();
        if (newItems > items) {
            int newUJ = newItems - items;
            showNotification(newUJ);
//            trayIcon.displayMessage("PortalWatch", newUJ + " New Under Judgement Submissions", TrayIcon.MessageType.INFO);
        }
    }

    public void showNotification(int flashes){
        //Possible other workable notification schemes with HiFi LAF
        //MAIL, MAIL_RECIEVE, NOTIFICATION_ADD, NOTIIFCATION_DONE (not great), star_full, star_empty, DOCUMENT
        Telegraph tele = new Telegraph("PortalWatch", flashes + " new flashes in the portal", TelegraphType.MAIL, WindowPosition.TOPRIGHT, 4000);
        queue.add(tele);
    }

    public int getRefreshTime() {
        if (refreshTimeUnit.getSelectedIndex() == 0) {
            return (Integer.parseInt(refreshTimeField.getText())*1000);
        } else if (refreshTimeUnit.getSelectedIndex() == 1) {
            return (Integer.parseInt(refreshTimeField.getText())*1000*60);
        } else {
            Log.warning("Refresh Time validation failure.");
            return 30000;
        }
    }

    public void setUnderJudgement(int flashes) {
        underJudgement.setText("Under Judgement: " + flashes);
    }


    /*Show/Hide labels and errors*/
    public void hideStuff() {
        errorNoName.setVisible(true);
        errorRefresh.setVisible(false);
        statClass.setVisible(false);
        statLevel.setVisible(false);
        statExperience.setVisible(false);
        statExpRank.setVisible(false);
        statVP.setVisible(false);
        statWhistle.setVisible(false);
        statRank.setVisible(false);
        statBlams.setVisible(false);
        statSaves.setVisible(false);
        statGlobalRank.setVisible(false);
        statPosts.setVisible(false);
        labelExpRank.setVisible(false);
        labelExperience.setVisible(false);
        labelLevel.setVisible(false);
        labelVP.setVisible(false);
        labelWhistle.setVisible(false);
        labelGlobalRank.setVisible(false);
        labelRank.setVisible(false);
        labelSaves.setVisible(false);
        labelBlams.setVisible(false);
        labelPosts.setVisible(false);
    }

    public void showStats() {
        errorNoName.setVisible(false);
        statClass.setVisible(true);
        statLevel.setVisible(true);
        statExperience.setVisible(true);
        statExpRank.setVisible(true);
        statVP.setVisible(true);
        statWhistle.setVisible(true);
        statRank.setVisible(true);
        statBlams.setVisible(true);
        statSaves.setVisible(true);
        statGlobalRank.setVisible(true);
        statPosts.setVisible(true);
        labelExpRank.setVisible(true);
        labelExperience.setVisible(true);
        labelLevel.setVisible(true);
        labelVP.setVisible(true);
        labelWhistle.setVisible(true);
        labelGlobalRank.setVisible(true);
        labelRank.setVisible(true);
        labelSaves.setVisible(true);
        labelBlams.setVisible(true);
        labelPosts.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList UIList;
    private javax.swing.JLabel errorNoName;
    private javax.swing.JLabel errorRefresh;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelBlams;
    private javax.swing.JLabel labelExpRank;
    private javax.swing.JLabel labelExperience;
    private javax.swing.JLabel labelGlobalRank;
    private javax.swing.JLabel labelLevel;
    private javax.swing.JLabel labelPosts;
    private javax.swing.JLabel labelRank;
    private javax.swing.JLabel labelSaves;
    private javax.swing.JLabel labelVP;
    private javax.swing.JLabel labelWhistle;
    private javax.swing.JLabel podPanel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton refreshStatsButton;
    private static javax.swing.JTextField refreshTimeField;
    private javax.swing.JComboBox refreshTimeUnit;
    private javax.swing.JLabel statBlams;
    private javax.swing.JLabel statClass;
    private javax.swing.JLabel statExpRank;
    private javax.swing.JLabel statExperience;
    private javax.swing.JLabel statGlobalRank;
    private javax.swing.JLabel statLevel;
    private javax.swing.JLabel statPosts;
    private javax.swing.JLabel statRank;
    private javax.swing.JLabel statSaves;
    private javax.swing.JLabel statVP;
    private javax.swing.JLabel statWhistle;
    private javax.swing.JLabel underJudgement;
    private javax.swing.JTextField userNameField;
    // End of variables declaration//GEN-END:variables

}
