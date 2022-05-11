package ss04_lop_doi_tuong_trong_java.bai_tap.construct_the_quadratic_equation_class;

import java.util.Scanner;

public class MainConstructTheQuadraticEquationClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập a ,b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        ConstructTheQuadraticEquationClass.QuadraticEquation quadraticEquation = new ConstructTheQuadraticEquationClass.QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0 ) {
            System.out.println("Phương trình có 2 nghiệm: " + quadraticEquation.getRoot1() + " và " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("Phương trình có 1 nghiệm: " + quadraticEquation.getRoot3());
        } else {
            System.out.println("The equation has no roots");
        }
    }
}
