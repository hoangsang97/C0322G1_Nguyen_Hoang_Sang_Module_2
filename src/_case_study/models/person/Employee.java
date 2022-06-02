package _case_study.models.person;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee extends Person implements Serializable {
    private String level;
    private String position;
    private int salary;

    public Employee() {
    }

    @Override
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s",
                super.getId(), super.getName(), super.getAge(), super.getSex(),
                super.getIdCard(), super.getEmail(),
                this.getLevel(), this.getPosition(), new BigDecimal(getSalary()));
    }

    public Employee(int id, String name, String age, String sex, String idCard, String email, String level, String position, int salary) {
        super(id, name, age, sex, idCard, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
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

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
