package ss03_mang_va_phuong_thuc_trong_mang.bai_tap;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        String[] str = {"a", "b", "c", "d", "a", "a", "a", "b"};
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập kí tự muốn tìm kiếm trong chuỗi: ");
        String inputStr = sc.nextLine();

        int count = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals(inputStr)) {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện của ký tự " + inputStr + " trong chuỗi là: " + count);
    }
}
