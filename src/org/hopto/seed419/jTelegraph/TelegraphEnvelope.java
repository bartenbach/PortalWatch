package org.hopto.seed419.jTelegraph;
/**
 * \cond LICENSE
 * ********************************************************************
 * This is a conditional block for preventing the DoxyGen documentation
 * tool to include this license header within the description of each
 * source code file. If you want to include this block, please define
 * the LICENSE parameter into the provided DoxyFile.
 * ********************************************************************
 *
 * JTelegraph - A message notification library
 * Copyright (c) 2011, Paulo Roberto Massa Cereda
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or
 * without modification, are permitted provided that the following
 * conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. Neither the name of the project's author nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR
 * TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE
 * USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * ********************************************************************
 * End of the LICENSE conditional block
 * ********************************************************************
 * \endcond
 *
 * <b>TelegraphEnvelope.java</b>: provides the window used for each message.
 * This class extends <code>javax.swing.JWindow</code> and inherits all methods
 * from the superclass. <code>javax.swing.JWindow</code> was chosen since it
 * has no borders at all and makes no references of active windows in the
 * taskbar.
 */

// imports include color features, window and image settings
import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * Provides a window class used for each message. This class extends
 * <code>javax.swing.JWindow</code> and inherits all methods from the
 * superclass. <code>javax.swing.JWindow</code> was chosen since it
 * has no borders at all and makes no references of active windows in the
 * taskbar. There is no need of using objects of this class, since it has
 * no meaning by itself. <code>net.sf.jtelegraph.TelegraphEnvelope</code>
 * is used by <code>net.sf.jtelegraph.Telegraph</code>, setting title, body and
 * icon of the message. Besides, this class is also indirectly passed to the
 * <code>net.sf.jcarrierpigeon.Notification</code>, which will provide the
 * animation feature.
 *
 * @author Paulo Roberto Massa Cereda
 * @version 1.0
 * @since 1.0
 */
public class TelegraphEnvelope extends JWindow {

    // define a serial version ID
    private static final long serialVersionUID = 3778;

    // telegraph type
    private TelegraphType teleType;

    /**
     * Constructor method, creates a new window with a fixed size. Other
     * methods of this class will provide further features.
     */
    public TelegraphEnvelope() {

        // call this method to init components
        // NetBeans created this method structure, though I have some
        // restrictions on this procedure, I'll leave this for now, since
        // there is no harm
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize
     * the form. NetBeans forbides me to alter this code. Meh. By the
     * way, had to suppress some warnings for uncheck operations.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        // create the layout
        ContentPanel = new javax.swing.JPanel();
        telegraphIcon = new javax.swing.JLabel();
        telegraphText = new javax.swing.JLabel();

        // since this is an important message, I opted for marking it
        // as always on top. There's a reason for that: as modal windows
        // are cards off my deck, messages should be noted. So if they
        // appear behind another window, it won't help.
        setAlwaysOnTop(true);

        // layout stuff, panel
        ContentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ContentPanel.setAlignmentX(0.0F);
        ContentPanel.setAlignmentY(0.0F);

        // more layout stuff, now about the icon
        telegraphIcon.setText("Icon");
        telegraphIcon.setMaximumSize(new java.awt.Dimension(64, 64));
        telegraphIcon.setMinimumSize(new java.awt.Dimension(64, 64));
        telegraphIcon.setPreferredSize(new java.awt.Dimension(64, 64));

        // layout stuff reloaded, now about the text
        telegraphText.setText("Text");

        // stuff revolution, grouping all
        javax.swing.GroupLayout ContentPanelLayout = new javax.swing.GroupLayout(ContentPanel);
        ContentPanel.setLayout(ContentPanelLayout);
        ContentPanelLayout.setHorizontalGroup(
                ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ContentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(telegraphIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                //this was 252
                                .addComponent(telegraphText, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                .addContainerGap())
        );
        ContentPanelLayout.setVerticalGroup(
                ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ContentPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ContentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(telegraphText)
                                        .addComponent(telegraphIcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        // accessibility
        telegraphIcon.getAccessibleContext().setAccessibleName("telegraphIcon");

        // grouping again
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ContentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        // now let's pack it!
        pack();
    }


    // window variables
    private javax.swing.JPanel ContentPanel;
    private javax.swing.JLabel telegraphIcon;
    private javax.swing.JLabel telegraphText;

    /**
     * Set the message title and body. This method is used by the
     * <code>net.sf.jtelegraph.Telegraph</code> class in order to define
     * the contents of the message to be displayed.
     * @param title Title of the message.
     * @param message Body of the message. The message itself.
     */
    public synchronized void setMessage(String title, String message) {

        // since I'd like to provide a word and line wrapping for the
        // <code>javax.swing.JLabel</code> class, I used this trick:
        // the text is inserted in between a HTML formatted code. If
        // you use a native UI for your Java applications, you may even use
        // HTML tags for your message!
        String labelText = String.format("<html><head>" +
                "<style type=\"text/css\">" +
                "</style>" +
                "</head><div style=\"width:%dpx;\"><h5>%s</h5>%s</div><html>", 170, title, message);

        // set the text
        telegraphText.setFont(new Font("Arial", Font.BOLD, 12));
        telegraphText.setText(labelText);

    }

    /**
     * In case of a label being bigger than the actual window size, this method
     * will fix the height for us. This method probably will be replaced in
     * future versions, since I don't like it.
     */
    private void fixWindowHeight() {

        // get the window height
        int windowHeight = getHeight();

        // get the label height
        int textHeight = this.telegraphText.getHeight();

        // compare sizes
        if ((windowHeight - (30 * 1.7)) <= textHeight) {

            // increase the size
            this.setBounds(this.getX(), this.getY(), this.getWidth(), ((int)(30 * 1.7) + textHeight));
        }
    }


    /**
     * Packs the current window, setting the proper icon and font color, and
     * possibly fixing a bad window.
     */
    public void packTelegraph() {

        // pack the window
        this.pack();

        // fix the window height
        fixWindowHeight();

        // set the current message icon and font color
        setTelegraphIconAndColor(this.teleType);

    }

    /**
     * Set the message icon and font color for the current telegraph. You may
     * refer to the enumeration values from <code>net.sf.jtelegraph.TelegraphEnvelope</code>.
     * @param iconType The icon reference provided by the <code>net.sf.jtelegraph.TelegraphEnvelope</code>
     * enumeration.
     */
    private void setTelegraphIconAndColor(TelegraphType iconType) {

        // the icon name
        String iconName;

        // the font color
        Color iconColor;

        // check which icon was provided
        switch (iconType) {

            // application
            case APPLICATION:

                // set the name
                iconName = "application.png";

                // set the color
                iconColor = new Color(0, 0, 153);

                break;
            case DIRECTION_RIGHT:

                // set the name
                iconName = "direction_right.png";

                // set the color
                iconColor = new Color(51, 102, 0);

                break;

            // direction up
            case DOCUMENT:

                // set the name
                iconName = "document.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // document add
            case DOCUMENT_ADD:

                // set the name
                iconName = "document_add.png";

                // set the color
                iconColor = new Color(213, 159, 31);

                break;

            // document delete
            case DOCUMENT_DELETE:

                // set the name
                iconName = "document_delete.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // document edit
            case DOCUMENT_EDIT:

                // set the name
                iconName = "document_edit.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;
            case FILE:

                // set the name
                iconName = "file.png";

                // set the color
                iconColor = new Color(0, 51, 204);

                break;

            // file add
            case FILE_ADD:

                // set the name
                iconName = "file_add.png";

                // set the color
                iconColor = new Color(0, 51, 204);

                break;
            case LOAD_DOWNLOAD:

                // set the name
                iconName = "load_download.png";

                // set the color
                iconColor = new Color(0, 0, 153);

                break;

            // load upload
            case LOAD_UPLOAD:

                // set the name
                iconName = "load_upload.png";

                // set the color
                iconColor = new Color(0, 0, 153);

                break;

            // mail
            case MAIL:

                // set the name
                iconName = "mail.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // mail delete
            case MAIL_DELETE:

                // set the name
                iconName = "mail_delete.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // mail receive
            case MAIL_RECEIVE:

                // set the name
                iconName = "mail_receive.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // mail search
            case MAIL_SEARCH:

                // set the name
                iconName = "mail_search.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // mail send
            case MAIL_SEND:

                // set the name
                iconName = "mail_send.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // mail warning
            case MAIL_WARNING:

                // set the name
                iconName = "mail_warning.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            case MESSAGE:

                // set the name
                iconName = "message.png";

                // set the color
                iconColor = new Color(0, 51, 204);

                break;

            // notification add
            case NOTIFICATION_ADD:

                // set the name
                iconName = "notification_add.png";

                // set the color
                iconColor = new Color(51, 102, 0);

                break;

            // notification done
            case NOTIFICATION_DONE:

                // set the name
                iconName = "notification_done.png";

                // set the color
                iconColor = new Color(51, 102, 0);

                break;

            // notification error
            case NOTIFICATION_ERROR:

                // set the name
                iconName = "notification_error.png";

                // set the color
                iconColor = new Color(153, 0, 0);

                break;

            // notification help
            case NOTIFICATION_HELP:

                // set the name
                iconName = "notification_help.png";

                // set the color
                iconColor = new Color(0, 0, 153);

                break;

            // notification info
            case NOTIFICATION_INFO:

                // set the name
                iconName = "notification_info.png";

                // set the color
                iconColor = new Color(102, 0, 0);

                break;

            // notification remove
            case NOTIFICATION_REMOVE:

                // set the name
                iconName = "notification_remove.png";

                // set the color
                iconColor = new Color(153, 0, 0);

                break;

            // notification warning
            case NOTIFICATION_WARNING:

                // set the name
                iconName = "notification_warning.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // piechart
            case STAR_EMPTY:

                // set the name
                iconName = "star_empty.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // star full
            case STAR_FULL:

                // set the name
                iconName = "star_full.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // star half
            case STAR_HALF:

                // set the name
                iconName = "star_half.png";

                // set the color
                iconColor = new Color(153, 153, 0);

                break;

            // user
            default:

                // set the name
                iconName = "notification_info.png";

                // set the color
                iconColor = new Color(102, 0, 0);
        }

        // so the image URL will be in the package inside this one
        URL imageURL = this.getClass().getResource("icons/" + iconName);

        // if an image is loaded
        if (imageURL != null) {

            // create image
            ImageIcon icon = new ImageIcon(imageURL);

            // set icon
            this.telegraphIcon.setIcon(icon);

            // create window border
            this.ContentPanel.setBorder(javax.swing.BorderFactory.createLineBorder(iconColor, 2));

            // add color to the text
            this.telegraphText.setForeground(iconColor);
        }
        else {

            // display a text
            this.telegraphIcon.setText("No icon");
        }
    }

    /**
     * Setter method for the window telegraph type.
     * @param telegraph The telegraph type, that is, which icon and color
     * fonts will be used. This is an object of the <code>net.sf.jtelegraph.TelegraphType</code>
     * class.
     */
    public void setTelegraphType(TelegraphType telegraph) {

        // set the value
        this.teleType = telegraph;
    }

    public void setTelegraphColor(Color color) {
        this.telegraphText.setForeground(color);
        this.ContentPanel.setBorder(BorderFactory.createLineBorder(color, 2));
    }

}