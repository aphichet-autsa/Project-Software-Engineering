package Search;

import database.DatabaseManager;
import java.util.List;

public class DataSorter extends BaseSearch {

    public DataSorter(DatabaseManager dbManager) {
        super(dbManager);
    }

    @Override
    public List<SearchData> fetchData(int userId, String date, String listName) {
        throw new UnsupportedOperationException("DataSorter ไม่ได้จัดการ fetch ข้อมูล");
    }

    public static void quickSortByDate(List<SearchData> data, int low, int high) {
        if (low < high) {
            int pi = partitionByDate(data, low, high);

            quickSortByDate(data, low, pi - 1);
            quickSortByDate(data, pi + 1, high);
        }
    }

    private static int partitionByDate(List<SearchData> data, int low, int high) {
        String pivot = data.get(high).getDate();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (data.get(j).getDate().compareTo(pivot) <= 0) {
                i++;
                swap(data, i, j);
            }
        }

        swap(data, i + 1, high);
        return i + 1;
    }

    public static void quickSortByAmountDescending(List<SearchData> data, int low, int high) {
        if (low < high) {
            int pi = partitionByAmountDescending(data, low, high);

            quickSortByAmountDescending(data, low, pi - 1);
            quickSortByAmountDescending(data, pi + 1, high);
        }
    }

    private static int partitionByAmountDescending(List<SearchData> data, int low, int high) {
        double pivot = data.get(high).getAmount();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (data.get(j).getAmount() >= pivot) {
                i++;
                swap(data, i, j);
            }
        }

        swap(data, i + 1, high);
        return i + 1;
    }

    public static void quickSortByName(List<SearchData> data, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partitionByName(data, low, high, ascending);

            quickSortByName(data, low, pi - 1, ascending);
            quickSortByName(data, pi + 1, high, ascending);
        }
    }

    private static int partitionByName(List<SearchData> data, int low, int high, boolean ascending) {
        String pivot = data.get(high).getName();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if ((ascending && data.get(j).getName().compareToIgnoreCase(pivot) <= 0) ||
                (!ascending && data.get(j).getName().compareToIgnoreCase(pivot) >= 0)) {
                i++;
                swap(data, i, j);
            }
        }

        swap(data, i + 1, high);
        return i + 1;
    }

    private static void swap(List<SearchData> data, int i, int j) {
        SearchData temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}
