package ss03_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class RemoveElementFromArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter a size: ");
            size = Integer.parseInt(sc.nextLine());
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.print("Enter element" + (i + 1) + " : ");
            array[i] = sc.nextInt();
            i++;
        }

        System.out.print("Property list: ");
        for (int value : array) {
            System.out.print(value + "\t");
        }

        System.out.print("\n" + "Enter the number you want to delete: ");
        int indexDel = sc.nextInt();
        for (int j = 0; j < array.length; j++) {
            if (indexDel == array[j] && indexDel != array[array.length - 1]) {
                array[j] = array[j + 1];
                for (int k = j + 1; k < array.length - 1; k++) {
                    array[k] = array[k + 1];
                }
                array[array.length - 1] = 0;
                j--;
            } else if (indexDel == array[array.length - 1]) {
                array[array.length - 1] = 0;
            }
        }

        System.out.print("New array: ");
        for (int k : array) {
            System.out.print(k + "\t");
        }
    }
}
