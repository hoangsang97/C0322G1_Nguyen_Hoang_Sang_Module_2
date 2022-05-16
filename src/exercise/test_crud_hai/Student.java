package exercise.test_crud_hai;

public class Student extends Person{
    private double point;
    public Student(){

    }

    public Student(double point) {
        this.point = point;
    }

    public Student(int stt, int id, String name, int age, String gender, double point) {
        super(stt, id, name, age, gender);
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
        return  "Student ==> No "+stt  +" , Id : " +getId()+" ,Name : "+getName()+" ,Age : "+getAge()+" ,Gender :"+isGender()+" , Point "+getPoint();
    }
}