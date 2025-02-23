package UIFist;

import com.formdev.flatlaf.FlatLightLaf;
import database.DatabaseManager;
import main.Menu;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import project93.LoginManager;
import project93.Register;
import project93.Test;

public class Login extends javax.swing.JFrame {
    private LoginManager loginManager;
    private String currentUsername; 
    private int userid;
    private int currentUserId;
    
    public Login(int currentUserId) {
        this.currentUsername = "";
        this.userid = currentUserId; 
        this.userid = currentUserId;
        
        
        initComponents();
        DatabaseManager db = new DatabaseManager();
        this.loginManager = new LoginManager(db);
        this.setTitle("Market Payment System");

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/LOGOICON.png"));
        this.setIconImage(icon.getImage());
      
        this.setLocationRelativeTo(null); 
        UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 15));
        UIManager.put("OptionPane.buttonFont", new Font("Tahoma", Font.PLAIN, 13));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        BackG = new javax.swing.JPanel();
        Field1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ButtonLogin = new javax.swing.JButton();
        ButtonRegister = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ButtonTest = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        BackG.setBackground(new java.awt.Color(250, 219, 145));

        Field1.setToolTipText("");
        Field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Field1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("เข้าสู่ระบบ");

        ButtonLogin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonLogin.setText("เข้าสู่ระบบ");
        ButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonLoginActionPerformed(evt);
            }
        });

        ButtonRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonRegister.setText("สมัครสมาชิก");
        ButtonRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRegisterActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("รหัสผ่าน");

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("ชื่อ");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LOGOD.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/NewLogo (2).png"))); // NOI18N

        ButtonTest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonTest.setText("ทดลองใช้");
        ButtonTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BackGLayout = new javax.swing.GroupLayout(BackG);
        BackG.setLayout(BackGLayout);
        BackGLayout.setHorizontalGroup(
            BackGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackGLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(BackGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(BackGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(BackGLayout.createSequentialGroup()
                            .addGap(102, 102, 102)
                            .addComponent(jLabel1))
                        .addComponent(Field1)
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(BackGLayout.createSequentialGroup()
                            .addGap(24, 24, 24)
                            .addComponent(ButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(ButtonRegister)))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackGLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ButtonTest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );
        BackGLayout.setVerticalGroup(
            BackGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(BackGLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ButtonTest, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MINILOGO.png"))); // NOI18N
        jMenuBar2.add(jMenu2);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void ButtonRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRegisterActionPerformed
        Register registerFrame = new Register(currentUserId, currentUsername);
        registerFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonRegisterActionPerformed

    private void ButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonLoginActionPerformed
        String username = Field1.getText().trim();
        String password = new String(jPasswordField1.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "กรุณากรอกข้อมูลให้ครบถ้วน!", "ข้อผิดพลาด", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (loginManager.authenticate(username, password)) {
            currentUserId = LoginManager.getCurrentUserId(); 
            currentUsername = LoginManager.getCurrentUserName(); 
            userid = currentUserId; 

            JOptionPane.showMessageDialog(this, "เข้าสู่ระบบสำเร็จ! ยินดีต้อนรับ " + currentUsername);

            Menu menuFrame = new Menu(currentUserId, currentUsername);
            menuFrame.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "ชื่อผู้ใช้หรือรหัสผ่านไม่ถูกต้อง!", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButtonLoginActionPerformed

    private void Field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Field1ActionPerformed

    }//GEN-LAST:event_Field1ActionPerformed

    private void ButtonTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTestActionPerformed
        Test testFrame = new Test();
        testFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonTestActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int currentUserId = 1;
                new Login(currentUserId).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackG;
    private javax.swing.JButton ButtonLogin;
    private javax.swing.JButton ButtonRegister;
    private javax.swing.JButton ButtonTest;
    private javax.swing.JTextField Field1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
