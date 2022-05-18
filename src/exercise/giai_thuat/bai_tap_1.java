package exercise.giai_thuat;

public class bai_tap_1 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 3, 4, 5};
        int total1 = 0;
        int total2 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 3) {
                for (int j = 0; j < arr[i]; j++) {
                    total1 = arr[j] + arr[j + 1];
                }
                for (int j = arr[i]; j < arr.length - 1; j++) {
                    total2 = arr[j] + arr[j + 1];
                }
            }
        }
        if (total1 == total2) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
