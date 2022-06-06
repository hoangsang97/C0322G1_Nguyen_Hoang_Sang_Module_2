package _quan_ly_nhan_vien.controlles;

import _quan_ly_nhan_vien.service.ManagementStaffService;
import _quan_ly_nhan_vien.service.ProductionStaffService;
import _quan_ly_nhan_vien.service.impl.ManagementStaffServiceImpl;
import _quan_ly_nhan_vien.service.impl.ProductionStaffServiceImpl;

import java.util.Scanner;

public class DisplayManagerStaff {
    static int choose = 0;

    static Scanner scanner = new Scanner(System.in);

    static ManagementStaffService managementStaffService = new ManagementStaffServiceImpl();

    static ProductionStaffService productionStaffService = new ProductionStaffServiceImpl();

    public static void disPlayManageStaff() {
        do {
            System.out.println("-----------Manager CodeGym------------");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. Tìm kiếm");
            System.out.println("5. Thoát");
            System.out.println("Enter your choose");

            switch (exceptionPerson(choose)) {
                case 1:
                    viewPerson();
                    break;
                case 2:
                    addNewStaff();
                    break;
                case 3:
                    deletePerson();
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

    public static void addNewStaff() {
        do {
            System.out.println("--------Thêm mới nhân viên----------");
            System.out.println("1. Thêm mới nhân viên quản lý");
            System.out.println("2. Thêm mới nhân viên sản xuất");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("Thêm mới nhân viên quản lý");
                    managementStaffService.addNew();
                    break;
                case 2:
                    System.out.println("Thêm mới nhân viên sản xuất");
                    productionStaffService.addNew();
                    break;
                case 3:
                    disPlayManageStaff();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void deletePerson() {
        do {
            System.out.println("--------Xóa nhân viên----------");
            System.out.println("1. xóa nhân viên quản lý");
            System.out.println("2. xóa nhân viên sản xuất");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("xóa nhân viên quản lý");
                    managementStaffService.delete();
                    break;
                case 2:
                    System.out.println("xóa nhân viên sản xuất");
                    productionStaffService.delete();
                    break;
                case 3:
                    disPlayManageStaff();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void viewPerson() {
        do {
            System.out.println("--------Xem danh sách nhân viên----------");
            System.out.println("1. xem danh sách nhân viên quản lý");
            System.out.println("2. xem danh sách nhân viên sản xuất");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("danh sách nhân viên quản lý");
                    managementStaffService.view();
                    break;
                case 2:
                    System.out.println("danh sách nhân viên sản xuất");
                    productionStaffService.view();
                    break;
                case 3:
                    disPlayManageStaff();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void searchPerson() {
        do {
            System.out.println("--------Tìm kiếm nhân viên----------");
            System.out.println("1. tìm kiếm nhân viên quản lý");
            System.out.println("2. tìm kiếm nhân viên sản xuất");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("tìm kiếm nhân viên quản lý");
                    managementStaffService.search();
                    break;
                case 2:
                    System.out.println("tìm kiếm nhân viên sản xuất");
                    productionStaffService.search();
                    break;
                case 3:
                    disPlayManageStaff();
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
}
