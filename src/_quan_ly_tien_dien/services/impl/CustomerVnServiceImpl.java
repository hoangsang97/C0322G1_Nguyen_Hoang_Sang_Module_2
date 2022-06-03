package _quan_ly_tien_dien.services.impl;

import _quan_ly_tien_dien.models.customer.CustomerVn;
import _quan_ly_tien_dien.services.CustomerVnService;
import _quan_ly_tien_dien.utils.ReadAndWrite;
import _quan_ly_tien_dien.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerVnServiceImpl implements CustomerVnService {
    static List<CustomerVn> customerVnList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static final String REGEX_ID_CUSTOMER_VN = "(KHVN)[-][\\d]{5}";

    @Override
    public void addNew() {
        ReadAndWrite.readCustomerVn("src/_quan_ly_tien_dien/data/customerVN.csv", customerVnList);
        String id;
        boolean checkId = true;
        do {
            System.out.println("Nhập ID: ");
            id = RegexData.regexCustomerVn(REGEX_ID_CUSTOMER_VN);
            checkId = false;
            for (CustomerVn item: customerVnList) {
                if (item.getId().equals(id)) {
                    System.out.println("id đã bị trùng, xin hãy nhập lại");
                    checkId = true;
                }
            }
        }while (checkId);

        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập loại khác hàng");
        String type = typeCustomerVn();
        System.out.println("Nhập định mức tiêu thụ: ");
        double consume = Double.parseDouble(scanner.nextLine());

        CustomerVn customerVn = new CustomerVn(id, name, type, consume);
        customerVnList.add(customerVn);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeCustomerVn("src/_quan_ly_tien_dien/data/customerVN.csv", customerVnList);
    }

    @Override
    public void view() {
        customerVnList.clear();

        ReadAndWrite.readCustomerVn("src/_quan_ly_tien_dien/data/customerVN.csv", customerVnList);

        for (CustomerVn item: customerVnList) {
            System.out.println(item);
        }
    }

    @Override
    public void search() {
        customerVnList.clear();

        ReadAndWrite.readCustomerVn("src/_quan_ly_tien_dien/data/customerVN.csv", customerVnList);

        System.out.println("Nhập tên khách hàng muốn tìm: ");
        String name = scanner.nextLine();

        boolean flag = false;
        for (CustomerVn item: customerVnList) {
            if (name.contains(item.getName())) {
                System.out.println(item);
            } else {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("Không tìm thấy tên khách hàng");
        }
    }

    public static String typeCustomerVn() {
        String chooseType;
        boolean check = true;
        do {
            System.out.println("1. Sinh hoạt");
            System.out.println("2. Kinh doanh");
            System.out.println("3. Sản xuất");
            System.out.println("Enter your choose");
            chooseType = scanner.nextLine();

            switch (chooseType) {
                case "1":
                    System.out.println("Sinh hoạt");
                    check = false;
                    break;
                case "2":
                    System.out.println("Kinh doanh");
                    check = false;
                    break;
                case "3":
                    System.out.println("Sản xuất");
                    check = false;
                    break;
                default:
                    System.out.println("Không có option này, xin vui lòng nhập lại!");
            }
        } while (check);

        String strType = "";

        if (chooseType.equals("1")) {
            strType = "Sinh hoạt";
        } else if (chooseType.equals("2")) {
            strType = "Kinh doanh";
        } else {
            strType = "Sản xuất";
        }

        return strType;
    }
}
