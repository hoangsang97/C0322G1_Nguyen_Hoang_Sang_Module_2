package ss06_ke_thua.bai_tap.circle_class_and_cylinder_class;

public class Circle {
    private double radius = 5;
    private String color = "red";
    private final double PI = 3.14;

    public double getPI() {
        return PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(this.getRadius(), 2) * this.getPI();
    }


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", PI=" + PI +
                '}';
    }
}
