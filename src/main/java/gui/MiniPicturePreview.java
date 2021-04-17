package gui;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Denic
 */
public class MiniPicturePreview extends javax.swing.JPanel {

    private final File file;

    public MiniPicturePreview(File file) {
        initComponents();
        this.file = file;
        setImage();
    }

    private void initComponents() {

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed();
            }
        });
        setLayout(new java.awt.CardLayout());
    }

    private void formMousePressed() {
        openImage(file);
    }

    private void setImage() {
        try {
            Image image = ImageIO.read(file);
//            String pictureName = file.getName();
//            int pos = pictureName.lastIndexOf(".");
//            String caption = pictureName.substring(0, pos);
            JPanelImage os = new JPanelImage();
            os.setBackground(image);
            this.add(os);
            this.revalidate();
            this.repaint();
        } catch (IOException ex) {
            Logger.getLogger(MiniPicturePreview.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void openImage(File fajl) {
        java.awt.EventQueue.invokeLater(() -> new ImagePreview(fajl).setVisible(true));
    }

}
