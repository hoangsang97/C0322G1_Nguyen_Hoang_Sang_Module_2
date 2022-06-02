package _quan_ly_codegym.controllers;

import _quan_ly_codegym.services.impl.StudentServiceImpl;

import java.util.Scanner;

public class ManageCodeGym {
    static int choose = 0;

    static Scanner scanner = new Scanner(System.in);

    static StudentServiceImpl studentService = new StudentServiceImpl();

    public static void disPlayManageCodeGym() {
        do {
            System.out.println("-----------Manager CodeGym------------");
            System.out.println("1. Thêm mới giảng viên hoặc học sinh");
            System.out.println("2. Xóa giảng viên hoặc học sinh");
            System.out.println("3. Xem danh sách giảng viên hoặc học sinh");
            System.out.println("4. Tìm kiếm giảng viên hoặc học sinh");
            System.out.println("5. Thoát");
            System.out.println("Enter your choose");

            switch (exceptionPerson(choose)) {
                case 1:
                    addNewPerson();
                    break;
                case 2:
                    deletePerson();
                    break;
                case 3:
                    viewPerson();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void addNewPerson() {
        do {
            System.out.println("--------Thêm mới giảng viên hoặc học sinh----------");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("Thêm mới học sinh");
                    studentService.addNew();
                    break;
                case 2:
                    System.out.println("Thêm mới giảng viên");
                    break;
                case 3:
                    disPlayManageCodeGym();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void deletePerson() {
        do {
            System.out.println("--------Xóa giảng viên hoặc học sinh----------");
            System.out.println("1. xóa học sinh");
            System.out.println("2. xóa giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("danh sách học sinh");
                    studentService.delete();
                    break;
                case 2:
                    System.out.println("danh sách giảng viên");
                    break;
                case 3:
                    disPlayManageCodeGym();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void viewPerson() {
        do {
            System.out.println("--------Xem danh sách giảng viên hoặc học sinh----------");
            System.out.println("1. xem danh sách học sinh");
            System.out.println("2. xem danh sách giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("danh sách học sinh");
                    studentService.view();
                    break;
                case 2:
                    System.out.println("danh sách giảng viên");
                    break;
                case 3:
                    disPlayManageCodeGym();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void searchPerson() {
        do {
            System.out.println("--------Tìm kiếm giảng viên hoặc học sinh----------");
            System.out.println("1. tìm kiếm học sinh");
            System.out.println("2. tìm kiếm giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("tìm kiếm học sinh");
                    studentService.search();
                    break;
                case 2:
                    System.out.println("tìm kiếm giảng viên");
                    break;
                case 3:
                    disPlayManageCodeGym();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static int exceptionPerson(int inputChoose) {
        boolean checkChoose = false;

        do {
            try {
                inputChoose = Integer.parseInt(scanner.nextLine());
                checkChoose = false;
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại: ");
                checkChoose = true;
            }
        } while (checkChoose);

        return inputChoose;
    }

    public static void main(String[] args) {
        disPlayManageCodeGym();
    }
}
