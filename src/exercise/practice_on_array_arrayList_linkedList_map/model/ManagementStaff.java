package exercise.practice_on_array_arrayList_linkedList_map.model;

public class ManagementStaff extends Staff{
    private double basicSalary;
    private double coefficientsSalary;

    public ManagementStaff() {
    }

    @Override
    public int employeeSalary() {
        return (int) (this.basicSalary * this.coefficientsSalary);
    }

    public ManagementStaff(String fullName, int yearOfBirth, String address, double basicSalary, double coefficientsSalary) {
        super(fullName, yearOfBirth, address);
        this.basicSalary = basicSalary;
        this.coefficientsSalary = coefficientsSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
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
                "basicSalary=" + basicSalary +
                ", coefficientsSalary=" + coefficientsSalary +
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

    /**
     * Muốn sử dụng comparable thì cần:
     * tạo một comparator tại class muốn triển khai -> viết lại phương thức compareTo()
     * Muốn sử dụng comparator thì cần:
     * tạo một comparable tại class mới -> viết lại phương thức compare()
     *
     * Sắp xếp nhân viên theo lương tăng dần thì có thể sử dụng cả hai vì cả 2 đều sắp xếp
     * nếu chỉ sử dụng Comparable thì cũng được vì Comparable sắp xếp theo 1 tiêu chí
     * nếu chỉ sử dụng comparator thì cũng được vì comparator sắp xếp theo nhiều tiêu chí
     *
     * Sắp xếp nhân viên theo lương tăng dần nếu lương bằng nhau thì sắp xếp theo tên giảm dần
     * nên sử dụng Comparator vì comparator sắp xếp theo nhiều tiêu chí
     * nếu chỉ sử dụng Comparable thì không được vì Comparable chỉ có thể sắp xếp theo 1 tiêu chí
     *  nếu chỉ sử dụng Comparator thì được vì comparator sắp xếp theo nhiều tiêu chí
     *
     *
     *  Có menu để người dùng chọn việc sắp xếp (Chọn 1 để sắp xếp theo lương tăng dần, chọn 2 để sắp xếp theo tên tăng dần)
     *   nên sử dụng Comparator vì tạo được class mới có thể sắp xếp theo nhiều tiêu chí
     *   nếu chỉ sử dụng Comparable thì không được vì Comparable vì tạo tại class muốn triển khài chỉ có thể sắp xếp theo 1 tiêu chí
     *
     *   khi nào bắt buộc phải sử dụng Comparator khi sắp xếp theo nhiều tiêu chí khác nhau.
     *    khi nào chỉ cần dùng Comparable khi sắp xếp theo 1 tiêu chí như id...;
     */
}
