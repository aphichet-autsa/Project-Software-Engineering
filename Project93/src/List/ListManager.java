package List;

import javax.swing.table.DefaultTableModel;

public abstract class ListManager {
    protected DefaultTableModel tableModel;

    public ListManager(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    protected boolean validateData(Object priceObj, Object quantityObj) {
        try {
            if (priceObj != null && quantityObj != null) {
                Double.parseDouble(priceObj.toString().trim());
                Integer.parseInt(quantityObj.toString().trim());
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public abstract double calculateTotal();
    public abstract double calculateTotal(double taxRate);

    public abstract void saveData(String listName, int userId);
    
}
