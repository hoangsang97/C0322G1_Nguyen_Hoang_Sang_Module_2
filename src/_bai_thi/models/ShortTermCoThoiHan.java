package _bai_thi.models;

public class ShortTermCoThoiHan extends Banking {
    private String deadLine;

    public ShortTermCoThoiHan() {
    }

    public ShortTermCoThoiHan(String id, int idCustomer, String starDate, String timeDate, double money, double interestRate, String deadLine) {
        super(id, idCustomer, starDate, timeDate, money, interestRate);
        this.deadLine = deadLine;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    @Override
    public String toString() {
        return "ShortTermCoThoiHan{" + super .toString() +
                "deadLine='" + deadLine + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getIdCustomer(),
                super.getStarDate(),
                super.getTimeDate(),
                super.getMoney(),
                super.getInterestRate(),
                this.getDeadLine());
    }
}
