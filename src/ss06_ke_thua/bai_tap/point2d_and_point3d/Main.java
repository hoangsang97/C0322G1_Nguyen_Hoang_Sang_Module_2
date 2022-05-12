package ss06_ke_thua.bai_tap.point2d_and_point3d;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point2D point2D = new Point2D(3,5);
        Point3D point3D = new Point3D(3,4,5);
        System.out.println(point2D);
        System.out.println(Arrays.toString(point2D.getXY()));
        System.out.println(point3D);
        System.out.println(point3D.getXYZ());
    }
}
