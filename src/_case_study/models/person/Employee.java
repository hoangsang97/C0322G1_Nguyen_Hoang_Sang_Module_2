package _case_study.models.person;

public class Employee extends Person{
    private String level;
    private String position;
    private int salary;
    private String dateOfBirth;

    public Employee() {
    }

    public Employee(int id, String name, int age, String sex, String idCard, String email, String level, String position, int salary) {
        super(id, name, age, sex, idCard, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }


    public Employee(int id, String name, String sex, String idCard, String email, String level, String position, int salary, String dateOfBirth) {
        super(id, name, sex, idCard, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee(String level, String position, int salary) {
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
