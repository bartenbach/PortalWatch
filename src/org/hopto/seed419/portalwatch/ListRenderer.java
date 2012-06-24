/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hopto.seed419.portalwatch;

import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author seed419
 */
public class ListRenderer extends DefaultListCellRenderer {


    private static final long serialVersionUID = 1L;
    private static HashSet<String> viewedFlashes = new HashSet<String>();


    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        String desc = (String) value;

        if (viewedFlashes.contains(desc)) {
            setForeground(Color.GRAY);
        } else {
            setForeground(Color.WHITE);
        }
        return this;
    }

    public static void addViewedFlash(String value) {
        viewedFlashes.add(value);
    }



}
