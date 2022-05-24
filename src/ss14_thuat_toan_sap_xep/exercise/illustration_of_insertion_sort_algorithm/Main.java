package ss14_thuat_toan_sap_xep.exercise.illustration_of_insertion_sort_algorithm;

import java.util.Arrays;

public class Main {
    /**
     * Tìm cách chèn phần tử a[i] vào vị trí thích hợp của đoạn đã được sắp để có dãy mới a[0] , a[1] ,... , a[i-1] trở nên có thứ tự
     * Vị trí này chính là pos thỏa : a[pos-1] <= a[i ]< a[pos] (1 <= pos <= i)
     */

    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void insertionSort(int[] array){
        int pos, x;
        for(int i = 1; i < array.length; i++){ //đoạn array[0] đã sắp xếp
            x = array[i];
            pos = i;
            while(pos > 0 && x < array[pos-1]){
                array[pos] = array[pos-1]; // đổi chỗ
                pos--;
            }
            array[pos] = x;
        }
    }

    public static void main(String[] args) {
        insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
