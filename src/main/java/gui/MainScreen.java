package gui;

import constants.ImagesPath;
import constants.Languages;
import keylogger.Keylogger;
import models.Settings;

import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Denic
 */
public class MainScreen extends javax.swing.JFrame {

    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel meni;
    private javax.swing.JLabel ostalo;
    private javax.swing.JLabel pregled;
    private javax.swing.JLabel profil;
    private final Settings settings;
    private final ResourceBundle language;

    public MainScreen(Settings settings) {
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource(ImagesPath.LOGO_200)).getImage());
        this.settings = settings;
        this.language = ResourceBundle.getBundle(Languages.LANGUAGE_BUNDLE, settings.getLocaleLanguage());
        initComponents();
        this.setLocationRelativeTo(null);
        jLabel5.setText(language.getString("pOpi"));
        if (Keylogger.getInstance().isWork()) {
            jButton1.setText("STOP");
            jButton1.setBackground(new java.awt.Color(102, 0, 0));
        } else {
            jButton1.setText("GO");
            jButton1.setBackground(new java.awt.Color(0, 255, 0));
        }
    }

    private void initComponents() {

        meni = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        profil = new javax.swing.JLabel();
        ostalo = new javax.swing.JLabel();
        pregled = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();

        setTitle("TLog - Keylogger");
        setMinimumSize(new java.awt.Dimension(610, 490));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing();
            }
        });

        meni.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deCrna.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked();
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited();
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jeCrni.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed();
            }
        });

        profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/proCrn.png"))); // NOI18N
        profil.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilMouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilMouseExited();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                profilMousePressed();
            }
        });

        ostalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/poCrno.png"))); // NOI18N
        ostalo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ostalo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ostaloMouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ostaloMouseExited();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                ostaloMousePressed();
            }
        });

        pregled.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preCrno.png"))); // NOI18N
        pregled.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pregled.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pregledMouseEntered();
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                pregledMouseExited();
            }

            public void mousePressed(java.awt.event.MouseEvent evt) {
                pregledMousePressed();
            }
        });

        javax.swing.GroupLayout meniLayout = new javax.swing.GroupLayout(meni);
        meni.setLayout(meniLayout);
        meniLayout.setHorizontalGroup(
                meniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(meniLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(meniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(meniLayout.createSequentialGroup()
                                                .addGroup(meniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(profil)
                                                        .addComponent(ostalo))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(meniLayout.createSequentialGroup()
                                                .addComponent(pregled)
                                                .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        meniLayout.setVerticalGroup(
                meniLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(meniLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel2)
                                .addGap(37, 37, 37)
                                .addComponent(profil)
                                .addGap(33, 33, 33)
                                .addComponent(ostalo)
                                .addGap(28, 28, 28)
                                .addComponent(pregled)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(607, 488));
        jPanel2.setLayout(null);

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("STOP");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(this::jButton1ActionPerformed);
        jPanel2.add(jButton1);
        jButton1.setBounds(180, 280, 170, 110);

        jLabel6.setFont(new java.awt.Font("Tahoma", Font.BOLD, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tlog");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 30, 103, 58);

        jLabel5.setFont(new java.awt.Font("Tahoma", Font.BOLD, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 100, 533, 25);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled-2.png"))); // NOI18N
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 0, 560, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(meni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(meni, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void jLabel1MouseEntered() {
        if (meni.getWidth() == 50) {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deBela.png")));
        } else {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leBela.png")));
        }
    }

    private void jLabel1MouseExited() {
        if (meni.getWidth() == 50) {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/deCrna.png")));
        } else {
            jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/leCrna.png")));
        }
    }

    private void jLabel1MouseClicked() {
        if (meni.getWidth() == 50) {
            meni.setSize(150, meni.getHeight());
            jLabel1.setBounds(meni.getWidth() - jLabel1.getWidth(), WIDTH, jLabel1.getWidth(), jLabel1.getHeight());
            jLabel2.setText(language.getString("pJez"));
            profil.setText(language.getString("pPro"));
            ostalo.setText(language.getString("pPod"));
            pregled.setText(language.getString("pPre"));
            jLabel2.setForeground(Color.BLACK);
            profil.setForeground(Color.BLACK);
            ostalo.setForeground(Color.BLACK);
            pregled.setForeground(Color.BLACK);
        } else {
            meni.setSize(50, meni.getHeight());
            jLabel1.setBounds(meni.getWidth() - jLabel1.getWidth(), WIDTH, jLabel1.getWidth(), jLabel1.getHeight());
            jLabel2.setText("");
            profil.setText("");
            ostalo.setText("");
            pregled.setText("");
        }
    }

    private void jLabel2MouseEntered() {
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jeBeli.png")));
        jLabel2.setForeground(Color.WHITE);
    }

    private void jLabel2MouseExited() {
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jeCrni.png")));
        jLabel2.setForeground(Color.BLACK);
    }

    private void profilMouseEntered() {
        profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/proBeli.png")));
        profil.setForeground(Color.WHITE);
    }

    private void profilMouseExited() {
        profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/proCrn.png")));
        profil.setForeground(Color.BLACK);
    }

    private void ostaloMouseEntered() {
        ostalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/poBelo.png")));
        ostalo.setForeground(Color.WHITE);
    }

    private void ostaloMouseExited() {
        ostalo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/poCrno.png")));
        ostalo.setForeground(Color.BLACK);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (Keylogger.getInstance().isWork()) {
            Keylogger.getInstance().stop();
            jButton1.setText("GO");
            jButton1.setBackground(new java.awt.Color(0, 255, 0));
        } else {
            Keylogger.getInstance().start();
            jButton1.setText("STOP");
            jButton1.setBackground(new java.awt.Color(102, 0, 0));
        }
    }

    private void formWindowClosing() {
        if (jButton1.getText().equals("GO")) {
            System.exit(0);
        }
    }

    private void jLabel2MousePressed() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        java.awt.EventQueue.invokeLater(() -> new JFrameContainer("pJez", settings).setVisible(true));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void profilMousePressed() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        java.awt.EventQueue.invokeLater(() -> new JFrameContainer("pPro", settings).setVisible(true));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void ostaloMousePressed() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        java.awt.EventQueue.invokeLater(() -> new JFrameContainer("pPod", settings).setVisible(true));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    private void pregledMouseEntered() {
        pregled.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preBelo.png")));
        pregled.setForeground(Color.WHITE);
    }

    private void pregledMouseExited() {
        pregled.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/preCrno.png")));
        pregled.setForeground(Color.BLACK);
    }

    private void pregledMousePressed() {
        this.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        java.awt.EventQueue.invokeLater(() -> new KeyloggerPreviewScreen(settings).setVisible(true));
        this.dispose();
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

}
