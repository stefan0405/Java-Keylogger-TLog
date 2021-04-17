package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ActiveProcess {

    public static List<String> getActiveProcess() {
        List<String> processList = new ArrayList<>();
        try {
            Runtime runtime = Runtime.getRuntime();
            String[] cmds = {"cmd", "/c", "tasklist"};
            Process process = runtime.exec(cmds);
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                processList.add(line);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
        } catch (IOException e) {
            Logger.insertLog(e);
        }
        return processList;
    }
}
