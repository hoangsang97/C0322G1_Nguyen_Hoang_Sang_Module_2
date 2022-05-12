package ss03_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class FindTheSmallestValueInAnArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập độ dài mảng: " + "\t");
        size = sc.nextInt();

        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhập giá trị tại vị trí: " + i + "\t");
            array[i] = sc.nextInt();
        }
        System.out.print("Hiển thị mảng: " + "\t");
        for (int j : array) {
            System.out.print(j + "\t");
        }

        System.out.println("\n");
        int min = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                index = i;
                min = array[i];
            }
        }

        System.out.println("Giá trị nhỏ nhất trong mảng là: " + min + " tại vị trí " + index);
    }
}
