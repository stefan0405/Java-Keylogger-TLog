package utils;

import constants.Constants;
import models.Email;
import models.Settings;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Denic
 */
public class LoadSettings {

    public static boolean saveSettings(Settings settings) {
        try (FileOutputStream fileOut = new FileOutputStream(Constants.SETTINGS_FILE_NAME)) {
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(settings);
            }
            return true;
        } catch (IOException e) {
            Logger.insertLog(e);
        }
        return false;
    }

    public static Settings loadSettings() {
        if (new File(Constants.SETTINGS_FILE_NAME).exists()) {
            try (FileInputStream fileIn = new FileInputStream(Constants.SETTINGS_FILE_NAME); ObjectInputStream in = new ObjectInputStream(fileIn)) {
                return (Settings) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                Logger.insertLog(e);
            }
        }
        return null;
    }

    public static boolean deleteSettings() {
        try {
            if (!new File(Constants.EMAIL_FILE_NAME).delete()) {
                Logger.insertLog("Cannot delete email file");
            }
            if (!new File(Constants.SETTINGS_FILE_NAME).delete()) {
                Logger.insertLog("Cannot delete settings file");
            }
            return true;
        } catch (Exception e) {
            Logger.insertLog(e);
        }
        return false;
    }

    public static boolean saveSettingsForEmail(Email email) {
        try (FileOutputStream fos = new FileOutputStream(Constants.EMAIL_FILE_NAME); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(email);
            return true;
        } catch (IOException e) {
            Logger.insertLog(e);
        }
        return false;
    }

    public static Email loadSettingsForEmail() {
        if (new File(Constants.EMAIL_FILE_NAME).exists()) {
            try (FileInputStream fis = new FileInputStream(Constants.EMAIL_FILE_NAME); ObjectInputStream ois = new ObjectInputStream(fis)) {
                return (Email) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                Logger.insertLog(e);
            }
        }
        return null;
    }

    public static Email createDefaultEmail() {
        Email email = new Email(new SimpleDateFormat("dd-MM-yyyy").format(new Date()), false);
        if (saveSettingsForEmail(email)) {
            return email;
        }
        return null;
    }

    public static Settings createDefaultSettings() {
        Settings settings = new Settings();
        settings.setLanguage("en_US");
        settings.setEmail(null);
        settings.setPicture(true);
        settings.setLocation(true);
        settings.setUsername("tlog");
        settings.setPassword("tlog");
        settings.setFrstKey("Ctrl");
        settings.setSecondKey("Q");
        settings.setDelete(null);
        if (saveSettings(settings)) {
            return settings;
        }
        return null;
    }
}
