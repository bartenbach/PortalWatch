package org.hopto.seed419.file;

import org.hopto.seed419.portalwatch.Log;
import org.hopto.seed419.portalwatch.UI;

import java.io.*;
import java.util.ArrayList;

public class SettingsFile {


    private final static File settingsDir = new File(OSUtils.getUserHome() + "/.portalwatch");
    private final static File settingsFile = new File(OSUtils.getUserHome() + "/.portalwatch/portalwatch.conf");
    private static UI ui;


    public SettingsFile(UI ui) {
        this.ui = ui;
        if (settingsDir.exists()) {
            loadSettings();
        } else {
            try {
                settingsDir.mkdirs();
                settingsFile.createNewFile();
            } catch (IOException e) {
                Log.warning("Unable to create settings file", e);
            }
        }
    }

    public static void saveSettings(ArrayList<String> fields) {
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(settingsFile)));
            pw.println(fields.get(0));
            pw.println(fields.get(1));
            pw.println(fields.get(2));
            pw.flush();
            pw.close();
        } catch (IOException e) {
            Log.warning("Unable to connect stream to PortalWatch file", e);
        }

    }

    public static void loadSettings() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(settingsFile));
            try {
                ui.setUserNameField(br.readLine());
                ui.setRefreshTimeField(br.readLine());
                ui.setRefreshTimeUnits(Integer.parseInt(br.readLine()));
            } catch (IOException ex) {
                Log.warning("Unable to read from PortalWatch settings file", ex);
            }
        } catch (FileNotFoundException e) {
            Log.warning("Unable to connect stream to PortalWatch file", e);
        }
    }


}
