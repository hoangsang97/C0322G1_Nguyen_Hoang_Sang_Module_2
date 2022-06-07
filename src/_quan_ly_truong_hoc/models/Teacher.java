package _quan_ly_truong_hoc.models;

import _quan_ly_nhan_vien.models.Staff;

public class Teacher extends Person {
    private double salary;
    private int time;

    public Teacher() {
    }

    public Teacher(int id, String name, String sex, String dateOfBirth, String address, double salary, int time) {
        super(id, name, sex, dateOfBirth, address);
        this.salary = salary;
        this.time = time;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "salary=" + salary +
                ", time=" + time +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getName(),
                super.getSex(),
                super.getDateOfBirth(),
                super.getAddress(),
                this.getSalary(),
                this.getTime());
    }
}
