package ss07_abstract_class_and_interface.exercise.resizable_implementation;

public class SquareTest {
    public static void main(String[] args) {
        Square square = new Square(5);

        System.out.println("Diện tích của phần tử trước khi tăng: "+ square.getArea());
        square.resize(Math.random() * 100);
        System.out.println("Diện tích của phần tử sau khi tăng: "+ square.getArea());
    }
}
