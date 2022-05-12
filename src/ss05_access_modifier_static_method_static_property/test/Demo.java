package ss05_access_modifier_static_method_static_property.test;

public class Demo {
    private String name;
    private int age;
    private String className;
    public static String school;
    public static int count;

    static public class B {
    }

    static {
        school = "CODEGYM";
        count = 0;
    }

    public Demo() {
        count++;
    }

    public Demo(String name, int age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
        count++;
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

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", school= " + school +
                ", count= " + count +
                '}';
    }
}
