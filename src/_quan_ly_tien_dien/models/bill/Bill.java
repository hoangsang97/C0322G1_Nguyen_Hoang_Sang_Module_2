package _quan_ly_tien_dien.models.bill;

import _quan_ly_tien_dien.models.customer.Customer;

public class Bill extends Customer {
    private String billId;
    private String dateBill;
    private double amount;
    private double price;
    private double TotalMoney;

    public Bill() {
    }

    public Bill(String id, String name, String billId, String dateBill, double amount, double price, double totalMoney) {
        super(id, name);
        this.billId = billId;
        this.dateBill = dateBill;
        this.amount = amount;
        this.price = price;
        TotalMoney = totalMoney;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public String getDateBill() {
        return dateBill;
    }

    public void setDateBill(String dateBill) {
        this.dateBill = dateBill;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Bill{" + super.toString() +
                "billId='" + billId + '\'' +
                ", dateBill='" + dateBill + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", TotalMoney=" + TotalMoney +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getName(),
                this.getBillId(),
                this.getDateBill(),
                this.getAmount(),
                this.getPrice(),
                this.getTotalMoney());
    }
}
