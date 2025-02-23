package main;

import List.Listitem;
import Search.Showsearch;
import budget.Budget;
import com.formdev.flatlaf.FlatLightLaf;
import database.DatabaseManager;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import UIFist.Login;


public class Check extends javax.swing.JFrame {
    private int currentUserId;
    private String currentUsername;
    private DatabaseManager db;
    private int userid;
    
    public Check(int currentUserId, String currentUsername) {
        this.currentUserId = currentUserId;
        this.currentUsername = currentUsername;
        this.userid = currentUserId;
        db = new DatabaseManager();
        initComponents();
        
        setupTableModelListener();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane12 = new javax.swing.JTextPane();
        ButtonSearchCheck = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtoUpdate = new javax.swing.JButton();
        ButtonReset = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        ButtonCheck = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(250, 219, 145));

        jPanel2.setBackground(new java.awt.Color(255, 161, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Alist.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("เช็ครายการสินค้า");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextPane12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPane12KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane12);

        ButtonSearchCheck.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSearchCheck.setText("ค้นหา");
        ButtonSearchCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSearchCheckActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object[30][4], // 30 แถว และ 4 คอลัมน์
            new String[]{"เลือก", "รายการ", "จำนวน", "ราคา"} // ชื่อคอลัมน์
        ) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) { // คอลัมน์ "เลือก" เป็น Boolean
                    return Boolean.class;
                } else if (columnIndex == 2) { // คอลัมน์ "จำนวน" เป็น Integer
                    return Integer.class;
                } else if (columnIndex == 3) { // คอลัมน์ "ราคา" เป็น Double
                    return Double.class;
                }
                return String.class; // ค่าเริ่มต้นเป็น String
            }
        
            @Override
            public boolean isCellEditable(int row, int column) {
                // อนุญาตให้แก้ไขคอลัมน์ "เลือก", "จำนวน", และ "ราคา"
                return column == 0 || column == 2 || column == 3;
            }
        });
        
        // ตั้งค่าฟอนต์ของเซลล์
        jTable1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 16)); // เปลี่ยนฟอนต์เป็น Tahoma
        jTable1.setRowHeight(25); // ความสูงของแถว
        
        // ตั้งค่าเส้นตาราง
        jTable1.setGridColor(new java.awt.Color(144, 238, 144)); // เส้นตารางสีเขียวอ่อน
        jTable1.setShowGrid(true);
        
        // ปรับแต่งหัวคอลัมน์
        javax.swing.table.JTableHeader header = jTable1.getTableHeader();
        header.setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16)); // เปลี่ยนฟอนต์หัวคอลัมน์เป็น Tahoma
        header.setBackground(new java.awt.Color(144, 238, 144)); // สีพื้นหลังเขียวอ่อน
        header.setForeground(java.awt.Color.BLACK); // สีข้อความหัวคอลัมน์
        
        // ตั้งค่าการจัดตำแหน่งข้อความในคอลัมน์
        javax.swing.table.DefaultTableCellRenderer centerRenderer = new javax.swing.table.DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(javax.swing.JLabel.CENTER); // จัดข้อความให้อยู่ตรงกลาง
        jTable1.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // คอลัมน์ "รายการ"
        jTable1.getColumnModel().getColumn(2).setCellRenderer(centerRenderer); // คอลัมน์ "จำนวน"
        jTable1.getColumnModel().getColumn(3).setCellRenderer(centerRenderer); // คอลัมน์ "ราคา"
        
        // **ปรับขนาดคอลัมน์**
        javax.swing.table.TableColumn columnSelect = jTable1.getColumnModel().getColumn(0);
        columnSelect.setPreferredWidth(50); // ความกว้างคอลัมน์ "เลือก"
        columnSelect.setMaxWidth(50);
        columnSelect.setMinWidth(50);
        
        javax.swing.table.TableColumn columnItem = jTable1.getColumnModel().getColumn(1);
        columnItem.setPreferredWidth(300); // ความกว้างคอลัมน์ "รายการ" ใหญ่สุด
        columnItem.setMaxWidth(400); // จำกัดขนาดสูงสุด
        columnItem.setMinWidth(200); // จำกัดขนาดต่ำสุด
        
        javax.swing.table.TableColumn columnQuantity = jTable1.getColumnModel().getColumn(2);
        columnQuantity.setPreferredWidth(80); // ความกว้างคอลัมน์ "จำนวน" เล็กลง
        columnQuantity.setMaxWidth(100);
        columnQuantity.setMinWidth(80);
        
        javax.swing.table.TableColumn columnPrice = jTable1.getColumnModel().getColumn(3);
        columnPrice.setPreferredWidth(80); // ความกว้างคอลัมน์ "ราคา" เล็กลง
        columnPrice.setMaxWidth(100);
        columnPrice.setMinWidth(80);
        
        jScrollPane13.setViewportView(jTable1);

        ButtoUpdate.setBackground(new java.awt.Color(153, 153, 255));
        ButtoUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtoUpdate.setText("อัปเดต");
        ButtoUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtoUpdateActionPerformed(evt);
            }
        });

        ButtonReset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonReset.setText("รีเซ็ต");
        ButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonResetActionPerformed(evt);
            }
        });

        Total.setFont(new java.awt.Font("Leelawadee UI", 1, 14)); // NOI18N
        Total.setText("0.00");

        ButtonCheck.setBackground(new java.awt.Color(51, 255, 0));
        ButtonCheck.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonCheck.setText("เช็ค");
        ButtonCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCheckActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(ButtonSearchCheck)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(ButtonReset)
                        .addGap(18, 18, 18)
                        .addComponent(ButtoUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonCheck)))
                .addGap(14, 14, 14))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonSearchCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ButtonCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ButtoUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Total))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jMenu3.setText("รายการ");
        jMenu3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem2.setText("เข้ารายการสินค้า");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("กำหนดงบ");
        jMenu4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem3.setText("เข้ากำหนดงบ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

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

        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem5.setText("ออกจากระบบ");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Menu menuFrame = new Menu(currentUserId, currentUsername);
        menuFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Listitem listitemFrame = new Listitem(currentUserId, currentUsername);
        listitemFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        Budget budgetFrame = new Budget(currentUserId, currentUsername);
        budgetFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        Showsearch seaechFrame = new Showsearch(currentUserId, currentUsername);
        seaechFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        Login loginFrame = new Login(currentUserId);
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void ButtonSearchCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSearchCheckActionPerformed
        String searchText = jTextPane12.getText().trim(); 
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        if (searchText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "กรุณากรอกชื่อรายการที่ต้องการเช็ค", "ข้อผิดพลาด", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            ChecklistManager checklistManager = new ChecklistManager(db);
            int userId = currentUserId; 
            List<Object[]> results = checklistManager.searchAll(searchText, userId);

            if (results.isEmpty()) { 
                JOptionPane.showMessageDialog(this, "ไม่พบข้อมูลที่ค้นหา", "ผลการค้นหา", JOptionPane.INFORMATION_MESSAGE);
            } else {
                for (Object[] row : results) {
                    model.addRow(row);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButtonSearchCheckActionPerformed

    private void ButtoUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtoUpdateActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        try {
            ChecklistManager checklistManager = new ChecklistManager(db);
            int userId = currentUserId;
            String listName = jTextPane12.getText().trim();
            boolean updateSuccess = true; 

            for (int i = 0; i < model.getRowCount(); i++) {
                String itemName = (String) model.getValueAt(i, 1);
                int quantity = (int) model.getValueAt(i, 2);
                double price = (double) model.getValueAt(i, 3);

                if (checklistManager.checkIfItemExists(userId, listName, itemName)) {
                    checklistManager.updateItem(userId, listName, itemName, quantity, price);
                } else {
                    JOptionPane.showMessageDialog(this, "ไม่พบรายการ: " + itemName, "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                    updateSuccess = false; 
                }
            }

            if (updateSuccess) { 
                checklistManager.updateShowlistTotal(userId, listName);
                List<Object[]> results = checklistManager.searchAll(listName, userId);
                model.setRowCount(0);
                for (Object[] row : results) {
                    model.addRow(row);
                }
                JOptionPane.showMessageDialog(this, "อัปเดตข้อมูลสำเร็จ!", "สำเร็จ", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButtoUpdateActionPerformed

    private void ButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonResetActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); 
        for (int i = 0; i < 30; i++) { 
            model.addRow(new Object[]{false, "", 0, 0.0});
        }
        Total.setText("0.00"); 
    }//GEN-LAST:event_ButtonResetActionPerformed


    private void ButtonCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCheckActionPerformed
        ManagerCheck managerCheck = new ManagerCheck(jTable1);
        managerCheck.checkMissingItems();
    }//GEN-LAST:event_ButtonCheckActionPerformed

    private void jTextPane12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane12KeyReleased
        String listName = jTextPane12.getText().trim();
        jTextPane12.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 15));
    }//GEN-LAST:event_jTextPane12KeyReleased
    
    private void setupTableModelListener() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.addTableModelListener(e -> {
            ChecklistManager checklistManager = new ChecklistManager(db);
            double total = checklistManager.calculateTotal(model);
            Total.setText(String.format("ยอดรวม %.2f", total)); 
        });
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
                new Check(currentUserId, currentUsername).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtoUpdate;
    private javax.swing.JButton ButtonCheck;
    private javax.swing.JButton ButtonReset;
    private javax.swing.JButton ButtonSearchCheck;
    private javax.swing.JLabel Total;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane12;
    // End of variables declaration//GEN-END:variables
}
