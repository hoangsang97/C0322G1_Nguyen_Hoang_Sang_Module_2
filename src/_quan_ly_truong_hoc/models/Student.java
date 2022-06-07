package _quan_ly_truong_hoc.models;

import _quan_ly_nhan_vien.models.Staff;

public class Student extends Person {
    private String idStudent;
    private double point;

    public Student() {
    }

    public Student(int id, String name, String sex, String dateOfBirth, String address, String idStudent, double point) {
        super(id, name, sex, dateOfBirth, address);
        this.idStudent = idStudent;
        this.point = point;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "idStudent='" + idStudent + '\'' +
                ", point=" + point +
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
                this.getIdStudent(),
                this.getPoint());
    }
}
