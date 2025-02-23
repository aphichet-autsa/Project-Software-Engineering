package project93;

import java.sql.ResultSet;
import database.DatabaseManager;

public class LoginManager extends UserManager {
    private static int currentUserId;
    private static String currentUserName;

    public LoginManager(DatabaseManager db) {
        super(db);
    }

    public boolean authenticate(String username, String password) {
        try {
            String query = "SELECT userid, username FROM user WHERE username = ? AND password = ?";
            ResultSet rs = db.executeQuery(query, username, password);
            if (rs.next()) {
                currentUserId = rs.getInt("userid");
                currentUserName = rs.getString("username");
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.disconnect();
        }
        return false;
    }

    public static int getCurrentUserId() {
        return currentUserId;
    }

    public static String getCurrentUserName() {
        return currentUserName;
    }
}

