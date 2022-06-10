package _bai_thi.models;

public abstract class Banking {
    private String id;
    private int idCustomer;
    private String starDate;
    private String timeDate;
    private double money;
    private double interestRate;


    public Banking() {
    }

    public Banking(String id, int idCustomer, String starDate, String timeDate, double money, double interestRate) {
        this.id = id;
        this.idCustomer = idCustomer;
        this.starDate = starDate;
        this.timeDate = timeDate;
        this.money = money;
        this.interestRate = interestRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(String timeDate) {
        this.timeDate = timeDate;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Banking{" +
                "id='" + id + '\'' +
                ", idCustomer=" + idCustomer +
                ", starDate='" + starDate + '\'' +
                ", timeDate='" + timeDate + '\'' +
                ", money=" + money +
                ", interestRate=" + interestRate +
                '}';
    }

    public abstract String getInfo();
}
