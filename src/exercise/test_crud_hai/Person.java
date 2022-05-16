package exercise.test_crud_hai;

public abstract class Person {
    public int stt;
    private int id;
    private String name;
    private int age;
    private String gender;
    public Person(){

    }

    public Person(int stt, int id, String name, int age, String gender) {
        this.stt = stt;
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "stt=" + stt +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}