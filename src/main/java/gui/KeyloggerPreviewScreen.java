package gui;

import constants.Constants;
import constants.ImagesPath;
import constants.Languages;
import models.Settings;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Denic
 */
public class KeyloggerPreviewScreen extends javax.swing.JFrame {
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private final ResourceBundle language;
    private final Settings settings;

    public KeyloggerPreviewScreen(Settings settings) {
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource(ImagesPath.LOGO_200)).getImage());
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        this.language = ResourceBundle.getBundle(Languages.LANGUAGE_BUNDLE, settings.getLocaleLanguage());
        this.settings = settings;
        initComponents();
        this.setLocationRelativeTo(null);
        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        loadLog();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        javax.swing.JPanel jPanel3 = new javax.swing.JPanel();
        JLabel logo = new JLabel();
        JLabel jLabel2 = new JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing();
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(637, 0));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        logo.setFont(new java.awt.Font("Tahoma", Font.BOLD, 36)); // NOI18N
        logo.setForeground(new java.awt.Color(255, 255, 255));
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setText("KLog");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(language.getString("preI"));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(language.getString("preS"));
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed();
            }
        });

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(language.getString("preL"));
        jLabel3.setOpaque(true);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed();
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(74, 74, 74)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void formWindowClosing() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        java.awt.EventQueue.invokeLater(() -> new MainScreen(settings).setVisible(true));
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void jLabel1MouseEntered() {
        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
    }

    private void jLabel1MouseExited() {
        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
    }

    private void jLabel3MouseEntered() {
        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
    }

    private void jLabel3MouseExited() {
        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
    }

    private void jLabel1MousePressed() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        loadImages();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void jLabel3MousePressed() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        loadLog();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void loadImages() {
        jPanel1.removeAll();
        ImagesPreviewScreen image = new ImagesPreviewScreen();
        jPanel1.add(image);
        jPanel1.repaint();
        jPanel1.revalidate();
    }

    private void loadLog() {
        jPanel1.removeAll();
        String[] column = {language.getString("preVR"), language.getString("preKE")};
        List<String> list = new ArrayList<>();
        File file = new File(Constants.LOG_FOLDER_NAME);
        File[] n = file.listFiles();
        if (n != null) {
            for (File f : n) {
                if (f.getName().endsWith(".txt")) {
                    try {
                        Scanner s = new Scanner(f);
                        while (s.hasNext()) {
                            list.add(s.nextLine());
                        }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(KeyloggerPreviewScreen.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        }
        String[][] red = new String[list.size() / 2][list.size() / 2];
        if (list.isEmpty()) {
            JLabel la = new JLabel(language.getString("preO"));
            la.setBounds(jPanel1.getX(), jPanel1.getY(), jPanel1.getWidth(), jPanel1.getHeight());
            la.setForeground(Color.BLACK);
            la.setFont(new java.awt.Font("Tahoma", Font.BOLD, 32));
            la.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jPanel1.add(la);
        } else {
            int i = 0;
            int j = 0;
            for (String s : list) {
                if (s.startsWith("INFO")) {
                    String[] niz = s.split(":");
                    red[i][j] = niz[2];
                    j = 0;
                    i++;
                } else {
                    red[i][j] = s.substring(0, 25);
                    j++;
                }
            }
        }
        JTable jTable = new JTable(red, column);
        jTable.setBounds(jPanel1.getX(), jPanel1.getY(), jPanel1.getWidth(), jPanel1.getHeight());
        JScrollPane sp = new JScrollPane(jTable);
        jPanel1.add(sp);
        jPanel1.repaint();
        this.revalidate();
        this.repaint();
    }
}
