package ss07_abstract_class_and_interface.exercise.implement_interface_colorable;

public class ColorableTest {
    public static void main(String[] args) {
        Shape[] shapeList = new Shape[10];
        shapeList[0] = new Circle(5);
        shapeList[1] = new Rectangle(5, 10);
        shapeList[2] = new Square(4);

        for (int i = 0; i < shapeList.length; i++) {
            if (shapeList[i] != null && shapeList[i] instanceof Colorable) {
                System.out.println("Diện tích của hình: " + shapeList[i].getArea() + " " + ((Colorable) shapeList[i]).howToColor());
            } else if (shapeList[i] != null) {
                System.out.println("Diện tích của hình: " + shapeList[i].getArea());
            }
        }
    }
}
