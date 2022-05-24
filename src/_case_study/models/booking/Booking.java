package _case_study.models.booking;

import _case_study.models.person.Customer;
import _case_study.models.facility.Facility;

public class Booking {
    private Integer idBooking;
    private String starDate;
    private String endDate;
    private Customer customer;
    private Facility facility;

    public Booking() {
    }

    public Booking(Integer idBooking, String starDate, String endDate, Customer customer, Facility facility) {
        this.idBooking = idBooking;
        this.starDate = starDate;
        this.endDate = endDate;
        this.customer = customer;
        this.facility = facility;
    }

    public Integer getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Integer idBooking) {
        this.idBooking = idBooking;
    }

    public String getStarDate() {
        return starDate;
    }

    public void setStarDate(String starDate) {
        this.starDate = starDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", starDate='" + starDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customer=" + customer.getId() +
                ", facility=" + facility.getIdFacility() +
                '}';
    }
}
