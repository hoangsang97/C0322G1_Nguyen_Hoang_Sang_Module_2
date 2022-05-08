package ss02_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class ShowTypes {
    public static void main(String[] args) {
        int number = -1;
        Scanner sc = new Scanner(System.in);

        while (number != 4) {
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (The corner is square at 4 different angles: top-left, top-right, botton-left, botton-right)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");

            number = sc.nextInt();
            if (number == 1) {
                System.out.print("Enter width: " + "\t");
                int width = sc.nextInt();
                System.out.print("Enter height: " + "\t");
                int height = sc.nextInt();

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println("");
                }
            } else if (number == 2) {
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println("");
                }

                System.out.println("");
                for (int i = 0; i < 6; i++) {
                    for (int j = 5; j > i; j--) {
                        System.out.print(" * ");
                    }
                    System.out.println("");
                }

                for (int i = 1; i < 6; i++) {
                    for (int j = 0; j < 5 - i; j++) {
                        System.out.print("\t");
                    }
                    for (int j = 0; j < i; j++) {
                        System.out.print("*   ");
                    }
                    System.out.println("");
                }

                System.out.println("");
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("\t");
                    }
                    for (int j = 5; j > i; j--) {
                        System.out.print("*   ");
                    }
                    System.out.println("");
                }

            } else if (number == 3) {
                for (int i = 1; i <= 5; i++) {
                    for (int j = i; j <= 5; j++) {
                        System.out.print("\t");
                    }
                    for (int j = 1; j < i; j++) {
                        System.out.print("*   ");
                    }
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*   ");
                    }

                    System.out.println("");
                }
            } else if (number == 4) {
                System.exit(4);
            } else {
                System.out.println("No number!");
            }
        }
    }
}
