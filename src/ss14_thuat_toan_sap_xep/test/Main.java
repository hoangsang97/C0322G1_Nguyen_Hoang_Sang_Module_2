package ss14_thuat_toan_sap_xep.test;

import java.util.Arrays;

public class Main {
    public static void bubbleSortSimple(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--)
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
        }
    }
    public static void main(String[] args) {
        double[] a = {2, 5, 3, 4, 1};
        selectionSort(a);
    }
    public static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
//          key = phần tử chèn vào trong danh sách con
            int key = arr[i];
//           Vị trí của phần tử cuối cùng ở danh sách con
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            System.out.println(Arrays.toString(arr));
        }
    }
    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        for (int k = 1; needNextPass; k++) {
            /* Mảng có thể đã được sắp xếp và không cần thiết có vòng lặp tiếp theo */
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    /* Swap list[i] with list[i + 1] */
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    needNextPass = true; /* Cần có vòng lặp tiếp theo */
                }
            }
            System.out.println(Arrays.toString(list));
        }
    }
    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            /* Tìm phần tử nhỏ nhất trong danh sách */
            double currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            /* Đổi chỗ phần tử list[i] với list[currentMinIndex] nếu cần */
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
            System.out.println(Arrays.toString(list));
        }
    }
}
