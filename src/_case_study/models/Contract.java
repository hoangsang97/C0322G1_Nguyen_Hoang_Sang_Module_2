package _case_study.models;

public class Contract {
    private int someContracts;
    private int bookingCode;
    private double advanceDepositAmount;
    private double totalPaymentAmount;
    private int customerIsCode;

    public Contract() {
    }

    public Contract(int someContracts, int bookingCode, double advanceDepositAmount, double totalPaymentAmount, int customerIsCode) {
        this.someContracts = someContracts;
        this.bookingCode = bookingCode;
        this.advanceDepositAmount = advanceDepositAmount;
        this.totalPaymentAmount = totalPaymentAmount;
        this.customerIsCode = customerIsCode;
    }

    public int getSomeContracts() {
        return someContracts;
    }

    public void setSomeContracts(int someContracts) {
        this.someContracts = someContracts;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public double getAdvanceDepositAmount() {
        return advanceDepositAmount;
    }

    public void setAdvanceDepositAmount(double advanceDepositAmount) {
        this.advanceDepositAmount = advanceDepositAmount;
    }

    public double getTotalPaymentAmount() {
        return totalPaymentAmount;
    }

    public void setTotalPaymentAmount(double totalPaymentAmount) {
        this.totalPaymentAmount = totalPaymentAmount;
    }

    public int getCustomerIsCode() {
        return customerIsCode;
    }

    public void setCustomerIsCode(int customerIsCode) {
        this.customerIsCode = customerIsCode;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "someContracts=" + someContracts +
                ", bookingCode=" + bookingCode +
                ", advanceDepositAmount=" + advanceDepositAmount +
                ", totalPaymentAmount=" + totalPaymentAmount +
                ", customerIsCode=" + customerIsCode +
                '}';
    }
}
