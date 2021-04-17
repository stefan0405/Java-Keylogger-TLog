package gui;

import constants.ImagesPath;
import utils.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * @author Denic
 */
public class ImagePreview extends javax.swing.JFrame {
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;

    public ImagePreview(File imageFile) {
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource(ImagesPath.LOGO_200)).getImage());
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
            Image image = ImageIO.read(imageFile);
            JPanelImage a = new JPanelImage();
            a.setBounds(jPanel1.getX(), jPanel1.getY(), jPanel1.getWidth(), jPanel1.getHeight());
            a.setBackground(image);
            jPanel1.add(a);
            jPanel1.repaint();
            String pictureName = imageFile.getName();
            int pos = pictureName.lastIndexOf(".");
            String caption = pictureName.substring(0, pos);
            jLabel2.setText(caption);
        } catch (IOException ex) {
            Logger.insertLog(ex);
        }
        this.revalidate();
        this.repaint();
    }

    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );

        pack();
    }
}
