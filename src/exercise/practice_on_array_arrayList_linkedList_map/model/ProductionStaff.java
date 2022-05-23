package exercise.practice_on_array_arrayList_linkedList_map.model;

public class ProductionStaff extends Staff {
    private int productNumber;

    public ProductionStaff() {
    }

    @Override
    public int employeeSalary() {
        return this.productNumber * 50000;
    }

    public ProductionStaff(String fullName, int yearOfBirth, String address, int productNumber) {
        super(fullName, yearOfBirth, address);
        this.productNumber = productNumber;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    @Override
    public String toString() {
        return "ProductionStaff{" + super.toString() +
                "productNumber=" + productNumber +
                '}';
    }
}
