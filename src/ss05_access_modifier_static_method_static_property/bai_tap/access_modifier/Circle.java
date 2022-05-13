package ss05_access_modifier_static_method_static_property.bai_tap.access_modifier;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(){

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }
}
