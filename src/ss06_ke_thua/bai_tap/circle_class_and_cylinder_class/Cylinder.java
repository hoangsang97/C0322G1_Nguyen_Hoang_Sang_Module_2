package ss06_ke_thua.bai_tap.circle_class_and_cylinder_class;

public class Cylinder extends Circle {
    private double height = 10;

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return Math.PI * this.getRadius() * this.getHeight();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }
}
