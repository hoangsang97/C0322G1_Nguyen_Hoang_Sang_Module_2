package ss04_lop_doi_tuong_trong_java.bai_tap;

import java.util.Scanner;

public class ConstructTheQuadraticEquationClass {
    public static class QuadraticEquation {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a ,b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0 ) {
            System.out.println("Phương trình có 2 nghiệm: " + quadraticEquation.getRoot1() + " và " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("Phương trình có 1 nghiệm: " + quadraticEquation.getRoot3());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
