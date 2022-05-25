package ss15_xu_li_ngoai_le_va_debug.exercise.illegalTriangleException;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean check = false;
        do {
            check = false;
            try {
                System.out.println("Nhập vào cạnh a");
                int a = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập vào cạnh b");
                int b = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập vào cạnh c");
                int c = Integer.parseInt(scanner.nextLine());
                if (a < 0 || b < 0 || c < 0) {
                    throw new MyException("Không được nhập số âm");
                } else if ((a + b) < c || (a + c) < b || (b + c) < a) {
                    throw new MyException("Tổng 2 cạnh không lớn hơn cạnh còn lại");
                }
            } catch (MyException e) {
                System.out.println("vui lòng nhập lại: ");
                check = true;
            }
        } while (check);

    }
}
