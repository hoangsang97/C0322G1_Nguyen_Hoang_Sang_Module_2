package ss04_lop_doi_tuong_trong_java.bai_tap.construct_the_quadratic_equation_class;

import java.util.Scanner;

public class QuadraticEquation {

        double a, b, c;

        public QuadraticEquation (double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public double getDiscriminant() {
            return (b * 2) - (4 * a * c);
        }

        public double getRoot1() {
            return (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        }

        public double getRoot2() {
            return (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (2 * a);
        }

        public double getRoot3() {
            return -b / (2 * a);
        }

}
