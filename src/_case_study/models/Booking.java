package _case_study.models;

public class Booking {
    private int bookingCode;
    private int startDay;
    private int endDate;
    private int customerIsCode;
    private int serviceName;
    private int typeOfService;

    public Booking() {
    }

    public Booking(int bookingCode, int startDay, int endDate, int customerIsCode, int serviceName, int typeOfService) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDate = endDate;
        this.customerIsCode = customerIsCode;
        this.serviceName = serviceName;
        this.typeOfService = typeOfService;
    }

    public int getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(int bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getStartDay() {
        return startDay;
    }

    public void setStartDay(int startDay) {
        this.startDay = startDay;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public int getCustomerIsCode() {
        return customerIsCode;
    }

    public void setCustomerIsCode(int customerIsCode) {
        this.customerIsCode = customerIsCode;
    }

    public int getServiceName() {
        return serviceName;
    }

    public void setServiceName(int serviceName) {
        this.serviceName = serviceName;
    }

    public int getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(int typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode=" + bookingCode +
                ", startDay=" + startDay +
                ", endDate=" + endDate +
                ", customerIsCode=" + customerIsCode +
                ", serviceName=" + serviceName +
                ", typeOfService=" + typeOfService +
                '}';
    }
}
