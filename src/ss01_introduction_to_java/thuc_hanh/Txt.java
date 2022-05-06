package ss01_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Txt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String password;
        do {
            password = sc.nextLine();
        } while (!password.equals("vung oi mo ra"));
    }
}
