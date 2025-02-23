package main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import database.DatabaseManager;

public class ChecklistManager extends CheckSearch { 
    public ChecklistManager(DatabaseManager db) {
        super(db);
    }

    @Override
    public List<Object[]> search(String searchText) throws Exception {
        return search(searchText, null);
    }
    
    public List<Object[]> search(String searchText, Integer userId) throws Exception {
        List<Object[]> results = new ArrayList<>();
        String query = "SELECT listitem AS item_name, quantity, price FROM items WHERE listname LIKE ?";

        if (userId != null) {
            query += " AND userid = ?";
        }

        try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {
            ps.setString(1, "%" + searchText + "%");

            if (userId != null) {
                ps.setInt(2, userId);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                results.add(new Object[]{
                    false,
                    rs.getString("item_name"),
                    rs.getInt("quantity"),
                    rs.getDouble("price")
                });
            }
        }
        return results;
    }

    public List<Object[]> searchAll(String searchText, int userId) throws Exception {
        return search(searchText, userId);
    }

    public double calculateTotal(DefaultTableModel model) {
        double total = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            int quantity = (int) model.getValueAt(i, 2);
            double price = (double) model.getValueAt(i, 3);
            total += quantity * price;
        }
        return total;
    }

    public void updateItem(int userId, String listName, String itemName, int quantity, double price) throws Exception {
        String query = "UPDATE items SET quantity = ?, price = ?, total = ? WHERE userid = ? AND listname = ? AND listitem = ?";
        double total = quantity * price;

        try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {
            ps.setInt(1, quantity);
            ps.setDouble(2, price);
            ps.setDouble(3, total);
            ps.setInt(4, userId);
            ps.setString(5, listName.trim());
            ps.setString(6, itemName.trim());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new Exception("ไม่พบรายการ: " + itemName + " ใน " + listName + " ของผู้ใช้ " + userId);
            }
        }
    }

    public boolean checkIfItemExists(int userId, String listName, String itemName) throws Exception {
        String query = "SELECT COUNT(*) FROM items WHERE userid = ? AND listname = ? AND listitem = ?";
        try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.setString(2, listName);
            ps.setString(3, itemName);
            ResultSet rs = ps.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        }
    }

    public void updateShowlistTotal(int userId, String listName) throws Exception {
        String query = "UPDATE showlist SET total_amount = (SELECT COALESCE(SUM(total), 0) FROM items WHERE userid = ? AND listname = ?) WHERE userid = ? AND list_name = ?";

        try (PreparedStatement ps = db.getConnection().prepareStatement(query)) {
            ps.setInt(1, userId);
            ps.setString(2, listName.trim());
            ps.setInt(3, userId);
            ps.setString(4, listName.trim());
            ps.executeUpdate();
        }
    }
}
