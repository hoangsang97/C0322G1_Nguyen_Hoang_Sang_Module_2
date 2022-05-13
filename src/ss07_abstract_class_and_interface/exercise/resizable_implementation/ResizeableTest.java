package ss07_abstract_class_and_interface.exercise.resizable_implementation;

public class ResizeableTest {
    public static void main(String[] args) {
        Shape[] shapeList = new Shape[10];
        shapeList[0] = new Circle(5);
        shapeList[1] = new Rectangle(5, 10);
        shapeList[2] = new Square(5);

        System.out.println("trước khi tăng kích thước: ");
        for (Shape shape : shapeList) {
            if (shape != null) {
                System.out.println("Diện tích của hình: " + shape.getArea());
                ((Resizeable) shape).resize(Math.random() * 100);
            }
        }

        System.out.println("sau khi tăng kích thước: ");
        for (Shape shape : shapeList) {
            if (shape != null) {
                System.out.println("Diện tích của hình: " + shape.getArea());
            }
        }
    }
}
