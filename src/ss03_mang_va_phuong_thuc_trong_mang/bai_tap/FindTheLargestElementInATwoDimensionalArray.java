package ss03_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class FindTheLargestElementInATwoDimensionalArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số dòng: ");
        int soDong = sc.nextInt();
        System.out.print("Nhập số cột: ");
        int soCot = sc.nextInt();

        int[][] array = new int[soDong][soCot];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print("nhập giá trị tại số dòng: " + i + " số cột " + j + "\t");
                array[i][j] = sc.nextInt();
            }
        }

        System.out.println("Hiển thị mảng: ");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println("\n");
        }



        int max = array[0][0];
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (max < anInt) {
                    max = anInt;
                }
            }
        }

        System.out.println("Phần tử lớn nhất là: " + max);
    }
}
