package ss04_lop_doi_tuong_trong_java.bai_tap.constructing_the_stop_watch_class;

import java.time.LocalTime;

public class MainConstructingTheStopWatchClass {
    public static int[] selectionSort(int... arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int tempt = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tempt;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < 100000; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        LocalTime start = LocalTime.now();
        arr = selectionSort(arr);
        LocalTime end = LocalTime.now();
        ConstructingTheStopWatchClass.StopWatch sw = new ConstructingTheStopWatchClass.StopWatch(start, end);
        System.out.println("Time: " + sw.getElapsedTime());
        for (int x : arr) {
            System.out.println(x);
        }
    }
}
