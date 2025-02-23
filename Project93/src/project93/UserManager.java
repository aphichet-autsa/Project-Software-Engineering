package project93;

import database.DatabaseManager;

public class UserManager {
    protected DatabaseManager db;

    public UserManager(DatabaseManager db) {
        this.db = db;
    }
}
