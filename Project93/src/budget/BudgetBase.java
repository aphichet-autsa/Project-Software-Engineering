package budget;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Logger;
import java.util.logging.Level;

public abstract class BudgetBase {
    private static final Logger LOGGER = Logger.getLogger(BudgetBase.class.getName());
    
    protected DefaultTableModel tableModel;
    protected double budget;
    protected JLabel remainingBudgetLabel;

    public BudgetBase(DefaultTableModel tableModel, double budget, JLabel remainingBudgetLabel) {
        if (tableModel == null || remainingBudgetLabel == null) {
            throw new IllegalArgumentException("TableModel and RemainingBudgetLabel cannot be null.");
        }
        this.tableModel = tableModel;
        this.budget = budget;
        this.remainingBudgetLabel = remainingBudgetLabel;
    }

    public void setInputText(String inputText) {
        if (inputText != null) {
            try {
                setInputText(Double.parseDouble(inputText.trim()));
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Invalid budget input: " + inputText, e);
            }
        }
    }

    public void setInputText(double inputBudget) {
        if (inputBudget >= 0) {
            this.budget = inputBudget;
        } else {
            LOGGER.warning("Attempted to set a negative budget: " + inputBudget);
        }
    }

    public double getBudget() {
        return budget;
    }

    public void updateRemainingBudget() {
        remainingBudgetLabel.setText(String.format("%.2f", getRemainingBudget()));
    }

    public double getRemainingBudget() {
        return budget - calculateTotalSpent();
    }

    public abstract double calculateTotalSpent();

    public double calculateTotalSpent(double taxRate) {
        return calculateTotalSpent() * (1 + taxRate);
    }
}
