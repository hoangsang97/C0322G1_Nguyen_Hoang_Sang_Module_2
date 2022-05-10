package ss05_access_modifier_static_method_static_property.bai_tap.build_write_only_classes_in_java;

public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Sang");
        student.setClasses("C03");
        System.out.println(student.getName() + " " + student.getClasses());
    }
}
