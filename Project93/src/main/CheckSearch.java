package main;

import java.util.List;
import database.DatabaseManager;

public abstract class CheckSearch {
    protected DatabaseManager db;

    public CheckSearch(DatabaseManager db) {
        this.db = db;
    }

    public abstract List<Object[]> search(String searchText) throws Exception;

}
