package ss06_ke_thua.test;

public class TestMain {
    public static void main(String[] args) {
        Student student = new Student("Sang", 18, true, "DN", 10);
        System.out.println(student);

        Person obj = new Student();
        ((Student) obj).playSport();
    }
}
