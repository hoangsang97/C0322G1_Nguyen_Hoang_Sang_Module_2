package _case_study.models.person;

public class Customer extends Person{
    private String typeCustomer;
    private String address;

    public Customer() {
    }

    @Override
    public String getInfo() {
        return null;
    }

    public Customer(int id, String name, int age, String sex, String idCard, String email, String typeCustomer, String address) {
        super(id, name, age, sex, idCard, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public Customer(String typeCustomer, String address) {
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" + super.toString() +
                "typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
