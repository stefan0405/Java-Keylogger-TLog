package gui;

import constants.ImagesPath;
import constants.Languages;
import models.Settings;
import utils.LoadSettings;

import javax.swing.*;
import java.awt.*;
import java.util.ResourceBundle;

/**
 * @author Denic
 */
public class JFrameContainer extends javax.swing.JFrame {

    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JPanel languagePanel;
    private javax.swing.JPanel settingsPanel;
    private javax.swing.JPanel profilePanel;

    private final Settings settings;
    private final ResourceBundle language;

    public JFrameContainer(String componentName, Settings settings) {
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource(ImagesPath.LOGO_200)).getImage());
        this.settings = settings;
        language = ResourceBundle.getBundle(Languages.LANGUAGE_BUNDLE, settings.getLocaleLanguage());
        initComponents();
        jLabel10.setVisible(false);
        jTextField1.setVisible(false);
        jLabel11.setVisible(false);
        jComboBox2.setVisible(false);
        setComponent(componentName);
        this.setTitle(language.getString("poNaslov"));
        this.setLocationRelativeTo(null);
        zaKombo();
    }

    private void initComponents() {
        languagePanel = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel(language.getString("poJezik"));
        // Variables declaration - do not modify
        javax.swing.JButton jButton1 = new javax.swing.JButton(language.getString("poSacuvaj"));
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel(language.getString("poProfil"));
        javax.swing.JButton jButton2 = new javax.swing.JButton(language.getString("poSacuvaj"));
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        settingsPanel = new javax.swing.JPanel();
        javax.swing.JLabel jLabel8 = new javax.swing.JLabel(language.getString("pPod"));
        javax.swing.JButton jButton3 = new javax.swing.JButton(language.getString("poSacuvaj"));
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        javax.swing.JLabel jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        languagePanel.setBackground(new java.awt.Color(0, 0, 0));
        languagePanel.setMinimumSize(new java.awt.Dimension(607, 488));
        languagePanel.setPreferredSize(new java.awt.Dimension(607, 488));
        languagePanel.setLayout(null);

        jComboBox1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        languagePanel.add(jComboBox1);
        jComboBox1.setBounds(60, 190, 490, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        languagePanel.add(jLabel1);
        jLabel1.setBounds(0, 13, 607, 50);

        jButton1.setBackground(new java.awt.Color(102, 0, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(this::jButton1ActionPerformed);
        languagePanel.add(jButton1);
        jButton1.setBounds(170, 400, 280, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled-2.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        languagePanel.add(jLabel2);
        jLabel2.setBounds(0, 0, 610, 490);

        profilePanel.setBackground(new java.awt.Color(0, 0, 0));
        profilePanel.setMinimumSize(new java.awt.Dimension(607, 488));
        profilePanel.setPreferredSize(new java.awt.Dimension(607, 488));
        profilePanel.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profilePanel.add(jLabel4);
        jLabel4.setBounds(0, 13, 607, 50);

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(this::jButton2ActionPerformed);
        profilePanel.add(jButton2);
        jButton2.setBounds(170, 400, 280, 50);

        jLabel5.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(language.getString("poProfil1"));
        profilePanel.add(jLabel5);
        jLabel5.setBounds(30, 160, 170, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText(language.getString("poProfil2"));
        profilePanel.add(jLabel6);
        jLabel6.setBounds(30, 200, 170, 22);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(language.getString("poProfil3"));
        profilePanel.add(jLabel7);
        jLabel7.setBounds(30, 240, 160, 22);

        jTextField3.setText(settings.getUsername());
        profilePanel.add(jTextField3);
        jTextField3.setBounds(240, 160, 270, 20);
        profilePanel.add(jPasswordField1);
        jPasswordField1.setBounds(240, 210, 270, 20);
        profilePanel.add(jPasswordField2);
        jPasswordField2.setBounds(240, 250, 270, 20);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled-2.png"))); // NOI18N
        jLabel3.setText("jLabel2");
        jLabel3.setMaximumSize(new java.awt.Dimension(607, 488));
        jLabel3.setMinimumSize(new java.awt.Dimension(607, 488));
        profilePanel.add(jLabel3);
        jLabel3.setBounds(0, 0, 610, 490);

        settingsPanel.setBackground(new java.awt.Color(0, 0, 0));
        settingsPanel.setMinimumSize(new java.awt.Dimension(607, 488));
        settingsPanel.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Tahoma", Font.BOLD, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        settingsPanel.add(jLabel8);
        jLabel8.setBounds(0, 13, 607, 50);

        jButton3.setBackground(new java.awt.Color(102, 0, 0));
        jButton3.setFont(new java.awt.Font("Tahoma", Font.BOLD, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(this::jButton3ActionPerformed);
        settingsPanel.add(jButton3);
        jButton3.setBounds(170, 400, 280, 50);

        jCheckBox1.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText(language.getString("poOs"));
        jCheckBox1.setOpaque(false);
        jCheckBox1.addActionListener(this::jCheckBox1ActionPerformed);
        settingsPanel.add(jCheckBox1);
        jCheckBox1.setBounds(20, 140, 140, 31);

        jCheckBox2.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText(language.getString("poOs1"));
        jCheckBox2.setOpaque(false);
        settingsPanel.add(jCheckBox2);
        jCheckBox2.setBounds(20, 180, 580, 31);

        jLabel10.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("E-mail:");
        settingsPanel.add(jLabel10);
        jLabel10.setBounds(210, 140, 60, 30);
        settingsPanel.add(jTextField1);
        jTextField1.setBounds(280, 140, 270, 30);

        jLabel11.setFont(new java.awt.Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText(language.getString("poOs3"));
        settingsPanel.add(jLabel11);
        jLabel11.setBounds(20, 230, 260, 30);

        jComboBox2.setBackground(new java.awt.Color(0, 0, 0));
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        settingsPanel.add(jComboBox2);
        jComboBox2.setBounds(280, 230, 270, 30);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Untitled-2.png"))); // NOI18N
        jLabel9.setText("jLabel2");
        jLabel9.setMaximumSize(new java.awt.Dimension(607, 488));
        jLabel9.setMinimumSize(new java.awt.Dimension(607, 488));
        settingsPanel.add(jLabel9);
        jLabel9.setBounds(0, 0, 610, 490);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing();
            }
        });

        jPanel1.setMinimumSize(new java.awt.Dimension(607, 488));
        jPanel1.setPreferredSize(new java.awt.Dimension(607, 488));
        jPanel1.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void formWindowClosing() {
        java.awt.EventQueue.invokeLater(() -> new MainScreen(settings).setVisible(true));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int sel = jComboBox1.getSelectedIndex();
        String je = null;
        switch (sel) {
            case 0:
                je = Languages.rs_RS;
                break;
            case 1:
                je = Languages.en_US;
                break;
        }
        settings.setLanguage(je);
        LoadSettings.saveSettings(settings);
        this.dispose();
        java.awt.EventQueue.invokeLater(() -> new JFrameContainer("pJez", settings).setVisible(true));
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (!jTextField3.getText().equals("") && !new String(jPasswordField1.getPassword()).equals("") && !new String(jPasswordField2.getPassword()).equals("")) {
            if (new String(jPasswordField1.getPassword()).equals(new String(jPasswordField2.getPassword()))) {
                settings.setUsername(jTextField3.getText());
                settings.setPassword(new String(jPasswordField1.getPassword()));
                if (LoadSettings.saveSettings(settings)) {
                    JOptionPane.showMessageDialog(this, language.getString("poCe1"), language.getString("poCe"), JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, language.getString("lo"), language.getString("ln"), JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, language.getString("poOba"), language.getString("ln"), JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        settings.setLocation(jCheckBox2.isSelected());
        boolean save = false;
        if (jCheckBox1.isSelected()) {
            if (settings.getEmail() == null) {
                if (!jTextField1.getText().equals("")) {
                    if (jTextField1.getText().contains("@")) {
                        settings.setEmail(jTextField1.getText());
                        settings.setDelete(parsirajCombo());
                        save = true;
                    } else {
                        JOptionPane.showMessageDialog(this, language.getString("poOs2"), language.getString("ln"), JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, language.getString("poOba"), language.getString("ln"), JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            settings.setEmail(null);
        }
        if (save) {
            if (LoadSettings.saveSettings(settings)) {
                JOptionPane.showMessageDialog(this, language.getString("poCe1"), language.getString("poCe"), JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jCheckBox1.isSelected()) {
            jLabel11.setVisible(true);
            jComboBox2.setVisible(true);
            if (settings.getEmail() == null) {
                jLabel10.setVisible(true);
                jLabel10.setBounds(jLabel10.getX(), jLabel10.getY(), 55, jLabel10.getHeight());
                jTextField1.setVisible(true);
            } else {
                jLabel10.setVisible(true);
                jLabel10.setText(jLabel10.getText() + " " + settings.getEmail());
                jLabel10.setBounds(jLabel10.getX(), jLabel10.getY(), 300, jLabel10.getHeight());
            }
        } else {
            jLabel10.setVisible(false);
            jTextField1.setVisible(false);
            jLabel11.setVisible(false);
            jComboBox2.setVisible(false);
        }
    }

    private void setComponent(String componentName) {
        switch (componentName) {
            case "pJez":
                jPanel1.removeAll();
                jPanel1.add(languagePanel);
                break;
            case "pPro":
                jPanel1.removeAll();
                jPanel1.add(profilePanel);
                break;
            case "pPod":
                jPanel1.removeAll();
                jPanel1.add(settingsPanel);
                break;
        }
        setLanguages();
        ostalo();
    }

    private void setLanguages() {
        jComboBox1.addItem(language.getString("poJ1"));
        jComboBox1.addItem(language.getString("poJ2"));
    }

    private void ostalo() {
        jCheckBox2.setSelected(settings.isLocation());
        if (settings.getEmail() != null) {
            jCheckBox1.setSelected(true);
            jLabel10.setVisible(true);
            jLabel10.setText(jLabel10.getText() + " " + settings.getEmail());
            jLabel10.setBounds(jLabel10.getX(), jLabel10.getY(), 300, jLabel10.getHeight());
        }
    }

    private void zaKombo() {
        String dan = language.getString("poOs4");
        jComboBox2.addItem(1 + " " + dan);
        jComboBox2.addItem(3 + " " + dan);
        jComboBox2.addItem(5 + " " + dan);
        jComboBox2.addItem(10 + " " + dan);
        jComboBox2.addItem(20 + " " + dan);
        jComboBox2.addItem(30 + " " + dan);
        if (settings.getDelete() != null) {
            jComboBox2.setSelectedItem(settings.getDelete() + " " + dan);
        }
        if (jCheckBox1.isSelected()) {
            jLabel11.setVisible(true);
            jComboBox2.setVisible(true);
        }
    }

    private int parsirajCombo() {
        String s = (String) jComboBox2.getSelectedItem();
        String[] niz = s.split(" ");
        return Integer.parseInt(niz[0]);
    }
}
