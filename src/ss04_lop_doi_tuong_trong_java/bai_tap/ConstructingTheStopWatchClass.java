package ss04_lop_doi_tuong_trong_java.bai_tap;

import java.time.LocalTime;

public class ConstructingTheStopWatchClass {
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
        StopWatch sw = new StopWatch(start, end);
        System.out.println("Time: " + sw.getElapsedTime());
        for (int x : arr) {
            System.out.println(x);
        }
    }

    public static class StopWatch {
        private LocalTime startTime, endTime;
        int milliSecond;

        public StopWatch() {
            startTime = LocalTime.now();
        }

        public StopWatch(LocalTime startTime, LocalTime endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public LocalTime getStartTime() {
            return startTime;
        }

        public LocalTime getEndTime() {
            return endTime;
        }

        public void start() {
            startTime = LocalTime.now();
        }

        public void stop() {
            endTime = LocalTime.now();
        }

        public int getElapsedTime() {
            milliSecond = ((endTime.getHour() - startTime.getHour()) * 3600 + (endTime.getMinute() - startTime.getMinute()) * 60 + (endTime.getSecond() - startTime.getSecond()) * 1000);
            return milliSecond;
        }
    }
}
