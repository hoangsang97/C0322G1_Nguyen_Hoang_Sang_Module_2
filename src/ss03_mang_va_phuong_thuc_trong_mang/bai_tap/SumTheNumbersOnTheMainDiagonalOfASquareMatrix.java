package ss03_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class SumTheNumbersOnTheMainDiagonalOfASquareMatrix {
    public static void main(String[] args) {
        int soDong;
        int soCot;

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số dòng: ");
        soDong = sc.nextInt();
        System.out.print("Nhập số cột: ");
        soCot = sc.nextInt();

        int[][] array = new int[soDong][soCot];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("nhập giá trị tại số dòng: " + i + " số cột " + j + "\t");
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println("Hiển thị mảng: ");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println("\n");
        }

        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total = total + array[i][i];
        }

        System.out.println("Tổng các số ở đường chéo chính của ma trận vuông là: " + total);
    }
}
