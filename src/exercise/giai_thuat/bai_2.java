package exercise.giai_thuat;

public class bai_2 {
    public static void main(String[] args) {
        String str = "CodegymDaNang";
        char[] strArr = str.toCharArray();

        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] >= 'A' && strArr[i] <= 'Z') {
                strArr[i] = (char) (strArr[i] + 32);
                if (i != 0) {
                    System.out.print(" ");
                }
                System.out.print(strArr[i]);
            } else
                System.out.print(strArr[i]);
        }
    }
}
