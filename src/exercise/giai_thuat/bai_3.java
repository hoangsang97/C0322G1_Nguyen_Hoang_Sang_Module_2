package exercise.giai_thuat;

import java.util.Arrays;

public class bai_3 {
    public static void main(String[] args) {
        int[] arr = {173, -1, 172, 171, -1};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != -1) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j] && arr[j] != -1) {
                        temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
