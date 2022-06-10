package _bai_thi.models;

public class ShortTermVoThoiHan extends Banking{
    public ShortTermVoThoiHan() {
    }

    public ShortTermVoThoiHan(String id, int idCustomer, String starDate, String timeDate, double money, double interestRate) {
        super(id, idCustomer, starDate, timeDate, money, interestRate);
    }

    @Override
    public String toString() {
        return "ShortTermVoThoiHan{" + super.toString() + "}";
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getIdCustomer(),
                super.getStarDate(),
                super.getTimeDate(),
                super.getMoney(),
                super.getInterestRate());
    }
}
