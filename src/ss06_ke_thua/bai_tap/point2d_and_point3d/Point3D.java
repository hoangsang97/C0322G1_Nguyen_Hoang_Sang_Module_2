package ss06_ke_thua.bai_tap.point2d_and_point3d;

import java.util.Arrays;

public class Point3D extends Point2D{
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public String getXYZ() {
        float[] arr = {this.getX(), this.getY(), this.z};
        return Arrays.toString(arr);
    }
}
