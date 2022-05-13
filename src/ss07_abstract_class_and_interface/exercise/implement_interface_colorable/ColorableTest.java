package ss07_abstract_class_and_interface.exercise.implement_interface_colorable;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapeList = new Shape[10];
        shapeList[0] = new Circle(5);
        shapeList[1] = new Rectangle(5, 10);
        shapeList[2] = new Square(4);

        for (Shape shape : shapeList) {
            if (shape instanceof Colorable) {
                System.out.print("Diện tích của hình: " + shape.getArea() + " ");
                ((Colorable) shape).howToColor();
            } else if (shape != null) {
                System.out.println("Diện tích của hình: " + shape.getArea());
            }
        }
    }
}
