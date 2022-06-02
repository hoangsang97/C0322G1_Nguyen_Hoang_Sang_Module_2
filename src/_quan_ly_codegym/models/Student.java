package _quan_ly_codegym.models;

public class Student extends Person{
    private String className;
    private int point;

    public Student() {
    }

    public Student(String id, String name, String dateOfBirth, String sex, String className, int point) {
        super(id, name, dateOfBirth, sex);
        this.className = className;
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "className='" + className + '\'' +
                ", point=" + point +
                '}';
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s",
                super.getId(),
                super.getName(),
                super.getDateOfBirth(),
                super.getSex(),
                this.getClassName(),
                this.getPoint());
    }
}
