package ss07_abstract_class_and_interface.exercise.resizable_implementation;

public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);

        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);

        rectangle = new Rectangle(2.5, 3.8, "orange", true);
        System.out.println(rectangle);

        System.out.println("Diện tích của phần tử trước khi tăng: "+ rectangle.getArea());
        rectangle.resize(Math.random() * 100);

        System.out.println("Diện tích của phần tử sau khi tăng: "+rectangle.getArea());
    }
}
