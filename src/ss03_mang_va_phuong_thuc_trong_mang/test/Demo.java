package ss03_mang_va_phuong_thuc_trong_mang.test;

import java.util.Arrays;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[4];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            System.out.print("Nhập vào mảng giá trị tại vi trí: " + i + ": \t");
            arr[i] = sc.nextInt();
        }

        for (int x: arr) {
            System.out.print(x + "\t");
        }
    }
}
