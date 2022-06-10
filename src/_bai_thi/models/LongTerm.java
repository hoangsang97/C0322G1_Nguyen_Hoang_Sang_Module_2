package _bai_thi.models;

public class LongTerm extends Banking {
    private String deadLine;
    private String preferential;

    public LongTerm() {
    }

    public LongTerm(String id, int idCustomer, String starDate, String timeDate, double money, double interestRate, String deadLine, String preferential) {
        super(id, idCustomer, starDate, timeDate, money, interestRate);
        this.deadLine = deadLine;
        this.preferential = preferential;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getPreferential() {
        return preferential;
    }

    public void setPreferential(String preferential) {
        this.preferential = preferential;
    }

    @Override
    public String toString() {
        return "LongTerm{" + super.toString() +
                "deadLine='" + deadLine + '\'' +
                ", preferential='" + preferential + '\'' +
                '}';
    }


//    public Banking(String id, int idCustomer, String starDate, String timeDate, double money, double interestRate) {
    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getIdCustomer(),
                super.getStarDate(),
                super.getTimeDate(),
                super.getMoney(),
                super.getInterestRate(),
                this.getDeadLine(),
                this.getPreferential());
    }
}
