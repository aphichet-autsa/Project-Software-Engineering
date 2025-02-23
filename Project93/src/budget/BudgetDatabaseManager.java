package budget;

import database.DatabaseManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class BudgetDatabaseManager {
    private static final Logger LOGGER = Logger.getLogger(BudgetDatabaseManager.class.getName());
    private final DatabaseManager dbManager;

    static {
        LOGGER.setLevel(Level.WARNING); 
    }

    public BudgetDatabaseManager() {
        dbManager = new DatabaseManager();
    }

    public void saveBudget(int userId, String budgetName, double totalBudget, double remainingBudget) throws SQLException {
        try {
            dbManager.beginTransaction();

            String sqlBudget = "INSERT INTO budgets (userid, budget_name, total_budget, remaining_budget, created_at) " +
                               "VALUES (?, ?, ?, ?, NOW())";
            dbManager.executeUpdate(sqlBudget, userId, budgetName, totalBudget, remainingBudget);

            dbManager.commitTransaction();
        } finally {
            dbManager.disconnect();
        }
    }

    public void saveBudget(int userId, String budgetName, String itemName, int quantity, double price) throws SQLException {
        DatabaseManager dbManager = new DatabaseManager();
        try {
            dbManager.beginTransaction();

            String sqlItems = "INSERT INTO budget_items (userid, listname, itemname, quantity, price, created_at) " +
                              "VALUES (?, ?, ?, ?, ?, NOW())";
            dbManager.executeUpdate(sqlItems, userId, budgetName, itemName, quantity, price);

            dbManager.commitTransaction();
        } finally {
            dbManager.disconnect();
        }
    }
}
