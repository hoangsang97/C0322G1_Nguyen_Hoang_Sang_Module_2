package _quan_ly_nhan_vien.models;

public class ManagementStaff extends Staff{
    private double salary;
    private double coefficientsSalary;

    public ManagementStaff() {
    }

    public ManagementStaff(int id, String name, String dateOfBirth, String address, double salary, double coefficientsSalary) {
        super(id, name, dateOfBirth, address);
        this.salary = salary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    @Override
    public String toString() {
        return "ManagementStaff{" + super.toString() +
                "salary=" + salary +
                ", coefficientsSalary=" + coefficientsSalary +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getName(),
                super.getDateOfBirth(),
                super.getAddress(),
                this.getSalary(),
                this.getCoefficientsSalary(),
                "Quản lý");
    }
}
