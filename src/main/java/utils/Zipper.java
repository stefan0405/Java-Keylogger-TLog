package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author Denic
 */
public class Zipper {

    private static void zipFolderOrFile(File source, File destination, ZipOutputStream zipOutputStream) {
        if (source.isDirectory()) {
            for (File f : Objects.requireNonNull(source.listFiles())) {
                if (f.isDirectory()) {
                    zipFolderOrFile(source, destination, zipOutputStream);
                } else {
                    addFileToZip(destination, source, zipOutputStream);
                }
            }
        } else {
            addFileToZip(destination, source, zipOutputStream);
        }
    }

    public static void zipFolder(File source, File destination) {
        try (FileOutputStream fileWriter = new FileOutputStream(destination); ZipOutputStream zip = new ZipOutputStream(fileWriter)) {
            zipFolderOrFile(source, destination, zip);
            zip.flush();
        } catch (IOException e) {
            Logger.insertLog(e);
        }
    }

    private static void addFileToZip(File destination, File source, ZipOutputStream zipOutputStream) {
        try (FileInputStream in = new FileInputStream(source)) {
            byte[] buf = new byte[999999999];
            int len;
            zipOutputStream.putNextEntry(new ZipEntry(destination.getAbsolutePath() + "/" + source.getName()));
            while ((len = in.read(buf)) > 0) {
                zipOutputStream.write(buf, 0, len);
            }
            zipOutputStream.close();
        } catch (IOException e) {
            Logger.insertLog(e);
        }

    }
}
