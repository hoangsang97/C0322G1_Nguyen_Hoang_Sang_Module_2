package exercise.employee_and_student_management;

public class Student extends Person{
    private double point;

    public Student() {
    }

    public Student(double point) {
        this.point = point;
    }

    public Student(int id, String name, int age, boolean gender, double point) {
        super(id, name, age, gender);
        this.point = point;
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
                "point=" + point +
                '}';
    }
}
