package ss03_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int[] array = new int[4];
        Scanner sc = new Scanner(System.in);

        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = sc.nextInt();
            i++;
        }

        System.out.print("Property list: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }

        System.out.print("\n" + "Enter the element you want to add: ");
        int inputAdd = sc.nextInt();
        System.out.print("\n" + "Enter the position you want to insert: ");
        int indexAdd = sc.nextInt();

        for (int j = 0; j < array.length; j++) {
            if (indexAdd == j && inputAdd != array[array.length - 1]) {
                for (int k = array.length - 1; k > j; k--) {
                    array[k] = array[k - 1];
                }
                array[j] = inputAdd;
            }
        }

        System.out.print("New array: ");
        for (int j = 0; j < array.length; j++) {
            System.out.print(array[j] + "\t");
        }
    }
}
