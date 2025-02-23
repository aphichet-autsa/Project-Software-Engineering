package List;

import Search.Showsearch;
import budget.Budget;
import com.formdev.flatlaf.FlatLightLaf;
import database.DatabaseManager;
import java.awt.Color;
import java.awt.Component;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.DefaultCellEditor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import main.Menu;
import main.Setting;
import UIFist.Login;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Showlist extends javax.swing.JFrame {
    private int currentUserId;
    private String currentUsername; 
    private DatabaseManager db;
    private ListData transactionList;
    private int userid;
    private static final Logger LOGGER = Logger.getLogger(Showlist.class.getName());
    private ListData listData; 
    
    public Showlist(int currentUserId, String username) {
        this.currentUserId = currentUserId;
        this.currentUsername = currentUsername;
        this.userid = currentUserId;
        this.db = db;
        
        initComponents();
        
        ListData transaction = new ListData((DefaultTableModel) jTable1.getModel(), CalTotal);
        setLocationRelativeTo(null);   
    }
 
    private void calculateTotal() {
        double total = 0.0;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (int i = 0; i < model.getRowCount(); i++) {
            Object priceObj = model.getValueAt(i, 3); 
            Object quantityObj = model.getValueAt(i, 2); 

            if (priceObj != null && quantityObj != null) {
                try {
                    double price = Double.parseDouble(priceObj.toString().trim());
                    int quantity = Integer.parseInt(quantityObj.toString().trim());
                    total += price * quantity; 
                } catch (NumberFormatException e) {
                    LOGGER.warning("ข้อมูลไม่ถูกต้องในแถวที่ " + (i + 1));
                }
            }
        }
        CalTotal.setText(String.format("%.2f", total)); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Total = new javax.swing.JLabel();
        ButtonSaveList = new javax.swing.JButton();
        CalTotal = new javax.swing.JLabel();
        CalculatButton = new javax.swing.JButton();
        ButtonTex = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 161, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LSS1.png"))); // NOI18N
        jLabel12.setText("jLabel4");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setText("รายการสินค้า");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ชื่อรายการ");

        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPane1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        jTable1.getTableHeader().setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16)); // ฟอนต์หัวตาราง
        jTable1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16));
        jTable1.setRowHeight(25); // ความสูงของแถว

        // กำหนด DefaultTableModel พร้อมแถวว่าง 30 แถว
        jTable1.setModel(new DefaultTableModel(
            new Object[30][4], // 30 แถว และ 4 คอลัมน์
            new String[]{
                "ลำดับ", "รายการ", "จำนวน", "ราคา"
            }
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // คอลัมน์ "ลำดับ" (column 0) ไม่สามารถแก้ไขได้
                return column != 0;
            }
        });

        // ตั้งค่าความกว้างของคอลัมน์
        TableColumn column;
        for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
            column = jTable1.getColumnModel().getColumn(i);
            if (i == 0) { // คอลัมน์ "ลำดับ"
                column.setPreferredWidth(50); 
            } else if (i == 1) { // คอลัมน์ "รายการ"
                column.setPreferredWidth(200);
            } else { // คอลัมน์ "จำนวน" และ "ราคา"
                column.setPreferredWidth(100);
            }
        }

        // เติมค่าลำดับอัตโนมัติ
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); // คอลัมน์ที่ 0 คือ "ลำดับ"
        }

        // ตั้งฟอนต์สำหรับ DefaultCellEditor (สำหรับการแก้ไขข้อมูลในเซลล์)
        DefaultCellEditor cellEditor = (DefaultCellEditor) jTable1.getDefaultEditor(Object.class);
        JTextField textField = (JTextField) cellEditor.getComponent();

        // *** เพิ่มโค้ดสำหรับเส้นขอบสีเทา ***
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                        boolean isSelected, boolean hasFocus,
                                                        int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBorder(new LineBorder(Color.GRAY, 1)); // เส้นขอบสีเทา ขนาด 1 pixel
                return label;
            }
        };

        // ใช้ Renderer กับทุกคอลัมน์ของ jTable1
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        // *** เพิ่มโค้ดสำหรับหัวตารางสีเทา ***
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        header.setForeground(Color.BLACK); // สีตัวอักษรในหัวตาราง
        header.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16)); // กำหนดฟอนต์ของหัวตาราง

        // *** จัดให้คอลัมน์ "ลำดับ" อยู่ตรงกลาง ***
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jScrollPane2.setViewportView(jTable1);

        Total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total.setText("รวมราคาทั้งหมด");

        ButtonSaveList.setBackground(new java.awt.Color(51, 255, 51));
        ButtonSaveList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSaveList.setText("บันทึก");
        ButtonSaveList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ButtonSaveListActionPerformed(evt);
                } catch (SQLException e) {
                    LOGGER.log(Level.SEVERE, "เกิดข้อผิดพลาดในการบันทึกข้อมูล", e);
                    JOptionPane.showMessageDialog(null, "เกิดข้อผิดพลาด: " + e.getMessage(), "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        CalTotal.setText("0.00");

        CalculatButton.setBackground(new java.awt.Color(153, 51, 255));
        CalculatButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        CalculatButton.setText("คำนวณ");
        CalculatButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculatButtonActionPerformed(evt);
            }
        });

        ButtonTex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ButtonTex.setText("ภาษี");
        ButtonTex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonTexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Total)
                        .addGap(18, 18, 18)
                        .addComponent(CalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonTex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CalculatButton)
                        .addGap(12, 12, 12)
                        .addComponent(ButtonSaveList))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CalTotal)
                        .addComponent(Total))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CalculatButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ButtonSaveList)
                            .addComponent(ButtonTex))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MINILOGO.png"))); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setText("เมนู");
        jMenu2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem1.setText("เข้าเมนู");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu10.setText("กำหนดงบ");
        jMenu10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem3.setText("เข้ากำหนดงบ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem3);

        jMenuBar1.add(jMenu10);

        jMenu5.setText("ค้นหา");
        jMenu5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem4.setText("เข้าค้นหา");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem4);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("ตั้งค่า");
        jMenu6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem5.setText("เข้าตั้งค่า");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("ออก");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem6.setText("หน้าเข้าสู่ระบบ");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem6);

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem2.setText("อกก");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem2);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

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
    }// </editor-fold>//GEN-END:initComponents

    private void CalculatButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CalculatButtonActionPerformed
        if (jTable1.isEditing()) {
        jTable1.getCellEditor().stopCellEditing();
        } 
        calculateTotal();
    }//GEN-LAST:event_CalculatButtonActionPerformed

    private void jTextPane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyReleased
        jTextPane1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
    }//GEN-LAST:event_jTextPane1KeyReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Budget budgetFrame = new Budget(currentUserId, currentUsername);
        budgetFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Menu menuFrame = new Menu(currentUserId, currentUsername);
        menuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Showsearch seaechFrame = new Showsearch(currentUserId, currentUsername);
        seaechFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        DatabaseManager db = new DatabaseManager(); 
        Setting settingFrame = new Setting(db, currentUserId, currentUsername);
        settingFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Login loginFrame = new Login(currentUserId);
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ButtonTexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonTexActionPerformed
          try {
            double taxRate = 0.07;

            if (jTable1.getModel() instanceof DefaultTableModel) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

                ListData transaction = new ListData(model, CalTotal); 

                transaction.updateListSummary(taxRate);
            } else {
                LOGGER.warning("Error: jTable1.getModel() is not an instance of DefaultTableModel");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error calculating tax", e);
        }
    }//GEN-LAST:event_ButtonTexActionPerformed

    private void ButtonSaveListActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
        UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 15));
        UIManager.put("OptionPane.buttonFont", new Font("Tahoma", Font.PLAIN, 15));

        String listName = jTextPane1.getText().trim();
        if (listName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "กรุณากรอกชื่อรายการ!", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            ListData transaction = new ListData(model, CalTotal);

            double totalAmount = transaction.getTotalWithTax() > 0 ? transaction.getTotalWithTax() : transaction.calculateTotal();

            transaction.saveData(listName, currentUserId);

            for (int i = 0; i < model.getRowCount(); i++) {
                Object itemName = model.getValueAt(i, 1);
                Object quantityObj = model.getValueAt(i, 2);
                Object priceObj = model.getValueAt(i, 3);

                if (itemName != null && quantityObj != null && priceObj != null) {
                    int quantity = Integer.parseInt(quantityObj.toString().trim());
                    double price = Double.parseDouble(priceObj.toString().trim());

                    transaction.saveData(currentUserId, listName, itemName.toString(), quantity, price);
                }
            }

            JOptionPane.showMessageDialog(this, "บันทึกข้อมูลสำเร็จ!", "สำเร็จ", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ค่ารวมไม่ถูกต้อง กรุณาตรวจสอบข้อมูล", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                int currentUserId = 1; 
                String currentUsername = "admin";
                new Showlist(currentUserId, currentUsername).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonSaveList;
    private javax.swing.JButton ButtonTex;
    private javax.swing.JLabel CalTotal;
    private javax.swing.JButton CalculatButton;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
