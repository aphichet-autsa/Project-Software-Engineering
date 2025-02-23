package List;

import database.DatabaseManager;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class ListData extends ListManager {
    private static final Logger LOGGER = Logger.getLogger(ListData.class.getName());
    private double totalWithTax = 0.0;
    private JLabel calTotalLabel; 
    
    static {
        LOGGER.setLevel(Level.WARNING);
    }

    public ListData(DefaultTableModel tableModel, JLabel calTotalLabel) {
        super(tableModel);
        this.calTotalLabel = calTotalLabel; 
    }

    public double calculateTotal() {
           double total = 0.0;
           for (int i = 0; i < tableModel.getRowCount(); i++) {
               Object priceObj = tableModel.getValueAt(i, 3);
               Object quantityObj = tableModel.getValueAt(i, 2);

               if (priceObj != null && quantityObj != null) {
                   double price = Double.parseDouble(priceObj.toString().trim());
                   int quantity = Integer.parseInt(quantityObj.toString().trim());
                   total += price * quantity;
               }
           }
           return total;
       }

       public double calculateTotal(double taxRate) {
           double total = calculateTotal();
           totalWithTax = total + (total * taxRate); // อัปเดตค่าพร้อมภาษี
           return totalWithTax;
       }

       public double getTotalWithTax() {
           return totalWithTax > 0 ? totalWithTax : calculateTotal();
       }


    public void saveData(String listName, int userId) {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            dbManager.beginTransaction();

            double totalAmount = calculateTotal();
            LOGGER.fine("Total amount calculated: " + totalAmount);

            String sqlShowlist = "INSERT INTO showlist (userid, list_name, total_amount, created_at) VALUES (?, ?, ?, NOW())";
            dbManager.executeUpdate(sqlShowlist, userId, listName, totalAmount);

            dbManager.commitTransaction();
            // LOGGER.info("Showlist data added successfully!"); // ลบออก หรือเปลี่ยนเป็น LOGGER.fine()
        } catch (SQLException ex) {
            Logger.getLogger(ListData.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            dbManager.disconnect();
        }
    }

    public void saveData(int userId, String listName, String itemName, int quantity, double price) throws SQLException {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            dbManager.beginTransaction();

            double total = quantity * price;

            String sqlItems = "INSERT INTO items (userid, listname, listitem, quantity, price, total, created_at) " +
                              "VALUES (?, ?, ?, ?, ?, ?, NOW())";
            dbManager.executeUpdate(sqlItems, userId, listName, itemName, quantity, price, total);

            dbManager.commitTransaction();
            // LOGGER.info("Item data added successfully!"); // ลบออก หรือเปลี่ยนเป็น LOGGER.fine()
        } finally {
            dbManager.disconnect();
        }
    }
    
    public void updateListSummary(double taxRate) {
        double totalSpent = (taxRate > 0) ? calculateTotal(taxRate) : calculateTotal();

        if (calTotalLabel != null) {
            calTotalLabel.setText(String.format("%.2f", totalSpent));
        } else {
            LOGGER.severe("Error: calTotalLabel is null!");
        }
    }
}
