package utils;

import constants.Constants;

import java.io.IOException;

public class Logger {

    public static void insertLog(Exception e) {
        if (Constants.TURN_ON_DEBUGG)
            e.printStackTrace();
        insert(e.getMessage());
    }

    public static void insertLog(String exception) {
        insert(exception);
    }

    private static void insert(String exception) {
        try {
            FileUtil.writeInFile(exception, FileUtil.createTxtFile("logger"), false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
