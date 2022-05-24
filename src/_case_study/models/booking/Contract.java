package _case_study.models.booking;

import _case_study.models.person.Customer;

public class Contract {
    private Integer idContract;
    private Booking booking;
    private String pre;
    private String pay;
    private Customer customer;

    public Contract() {
    }

    public Contract(Integer idContract, Booking booking, String pre, String pay, Customer customer) {
        this.idContract = idContract;
        this.booking = booking;
        this.pre = pre;
        this.pay = pay;
        this.customer = customer;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public String getPre() {
        return pre;
    }

    public void setPre(String pre) {
        this.pre = pre;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract=" + idContract +
                ", booking=" + booking.getIdBooking() +
                ", pre='" + pre + '\'' +
                ", pay='" + pay + '\'' +
                ", customer=" + customer.getId() +
                '}';
    }
}
