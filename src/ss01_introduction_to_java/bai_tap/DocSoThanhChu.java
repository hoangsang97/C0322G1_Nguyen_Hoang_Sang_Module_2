package ss01_introduction_to_java.bai_tap;

import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = -1;
        do {
            System.out.println("Nhập số cần đọc (0 -> 999): ");
            number = sc.nextInt();
            if (number <= 9) {
                switch (number) {
                    case 0:
                        System.out.println("zero ");
                        break;
                    case 1:
                        System.out.println("one ");
                        break;
                    case 2:
                        System.out.println("two ");
                        break;
                    case 3:
                        System.out.println("three ");
                        break;
                    case 4:
                        System.out.print("four ");
                        break;
                    case 5:
                        System.out.println("five");
                        break;
                    case 6:
                        System.out.println("six ");
                        break;
                    case 7:
                        System.out.println("seven ");
                        break;
                    case 8:
                        System.out.println("eight ");
                        break;
                    case 9:
                        System.out.println("nine ");
                        break;
                }
            } else {
                switch (number / 100) {
                    case 1:
                        System.out.print("one hundred ");
                        break;
                    case 2:
                        System.out.print("two hundred ");
                        break;
                    case 3:
                        System.out.print("three hundred ");
                        break;
                    case 4:
                        System.out.print("four hundred ");
                        break;
                    case 5:
                        System.out.print("five hundred ");
                        break;
                    case 6:
                        System.out.print("six hundred ");
                        break;
                    case 7:
                        System.out.print("seven hundred ");
                        break;
                    case 8:
                        System.out.print("eight hundred ");
                        break;
                    case 9:
                        System.out.print("nine hundred ");
                        break;
                }

                switch (((number / 10) * 10) % 100) {
                    case 10:
                        System.out.print("ten ");
                        break;
                    case 20:
                        System.out.print("twoty ");
                        break;
                    case 30:
                        System.out.print("threety ");
                        break;
                    case 40:
                        System.out.print("fourty ");
                        break;
                    case 50:
                        System.out.print("fivety ");
                        break;
                    case 60:
                        System.out.print("sixty ");
                        break;
                    case 70:
                        System.out.print("seventy ");
                        break;
                    case 80:
                        System.out.print("eightty ");
                        break;
                    case 90:
                        System.out.print("ninety ");
                        break;
                }

                switch (number % 10) {
                    case 1:
                        System.out.println("one ");
                        break;
                    case 2:
                        System.out.println("two ");
                        break;
                    case 3:
                        System.out.println("three ");
                        break;
                    case 4:
                        System.out.print("four ");
                        break;
                    case 5:
                        System.out.println("five");
                        break;
                    case 6:
                        System.out.println("six ");
                        break;
                    case 7:
                        System.out.println("seven ");
                        break;
                    case 8:
                        System.out.println("eight ");
                        break;
                    case 9:
                        System.out.println("nine ");
                        break;
                }
            }
        }
        while (number < 0 || number > 999);
    }
}