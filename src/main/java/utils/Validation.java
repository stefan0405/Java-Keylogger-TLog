package utils;

import exceptions.SettingsNotSetException;
import models.Settings;

public class Validation {

    public static void checkIsSettingsSet(Settings settings) {
        if (settings == null)
            throw new SettingsNotSetException("Please set a Settings");
    }
}
