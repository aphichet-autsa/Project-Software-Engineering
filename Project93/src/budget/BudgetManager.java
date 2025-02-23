package budget;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;

public class BudgetManager extends BudgetBase {
    private static final Logger LOGGER = Logger.getLogger(BudgetManager.class.getName());
    
    private final boolean isDynamic;

    public BudgetManager(DefaultTableModel tableModel, double budget, JLabel remainingBudgetLabel, boolean isDynamic) {
        super(tableModel, budget, remainingBudgetLabel);
        this.isDynamic = isDynamic;
    }

    @Override
    public double calculateTotalSpent() {
        double total = 0.0;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Object priceObj = tableModel.getValueAt(i, 3);
            Object quantityObj = tableModel.getValueAt(i, 2);

            try {
                if (priceObj != null && quantityObj != null) {
                    double price = Double.parseDouble(priceObj.toString().trim());
                    int quantity = Integer.parseInt(quantityObj.toString().trim());
                    total += price * quantity;
                }
            } catch (NumberFormatException e) {
                LOGGER.warning("Invalid data at row " + (i + 1));
            }
        }
        return total;
    }

    public void adjustBudget(double adjustment) {
        if (isDynamic) {
            this.budget += adjustment;
        } else {
            LOGGER.warning("Cannot adjust a fixed budget!");
        }
    }
}
