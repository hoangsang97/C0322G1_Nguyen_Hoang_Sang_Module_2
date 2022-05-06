package ss02_vong_lap_trong_java.bai_tap;

import java.util.Scanner;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng số nguyên tố cần in ra: ");
        int number = sc.nextInt();
        int count = 2;
        int n = 4;
        boolean check;

        if (number >= 2) {
            System.out.println("2 là số nguyên tố");
            System.out.println("3 là số nguyên tố");
            while (count < number) {
                check = true;
                if (n < 2) {
                    check = false;
                } else if (n % 2 == 0) {
                    check = false;
                } else {
                    for (int i = 3; i < n; i++) {
                        if (n % i == 0) {
                            check = false;
                            break;
                        }
                    }
                }
                if (check == true) {
                    System.out.println(n + " là số nguyên tố");
                    count++;
                }
                n++;
            }
        } else if (number == 1) {
            System.out.println("2 là số nguyên tố");
        }
    }
}
