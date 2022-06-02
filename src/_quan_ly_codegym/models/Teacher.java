package _quan_ly_codegym.models;

public class Teacher extends Person{
    private String regular;

    public Teacher() {
    }

    public Teacher(String id, String name, String dateOfBirth, String sex, String regular) {
        super(id, name, dateOfBirth, sex);
        this.regular = regular;
    }

    public String getRegular() {
        return regular;
    }

    public void setRegular(String regular) {
        this.regular = regular;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "regular='" + regular + '\'' +
                '}';
    }

    @Override
    public String getInfo() {
        return "1";
    }
}
