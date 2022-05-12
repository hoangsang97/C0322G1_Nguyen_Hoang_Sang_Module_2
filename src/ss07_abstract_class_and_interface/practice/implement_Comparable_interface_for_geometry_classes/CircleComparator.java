package ss07_abstract_class_and_interface.practice.implement_Comparable_interface_for_geometry_classes;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {

    @Override
    public int compare(Circle c1, Circle c2) {
        return Double.compare(c1.getRadius(), c2.getRadius());
    }
}
