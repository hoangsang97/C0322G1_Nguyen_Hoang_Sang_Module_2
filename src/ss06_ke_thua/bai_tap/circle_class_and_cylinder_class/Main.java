package ss06_ke_thua.bai_tap.circle_class_and_cylinder_class;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println("Diện tích hình tròn: " + circle.getArea());
        System.out.println(circle);
        Cylinder cylinder = new Cylinder();
        System.out.println("Thể tích hình trụ: " + cylinder.getVolume());
    }
}
