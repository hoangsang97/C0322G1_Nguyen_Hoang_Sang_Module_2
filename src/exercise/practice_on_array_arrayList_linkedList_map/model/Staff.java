package exercise.practice_on_array_arrayList_linkedList_map.model;

public abstract class Staff implements Comparable<Staff> {
    private String fullName;
    private int yearOfBirth;
    private String address;

    public Staff() {
    }

    public Staff(String fullName, int yearOfBirth, String address) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract int employeeSalary();

    @Override
    public String toString() {
        return "Staff{" +
                "fullName='" + fullName + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * class cha có cần phương thức abstract vì có thể khai báo lại những phương thức của lớp con
     */
}
