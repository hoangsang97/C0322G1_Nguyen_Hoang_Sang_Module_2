package ss15_xu_li_ngoai_le_va_debug.exercise.illegalTriangleException;

import java.util.Scanner;

public class TriangleEdgesException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập cạnh a");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập cạnh b");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập cạnh c");
        int c = Integer.parseInt(scanner.nextLine());
        try {
            triangle(a, b, c);
        } catch (TriangleException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void triangle(int a, int b, int c) throws TriangleException {
        if (a < 0 || b < 0 || c < 0) {
            throw new TriangleException("Số nhập có số âm ");
        } else if (a + b <= c || a + c <= b || b + c <= a) {
            throw new TriangleException("Không phải là tam giác");
        } else {
            System.out.println("Là tam giác");
        }
    }
}
