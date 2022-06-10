package _quan_ly_nhan_vien.service.impl;

import _quan_ly_nhan_vien.exception.NotFoundEmployeeException;
import _quan_ly_nhan_vien.models.ProductionStaff;
import _quan_ly_nhan_vien.models.Staff;
import _quan_ly_nhan_vien.service.ProductionStaffService;
import _quan_ly_nhan_vien.utils.ReadAndWrite;
import _quan_ly_nhan_vien.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductionStaffServiceImpl implements ProductionStaffService {
    public static Scanner scanner = new Scanner(System.in);

    public static List<ProductionStaff> productionStaffList = new LinkedList<>();

    public static List<Staff> staffList = new LinkedList<>();

    private static final String REGEX_BIRTHDAY = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    public static final String REGEX_INT = "^[0-9]+$";

    @Override
    public void view() {
        productionStaffList.clear();

        ReadAndWrite.readProductionStaff("src/_quan_ly_nhan_vien/data/experience.csv", productionStaffList);

        for (ProductionStaff item: productionStaffList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        staffList.clear();

        ReadAndWrite.readStaff("src/_quan_ly_nhan_vien/data/experience.csv", staffList);

        int id = 0;

        if (staffList.isEmpty()) {
            id = 1;
        } else {
            for (Staff item: staffList) {
                id = item.getId() + 1;
            }
        }

        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
        String dateOfBirth = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập số sản phẩm: ");
        int product = Integer.parseInt(RegexData.regexProduct(REGEX_INT));
        System.out.println("Nhập giá mỗi sản phẩm: ");
        double price = Double.parseDouble(RegexData.regexPrice(REGEX_INT));

        ProductionStaff productionStaff = new ProductionStaff(id, name, dateOfBirth, address, product, price);
        staffList.add(productionStaff);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeStaff("src/_quan_ly_nhan_vien/data/experience.csv", staffList);
    }

    @Override
    public void delete() {
        staffList.clear();

        ReadAndWrite.readStaff("src/_quan_ly_nhan_vien/data/experience.csv", staffList);

        for (Staff item: staffList) {
            if (item instanceof ProductionStaff) {
                System.out.println(item);
            }
        }

        System.out.println("nhập id muốn xóa: ");

        int id = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int i = 0; i < staffList.size(); i++) {
            if (staffList.get(i) instanceof ProductionStaff && id == staffList.get(i).getId()) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = Integer.parseInt(scanner.nextLine());

                switch (inputChoose) {
                    case 1:
                        staffList.remove(i);
                        System.out.println("đã xóa thành công");
                        count++;
                        break;
                    case 2:
                        count++;
                        break;
                }
            }
        }

        try {
            if (count == 0) {
                throw new NotFoundEmployeeException("Id không tồn tại");
            }
        } catch (NotFoundEmployeeException e){
            System.out.println(e.getMessage());
        }

        ReadAndWrite.writeStaff("src/_quan_ly_nhan_vien/data/experience.csv", staffList);
    }

    @Override
    public void search() {
        productionStaffList.clear();

        ReadAndWrite.readProductionStaff("src/_quan_ly_nhan_vien/data/experience.csv", productionStaffList);

        System.out.println("Bạn muốn tìm kiếm theo: ");
        System.out.println("1. Mã nhân viên");
        System.out.println("2. Họ tên");
        System.out.println("3. Ngày sinh");
        System.out.println("4. Địa chỉ");
        int inputChoose = Integer.parseInt(scanner.nextLine());

        if (inputChoose == 1) {
            System.out.println("Nhập mã nhân viên muốn tìm kiếm: ");
            int id = Integer.parseInt(scanner.nextLine());

            boolean flag = false;
            for (ProductionStaff item: productionStaffList) {
                if (id == item.getId()) {
                    System.out.println(item);
                } else {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("Không tìm thấy mã nhân viên");
            }
        } else if (inputChoose == 2) {
            System.out.println("Nhập tên nhân viên muốn tìm kiếm: ");
            String name = scanner.nextLine();

            boolean flag = false;
            for (ProductionStaff item: productionStaffList) {
                if (name.contains(item.getName())) {
                    System.out.println(item);
                } else {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("Không tìm thấy tên nhân viên");
            }
        } else if (inputChoose == 3) {
            System.out.println("Nhập ngày sinh nhân viên muốn tìm kiếm: ");
            String dataOfBirth = scanner.nextLine();

            boolean flag = false;
            for (ProductionStaff item: productionStaffList) {
                if (dataOfBirth.contains(item.getDateOfBirth())) {
                    System.out.println(item);
                } else {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("Không tìm thấy ngày sinh nhân viên");
            }
        } else if (inputChoose == 4){
            System.out.println("Nhập địa chỉ nhân viên muốn tìm kiếm: ");
            String address = scanner.nextLine();

            boolean flag = false;
            for (ProductionStaff item: productionStaffList) {
                if (address.contains(item.getAddress())) {
                    System.out.println(item);
                } else {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("Không tìm thấy địa chỉ muốn tìm kiếm");
            }
        } else {
            System.out.println("không có option này");
        }
    }
}
