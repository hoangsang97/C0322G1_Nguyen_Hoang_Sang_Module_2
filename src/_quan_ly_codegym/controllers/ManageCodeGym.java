package _quan_ly_codegym.controllers;

import java.util.Scanner;

public class ManageCodeGym {
    static Scanner scanner = new Scanner(System.in);
    public static void disPlayManageCodeGym () {
        System.out.println("-----------Manager CodeGym------------");
        System.out.println("1. Thêm mới giảng viên hoặc học sinh");
        System.out.println("1. Xóa giảng viên hoặc học sinh");
        System.out.println("1. Xem danh sách giảng viên hoặc học sinh");
        System.out.println("1. Tìm kiếm giảng viên hoặc học sinh");
        System.out.println("1. Thoát");
        System.out.println("Enter your choose");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:

        }
    }

    public static void main(String[] args) {
        disPlayManageCodeGym();
    }
}
