package Search;

import database.DatabaseManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GenericSearch extends BaseSearch {

    public GenericSearch(DatabaseManager dbManager) {
        super(dbManager);
    }

    public List<SearchData> fetchData(int userId, String date, String listName) {
        List<SearchData> results = new ArrayList<>();

        String queryShowlist = "SELECT list_name AS name, total_amount AS amount, created_at AS date "
                             + "FROM mydb.showlist WHERE userid = ?";
        String queryBudget = "SELECT budget_name AS name, used_budget AS amount, created_at AS date "
                            + "FROM mydb.budgets WHERE userid = ?";

        try (Connection conn = dbManager.connect()) {
            if (date != null && !date.isEmpty()) {
                if (date.matches("\\d{4}")) { // Year only
                    queryShowlist += " AND YEAR(created_at) = ?";
                    queryBudget += " AND YEAR(created_at) = ?";
                } else if (date.matches("\\d{4}-\\d{2}")) { // Year and month
                    queryShowlist += " AND DATE_FORMAT(created_at, '%Y-%m') = ?";
                    queryBudget += " AND DATE_FORMAT(created_at, '%Y-%m') = ?";
                } else if (date.matches("\\d{4}-\\d{2}-\\d{2}")) { // Full date
                    queryShowlist += " AND DATE(created_at) = ?";
                    queryBudget += " AND DATE(created_at) = ?";
                } else {
                    throw new IllegalArgumentException("Invalid date format");
                }
            }

            if (listName != null && !listName.isEmpty()) {
                queryShowlist += " AND list_name LIKE ?";
                queryBudget += " AND budget_name LIKE ?";
            }
            
            try (PreparedStatement ps = conn.prepareStatement(queryShowlist)) {
                ps.setInt(1, userId);
                int paramIndex = 2;

                if (date != null && !date.isEmpty()) {
                    ps.setString(paramIndex++, date);
                }
                if (listName != null && !listName.isEmpty()) {
                    ps.setString(paramIndex, "%" + listName + "%");
                }

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    results.add(new SearchData(
                        rs.getString("name"),
                        rs.getDouble("amount"),
                        rs.getString("date")
                    ));
                }
            }

            try (PreparedStatement ps = conn.prepareStatement(queryBudget)) {
                ps.setInt(1, userId);
                int paramIndex = 2;

                if (date != null && !date.isEmpty()) {
                    ps.setString(paramIndex++, date);
                }
                if (listName != null && !listName.isEmpty()) {
                    ps.setString(paramIndex, "%" + listName + "%");
                }

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    results.add(new SearchData(
                        rs.getString("name"),
                        rs.getDouble("amount"),
                        rs.getString("date")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

}
