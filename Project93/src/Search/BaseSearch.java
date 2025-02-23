package Search;

import database.DatabaseManager;
import java.util.List;

public abstract class BaseSearch {
    protected DatabaseManager dbManager;

    public BaseSearch(DatabaseManager dbManager) {
        this.dbManager = dbManager;
    }

    public abstract List<SearchData> fetchData(int userId, String date, String listName);
}
