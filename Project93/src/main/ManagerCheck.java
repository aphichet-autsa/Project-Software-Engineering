package main;

import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ManagerCheck extends CheckBase {
    private JTable jTable1;

    public ManagerCheck(JTable jTable) {
        super(""); 
        this.jTable1 = jTable;
    }

    @Override
    public void showMessage() {
        JOptionPane.showMessageDialog(null, message, "Notification", JOptionPane.INFORMATION_MESSAGE);
    }

    public void checkMissingItems() {
        StringBuilder missingItems = new StringBuilder();

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Boolean isChecked = (Boolean) jTable1.getValueAt(i, 0);
            String itemName = (String) jTable1.getValueAt(i, 1);

            if (isChecked == null || !isChecked) {
                missingItems.append("- ").append(itemName).append("\n");
            }
        }

        if (missingItems.length() > 0) {
            this.message = "แจ้งเตือน:\nกรุณาตรวจสอบรายการซื้อสินค้าให้เรียบร้อย:\n" + missingItems.toString();
        } else {
            this.message = "แจ้งเตือน:\nคุณซื้อครบทุกอย่างแล้ว!";
        }

        showMessage(); 
    }
}
