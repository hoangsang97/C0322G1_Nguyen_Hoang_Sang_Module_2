package _case_study.models;

public class Customer extends Person{
    private int customerIsCode;
    private int fullName;
    private int dateOfBirth;
    private boolean gender;
    private int iDNumber;
    private int phoneNumber;
    private String email;
    private int typeOfGuest;
    private String address;

    public Customer() {
    }

    public Customer(int customerIsCode, int fullName, int dateOfBirth, boolean gender, int iDNumber, int phoneNumber, String email, int typeOfGuest, String address) {
        this.customerIsCode = customerIsCode;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.iDNumber = iDNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfGuest = typeOfGuest;
        this.address = address;
    }

    public int getCustomerIsCode() {
        return customerIsCode;
    }

    public void setCustomerIsCode(int customerIsCode) {
        this.customerIsCode = customerIsCode;
    }

    public int getFullName() {
        return fullName;
    }

    public void setFullName(int fullName) {
        this.fullName = fullName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getiDNumber() {
        return iDNumber;
    }

    public void setiDNumber(int iDNumber) {
        this.iDNumber = iDNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTypeOfGuest() {
        return typeOfGuest;
    }

    public void setTypeOfGuest(int typeOfGuest) {
        this.typeOfGuest = typeOfGuest;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerIsCode=" + customerIsCode +
                ", fullName=" + fullName +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                ", iDNumber=" + iDNumber +
                ", phoneNumber=" + phoneNumber +
                ", email='" + email + '\'' +
                ", typeOfGuest=" + typeOfGuest +
                ", address='" + address + '\'' +
                '}';
    }
}
