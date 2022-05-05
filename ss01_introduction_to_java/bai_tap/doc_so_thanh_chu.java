import java.util.Scanner;

public class doc_so_thanh_chu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số cần đọc: ");
        int number = sc.nextInt();
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
        } else if (number < 20) {
            switch (number % 10) {
                case 4:
                    System.out.print("four ");
                    break;
                case 5:
                    System.out.print("five");
                    break;
                case 6:
                    System.out.print("six ");
                    break;
                case 7:
                    System.out.print("seven ");
                    break;
                case 8:
                    System.out.print("eight ");
                    break;
                case 9:
                    System.out.print("nine ");
                    break;
            }

            switch (number % 10) {
                case 0:
                    System.out.println("ten ");
                    break;
                case 1:
                    System.out.println("eleven ");
                    break;
                case 2:
                    System.out.println("twelve ");
                    break;
                case 3:
                    System.out.println("thirdteen ");
                    break;
                default:
                    System.out.println("teen ");
            }
        } else {
            switch ((number * 10) / 10 % 100) {
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

            switch (number / 10) {
                case 2:
                    System.out.print("twoty ");
                    break;
                case 3:
                    System.out.print("threety ");
                    break;
                case 4:
                    System.out.print("fourty ");
                    break;
                case 5:
                    System.out.print("fivety ");
                    break;
                case 6:
                    System.out.print("sixty ");
                    break;
                case 7:
                    System.out.print("seventy ");
                    break;
                case 8:
                    System.out.print("eightty ");
                    break;
                case 9:
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
}