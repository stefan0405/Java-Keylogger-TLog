package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author Denny
 */
public class FileUtil {

    public static void writeInFileFromFile(File fileFrom, File fileTo, boolean overwriting) {
        bufferReaderToList(fileFrom.getAbsolutePath(), new ArrayList<>()).forEach(s -> {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileTo, !overwriting))) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            } catch (IOException e) {
                Logger.insertLog(e);
            }
        });
    }

    public static void writeInFile(String text, File file, boolean overwriting) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, !overwriting))) {
            bufferedWriter.write(text);
            bufferedWriter.newLine();
        } catch (IOException e) {
            Logger.insertLog(e);
        }
    }

    public static void deleteSubFiles(File file, boolean includeSelf) {
        if (file.exists()) {
            Arrays.asList(Objects.requireNonNull(file.listFiles())).forEach(file1 -> {
                if (!file1.delete()) {
                    Logger.insertLog("Cannot delete file: " + file1.getAbsolutePath());
                }
            });
            if (includeSelf) {
                if (!file.delete()) {
                    Logger.insertLog("Cannot delete sub files from: " + file.getAbsolutePath());
                }
            }
        }
    }

    public static File createTxtFile(String name) throws IOException {
        File file = new File(name + ".txt");
        if (!file.exists()) {
            if (!file.createNewFile()) {
                Logger.insertLog("Cannot create new file: " + file + ".txt");
            }
        }
        return file;
    }

    public static void deleteFile(File file) {
        if (file.exists()) {
            if (!file.delete()) {
                Logger.insertLog("Cannot delete file: " + file.getAbsolutePath());
            }
        }
    }

    public static File createDirectory(String path) {
        File file = new File(path);
        if (!file.exists()) {
            if (!file.mkdir()) {
                Logger.insertLog("Cannot make dir: " + path);
            }
        }
        return file;
    }

    private static List<String> bufferReaderToList(String path, List<String> list) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (final IOException e) {
            Logger.insertLog(e);
        }
        return list;
    }
}
