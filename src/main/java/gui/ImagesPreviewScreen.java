package gui;

import constants.Constants;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author Denic
 */
public class ImagesPreviewScreen extends javax.swing.JPanel {

    private javax.swing.JPanel jPanel1;

    public ImagesPreviewScreen() {
        initComponents();
        loadImages();
    }

    private void initComponents() {

        javax.swing.JScrollPane jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new java.awt.GridLayout(10, 2, 5, 5));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
    }


    private void loadImages() {
        Arrays.asList(Objects.requireNonNull(new File(Constants.IMAGE_FOLDER_NAME).listFiles())).forEach(file -> {
            MiniPicturePreview min = new MiniPicturePreview(file);
            min.setVisible(true);
            jPanel1.add(min);
        });
        jPanel1.repaint();
    }
}
