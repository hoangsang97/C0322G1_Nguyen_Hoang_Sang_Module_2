import java.util.Scanner;

public class hien_thi_cac_loai_hinh {
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
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {
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
            } else if (number == 3) {
                for (int i = 7; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print(" * ");
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
