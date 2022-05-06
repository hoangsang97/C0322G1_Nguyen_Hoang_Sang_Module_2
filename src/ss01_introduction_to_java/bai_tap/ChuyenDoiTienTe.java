package ss01_introduction_to_java.bai_tap;

import java.util.Scanner;

public class ChuyenDoiTienTe {
    public static void main(String[] args) {
        double vnd = 23000;
        double usd;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Mời bạn nhập số tiền USD: ");
        usd = scanner.nextDouble();
        double quydoi = vnd * usd;
        System.out.println("Giá trị VND: " + quydoi);
    }
}
