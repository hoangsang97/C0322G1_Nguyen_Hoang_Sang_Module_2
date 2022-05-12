package ss05_access_modifier_static_method_static_property.test;

public class TestMain {
    public static void Student() {
        System.out.println("Sang");
    }

    public static void main(String[] args) {
        Demo demo1 = new Demo();
        demo1.setAge(18);
        System.out.println(demo1);
        Demo demo = new Demo("Sang", 25, "C03");
        Student();
        System.out.println(demo);
        Demo.school = "C0322";
        System.out.println(demo1);

        Demo.B o = new Demo.B(1);
        System.out.println(o);
    }
}
