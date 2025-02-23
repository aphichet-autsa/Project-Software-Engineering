package project93;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class Test extends javax.swing.JFrame {
    private int currentUserId;
    private String currentUsername; 
    private int userid;
    
    public Test() {
        initComponents();
                this.setTitle("Market Payment System");

        ImageIcon icon = new ImageIcon(getClass().getResource("/img/LOGOICON.png"));
        this.setIconImage(icon.getImage());
      
        this.setLocationRelativeTo(null); 
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
                }
            }
        }
        Total.setText(String.format("%.2f", total)); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButtonCalculateTest = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        ButtonNextRegister = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 177, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LSS1.png"))); // NOI18N
        jLabel12.setText("jLabel4");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("ทดลองรายการสินค้า");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16)); // ฟอนต์หัวตาราง
        jTable1.setFont(new Font("Tahoma", Font.PLAIN, 16)); // ฟอนต์เนื้อหาในตาราง
        jTable1.setRowHeight(25); // ตั้งค่าความสูงของแถว

        // ตั้งค่า DefaultTableModel พร้อมแถวว่าง 50 แถว
        jTable1.setModel(new DefaultTableModel(
            new Object[50][4], // 50 แถว และ 4 คอลัมน์
            new String[]{"ลำดับ", "รายการ", "จำนวน", "ราคา"}
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column != 0; // ไม่ให้แก้ไขคอลัมน์ "ลำดับ"
            }
        });

        // ตั้งค่าความกว้างของคอลัมน์
        for (int i = 0; i < jTable1.getColumnModel().getColumnCount(); i++) {
            TableColumn column = jTable1.getColumnModel().getColumn(i);
            if (i == 0) { 
                column.setPreferredWidth(50); // คอลัมน์ "ลำดับ"
            } else if (i == 1) {
                column.setPreferredWidth(200); // คอลัมน์ "รายการ"
            } else {
                column.setPreferredWidth(100); // คอลัมน์ "จำนวน" และ "ราคา"
            }
        }

        // เติมค่าลำดับอัตโนมัติ
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0); // คอลัมน์ที่ 0 คือ "ลำดับ"
        }

        // ตั้งฟอนต์สำหรับ DefaultCellEditor เพื่อให้พิมพ์ภาษาไทยได้
        DefaultCellEditor cellEditor = (DefaultCellEditor) jTable1.getDefaultEditor(Object.class);
        JTextField textField = (JTextField) cellEditor.getComponent();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 16));

        // ตั้งค่าการแสดงผลเซลล์ (เพิ่มเส้นขอบสีเทา)
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                                            boolean isSelected, boolean hasFocus,
                                                            int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                label.setBorder(new LineBorder(Color.GRAY, 1)); // เส้นขอบสีเทา 1 pixel
                return label;
            }
        };

        // ใช้ Renderer กับทุกคอลัมน์ของ jTable1
        for (int i = 0; i < jTable1.getColumnCount(); i++) {
            jTable1.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }

        // ตั้งค่าหัวตาราง (สีเทา และฟอนต์ Tahoma)
        JTableHeader header = jTable1.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Tahoma", Font.BOLD, 16));

        // จัดให้คอลัมน์ "ลำดับ" อยู่ตรงกลาง
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTable1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

                
        jScrollPane1.setViewportView(jTable1);

        ButtonCalculateTest.setBackground(new java.awt.Color(153, 153, 255));
        ButtonCalculateTest.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonCalculateTest.setText("คำนวณ");
        ButtonCalculateTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCalculateTestActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("ยอดใช้จ่าย");

        Total.setFont(new java.awt.Font("Leelawadee UI", 1, 12)); // NOI18N
        Total.setText("0.00");

        ButtonNextRegister.setBackground(new java.awt.Color(255, 153, 0));
        ButtonNextRegister.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ButtonNextRegister.setText("สมัครสมาชิก");
        ButtonNextRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonNextRegisterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ButtonCalculateTest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ButtonNextRegister))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonNextRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonCalculateTest, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Total)
                    .addComponent(jLabel1))
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

    private void ButtonCalculateTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCalculateTestActionPerformed
        if (jTable1.isEditing()) {
        jTable1.getCellEditor().stopCellEditing();
        } 
        calculateTotal();
    }//GEN-LAST:event_ButtonCalculateTestActionPerformed

    private void ButtonNextRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonNextRegisterActionPerformed
        Register registerFrame = new Register(currentUserId, currentUsername);
        registerFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ButtonNextRegisterActionPerformed

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCalculateTest;
    private javax.swing.JButton ButtonNextRegister;
    private javax.swing.JLabel Total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
