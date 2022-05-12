package ss06_ke_thua.test;

public class Student extends Person{
    private double point;

    public Student() {
    }

    public Student(String name, int age, boolean gender, String address, double point) {
        super(name, age, gender, address);
        this.point = point;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public void playSport() {
        System.out.println("Chơi game");
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() +
                "point=" + point +
                '}';
    }
}
