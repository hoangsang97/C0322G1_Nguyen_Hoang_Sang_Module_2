package ss06_ke_thua.bai_tap.point_and_moveablePoint;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(3, 5);
        MovablePoint movablePoint = new MovablePoint(7, 5, 4, 6);
        System.out.println(point);
        System.out.println(movablePoint);
        System.out.println(Arrays.toString(movablePoint.getSpeed()));
        System.out.println(movablePoint.move());
        System.out.println(movablePoint);
    }
}
