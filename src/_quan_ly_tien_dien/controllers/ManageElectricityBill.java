package _quan_ly_tien_dien.controllers;

import _quan_ly_tien_dien.services.impl.BillServiceImpl;
import _quan_ly_tien_dien.services.impl.CustomerNgServiceImpl;
import _quan_ly_tien_dien.services.impl.CustomerVnServiceImpl;
import ss05_access_modifier_static_method_static_property.test.Demo;

import java.util.Scanner;

public class ManageElectricityBill {
    static int choose = 0;

    static Scanner scanner = new Scanner(System.in);

    static CustomerVnServiceImpl customerVnService = new CustomerVnServiceImpl();

    static CustomerNgServiceImpl customerNgService = new CustomerNgServiceImpl();

    static BillServiceImpl billService = new BillServiceImpl();

    public static void disPlayManageElectricityBill() {
        do {
            System.out.println("-----------CHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN------------");
            System.out.println("1. Thêm mới khách hàng");
            System.out.println("2. Hiện thị thông tin khách hàng");
            System.out.println("3. Tìm kiếm khách hàng");
            System.out.println("4. Thêm mới hóa đơn");
            System.out.println("5. Chỉnh sửa hóa đơn");
            System.out.println("6. Hiện thị thông  tin chi tiết hóa đơn");
            System.out.println("7. Thoát");
            System.out.println("Enter your choose");

            switch (exceptionPerson(choose)) {
                case 1:
                    addNewCustomer();
                    break;
                case 2:
                    viewCustomer();
                    break;
                case 3:
                    searchCustomer();
                    break;
                case 4:
                    billService.addNew();
                    break;
                case 5:
                    billService.edit();
                    break;
                case 6:
                    billService.view();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void addNewCustomer() {
        do {
            System.out.println("--------Thêm mới khách hàng----------");
            System.out.println("1. Thêm mới khách hàng việt nam");
            System.out.println("2. Thêm mới khách hàng nước ngoài");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("Thêm mới khách hàng việt nam");
                    customerVnService.addNew();
                    break;
                case 2:
                    System.out.println("Thêm mới khách hàng nước ngoài");
                    customerNgService.addNew();
                    break;
                case 3:
                    disPlayManageElectricityBill();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void viewCustomer() {
        do {
            System.out.println("--------Hiện thị thông tin khách hàng----------");
            System.out.println("1. xem danh sách khách hàng việt nam");
            System.out.println("2. xem danh sách khách hàng nước ngoài");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("danh sách khách hàng việt nam");
                    customerVnService.view();
                    break;
                case 2:
                    System.out.println("danh sách khách hàng nước ngoài");
                    customerNgService.view();
                    break;
                case 3:
                    disPlayManageElectricityBill();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void searchCustomer() {
        do {
            System.out.println("--------Tìm kiếm khách hàng----------");
            System.out.println("1. tìm kiếm khách hàng việt nam");
            System.out.println("2. tìm kiếm khách hàng nước ngoài");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("tìm kiếm khách hàng việt nam");
                    customerVnService.search();
                    break;
                case 2:
                    System.out.println("tìm kiếm khách hàng nước ngoài");
                    customerNgService.search();
                    break;
                case 3:
                    disPlayManageElectricityBill();
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
        disPlayManageElectricityBill();
    }
}
