package _case_study.models.person;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private int id;
    private String name;
    private String age;
    private String sex;
    private String idCard;
    private String email;

    public Person() {
    }

    public abstract String getInfo();

    public Person(int id, String name, String age, String sex, String idCard, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.idCard = idCard;
        this.email = email;
    }

    public Person(int id, String name, String sex, String idCard, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.idCard = idCard;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", idCard='" + idCard + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
