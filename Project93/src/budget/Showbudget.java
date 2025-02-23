package budget;

import List.Listitem;
import Search.Showsearch;
import com.formdev.flatlaf.FlatLightLaf;
import database.DatabaseManager;
import java.awt.Color;
import java.awt.Component;
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
import project93.LoginManager;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Showbudget extends javax.swing.JFrame {
    private static final Logger LOGGER = Logger.getLogger(Showbudget.class.getName());
    
    private BudgetBase budgetManager;
    private BudgetDatabaseManager budgetDbManager;
    private int budgetId = 1; 
    
    private int currentUserId;
    private String currentUsername; 
    private DatabaseManager db;
    private int userid;

     public Showbudget(int currentUserId, String currentUsername) {
        this.currentUserId = currentUserId;
        this.currentUsername = currentUsername;
        
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        budgetManager = new BudgetManager(model, 0.0, jLabel5, false);
        
        budgetDbManager = new BudgetDatabaseManager();
        setupTableListener();
        
        setLocationRelativeTo(null);
    }
    
    private void updateBudgetSummary() {
        try {
            budgetManager.updateRemainingBudget();
            double totalSpent = budgetManager.calculateTotalSpent();
            double remaining = budgetManager.getBudget() - totalSpent;

            jLabel5.setText(String.format("%.2f", remaining));
            UseTotal.setText(String.format("%.2f", totalSpent));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error updating budget summary", e);
        }
    }

    private void updateBudgetSummary(double taxRate) {
        try {
            budgetManager.updateRemainingBudget();
            double totalSpent = budgetManager.calculateTotalSpent(taxRate);
            double remaining = budgetManager.getBudget() - totalSpent;

            jLabel5.setText(String.format("%.2f", remaining));
            UseTotal.setText(String.format("%.2f", totalSpent));
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error updating budget summary", e);
        }
    }

    private void setupTableListener() {
        jTable1.getModel().addTableModelListener(evt -> {
            updateBudgetSummary(); 
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonSaveBudget = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Total = new javax.swing.JLabel();
        UseTotal = new javax.swing.JLabel();
        ButtonCalculateTax = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 161, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/BLOGO.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("กำหนดงบประมาณ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(24, 24, 24))))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("จำนวนเงินคงเหลือ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ใส่จำนวนเงิน");

            // ฟอนต์หัวตาราง
        jTable1.getTableHeader().setFont(new java.awt.Font("Tahoma", java.awt.Font.BOLD, 16)); 

        // ฟอนต์ข้อมูลในตาราง
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
        header.setFont(new Font("Tahoma", Font.BOLD, 16)); // กำหนดฟอนต์ของหัวตาราง

        // *** จัดให้คอลัมน์ "ลำดับ" อยู่ตรงกลาง ***
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

        jScrollPane3.setViewportView(jTable1);

        ButtonSaveBudget.setBackground(new java.awt.Color(51, 255, 51));
        ButtonSaveBudget.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonSaveBudget.setText("บันทีก");
        ButtonSaveBudget.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonSaveBudgetActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Leelawadee UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("0.00");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
        jLabel5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jLabel5KeyReleased(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        Total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Total.setText("ใช้ไปแล้ว");

        UseTotal.setText("0.00");

        ButtonCalculateTax.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonCalculateTax.setText("ภาษี");
        ButtonCalculateTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCalculateTaxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(13, 13, 13))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(UseTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonCalculateTax)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonSaveBudget, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonSaveBudget)
                    .addComponent(Total)
                    .addComponent(UseTotal)
                    .addComponent(ButtonCalculateTax))
                .addContainerGap())
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ชื่อรายการ");

        jTextPane1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextPane1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/MINILOGO.png"))); // NOI18N
        jMenuBar1.add(jMenu6);

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

        jMenu7.setText("ตั้งค่า");
        jMenu7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem5.setText("เข้าตั้งค่า");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuBar1.add(jMenu7);

        jMenu8.setText("ออก");
        jMenu8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem6.setText("หน้าเข้าสู่ระบบ");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem6);

        jMenuItem3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jMenuItem3.setText("ออกจากระบบ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu8.add(jMenuItem3);

        jMenuBar1.add(jMenu8);

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

    private void jLabel5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel5KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5KeyReleased

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        try {
            String inputText = jTextField1.getText().trim();
            budgetManager.setInputText(inputText); 
            budgetManager.updateRemainingBudget(); 
            updateBudgetSummary();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    
    private void ButtonSaveBudgetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonSaveBudgetActionPerformed
        UIManager.put("OptionPane.messageFont", new Font("Tahoma", Font.PLAIN, 15));
        UIManager.put("OptionPane.buttonFont", new Font("Tahoma", Font.PLAIN, 15));

        try {
            String budgetName = jTextPane1.getText().trim();
            double totalBudget = Double.parseDouble(jTextField1.getText().trim());
            double remainingBudget = Double.parseDouble(jLabel5.getText().trim());

            if (budgetName.isEmpty() || totalBudget <= 0) {
                throw new IllegalArgumentException("กรุณากรอกข้อมูลที่ถูกต้อง");
            }

            int userId = LoginManager.getCurrentUserId();
            String username = LoginManager.getCurrentUserName();

            if (userId <= 0 || username == null || username.isEmpty()) {
                JOptionPane.showMessageDialog(this, "กรุณาล็อกอินก่อนทำรายการ", "ข้อผิดพลาด", JOptionPane.ERROR_MESSAGE);
                return;
            }
            budgetDbManager.saveBudget(userId, budgetName, totalBudget, remainingBudget);

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            for (int i = 0; i < model.getRowCount(); i++) {
                Object itemName = model.getValueAt(i, 1);
                Object quantityObj = model.getValueAt(i, 2);
                Object priceObj = model.getValueAt(i, 3);

                if (itemName != null && quantityObj != null && priceObj != null) {
                    int quantity = Integer.parseInt(quantityObj.toString().trim());
                    double price = Double.parseDouble(priceObj.toString().trim());

                    budgetDbManager.saveBudget(userId, budgetName, itemName.toString(), quantity, price);
                }
            }

            JOptionPane.showMessageDialog(this, "บันทึกข้อมูลสำเร็จ", "สำเร็จ", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error saving budget", e);
            JOptionPane.showMessageDialog(this, "เกิดข้อผิดพลาดในการบันทึกข้อมูล", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ButtonSaveBudgetActionPerformed

    private void jTextPane1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextPane1KeyReleased
        String listName = jTextPane1.getText().trim();
        jTextPane1.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
    }//GEN-LAST:event_jTextPane1KeyReleased

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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void ButtonCalculateTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCalculateTaxActionPerformed
        try {
            double taxRate = 0.07;
            double totalWithTax = budgetManager.calculateTotalSpent(taxRate);
            UseTotal.setText(String.format("%.2f", totalWithTax));
            double remaining = budgetManager.getBudget() - totalWithTax;
            jLabel5.setText(String.format("%.2f", remaining));

        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error calculating tax", e);
        }
    }//GEN-LAST:event_ButtonCalculateTaxActionPerformed
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(() -> {
            int currentUserId = 1;
            String currentUsername = "admin";
            new Showbudget(currentUserId, currentUsername).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCalculateTax;
    private javax.swing.JButton ButtonSaveBudget;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel UseTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
