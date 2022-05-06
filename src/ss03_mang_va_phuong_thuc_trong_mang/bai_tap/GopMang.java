package ss03_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Arrays;
import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int size;
        int[] array1;
        int[] array2;
        int[] array3;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Enter a size: ");
            size = sc.nextInt();
            if (size > 20) {
                System.out.println("Size should not exceed 20");
            }
        } while (size > 20);

        array1 = new int[size];
        int i = 0;
        System.out.println("Enter array1: ");
        while (i < array1.length) {
            System.out.println("Enter element" + (i + 1) + " : ");
            array1[i] = sc.nextInt();
            i++;
        }
        System.out.print("Property list: ");
        System.out.println(Arrays.toString(array1));

        array2 = new int[size];
        int j = 0;
        System.out.println("Enter array2: ");
        while (j < array2.length) {
            System.out.println("Enter element" + (j + 1) + " : ");
            array2[j] = sc.nextInt();
            j++;
        }
        System.out.print("Property list: ");
        System.out.println(Arrays.toString(array2));

        array3 = new int[size * 2];
        for (int k = 0; k < array1.length; k++) {
            array3[k] = array1[k];
        }

        for (int k = 0; k < array2.length; k++) {
            array3[k + size] = array2[k];
        }
        System.out.print("Property list array3: ");
        System.out.println(Arrays.toString(array3));
    }
}
