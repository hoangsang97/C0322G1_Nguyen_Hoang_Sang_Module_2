package ss07_abstract_class_and_interface.exercise.resizable_implementation;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo", false);
        System.out.println(circle);

        System.out.println("Diện tích của phần tử trước khi tăng: "+ circle.getArea());

        circle.resize(Math.random() * 100);

        System.out.println("Diện tích của phần tử sau khi tăng: "+ circle.getArea());
    }
}
