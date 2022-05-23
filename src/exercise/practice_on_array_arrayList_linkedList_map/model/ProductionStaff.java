package exercise.practice_on_array_arrayList_linkedList_map.model;

import exercise.practice_on_array_arrayList_linkedList_map.service.ITimeKeepingService;

public class ProductionStaff extends Staff implements ITimeKeepingService {
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

    @Override
    public int compareTo(Staff o) {
        if (this.getYearOfBirth() > o.getYearOfBirth()) {
            return 1;
        }else if (this.getYearOfBirth() < o.getYearOfBirth()) {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    public void timeKeeping() {
        System.out.println("Đã chấm công!");
    }
}
