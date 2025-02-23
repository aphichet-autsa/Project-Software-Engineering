package Search;

import database.DatabaseManager;
import java.util.List;

public class CalculatorSearch extends BaseSearch {

    public CalculatorSearch(DatabaseManager dbManager) {
        super(dbManager);
    }

    @Override
    public List<SearchData> fetchData(int userId, String date, String listName) {
        throw new UnsupportedOperationException("CalculatorSearch ไม่ได้จัดการ fetch ข้อมูล");
    }

    public double calculateTotal(List<SearchData> searchDataList) {
        double total = 0.0;
        for (SearchData data : searchDataList) {
            total += data.getAmount();
        }
        return total;
    }
}
