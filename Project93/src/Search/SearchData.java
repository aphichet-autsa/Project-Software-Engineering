package Search;

public class SearchData {
    private String name;
    private double amount;
    private String date;

    public SearchData(String name, double amount, String date) {
        this.name = name;
        this.amount = amount;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "SearchData{" +
               "name='" + name + '\'' +
               ", amount=" + amount +
               ", date='" + date + '\'' +
               '}';
    }
}
