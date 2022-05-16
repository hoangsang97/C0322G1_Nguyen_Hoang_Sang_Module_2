package exercise.test_crud_hai;

public class Teacher extends Person{
    private double salary;

    public Teacher(){

    }

    public Teacher(double salary) {
        this.salary = salary;
    }

    public Teacher(int stt, int id, String name, int age, String gender, double salary) {
        super(stt, id, name, age, gender);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return"Teacher ==> No."+stt +" , Id : " +getId()+" , Name : "+getName()+" , Age : "+getAge()+" , Gender :"+isGender()+" , Salary"+getSalary();

    }
}
