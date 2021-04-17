package keylogger;

import gui.InsertSettingsScreen;
import gui.LoginScreen;
import models.Email;
import models.Settings;
import utils.LoadSettings;

/**
 * @author Denic
 */
public class FirstTime {


    public static void checkIfSettingsExist() {
        Settings settings = LoadSettings.loadSettings();
        Email email = LoadSettings.loadSettingsForEmail();
        if (settings == null || email == null) {
            LoadSettings.createDefaultSettings();
            LoadSettings.createDefaultEmail();
            runInsertScreen();
        } else {
            if (settings.getPassword().equals("tlog") || settings.getUsername().equals("tlog")) {
                runInsertScreen();
            } else {
                runLoginPage();
            }
        }
    }

    private static void runInsertScreen() {
        java.awt.EventQueue.invokeLater(() -> {
            InsertSettingsScreen pr = InsertSettingsScreen.getInstance();
            if (!pr.isVisible()) {
                pr.setVisible(true);
            }
        });
    }

    private static void runLoginPage() {
        java.awt.EventQueue.invokeLater(() -> {
            LoginScreen loginScreen = LoginScreen.getInstance();
            if (!loginScreen.isVisible()) {
                loginScreen.setVisible(true);
            }
        });
    }

}
