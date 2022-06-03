package _quan_ly_tien_dien.services.impl;

import _quan_ly_tien_dien.models.customer.CustomerNg;
import _quan_ly_tien_dien.services.CustomerNgService;
import _quan_ly_tien_dien.utils.ReadAndWrite;
import _quan_ly_tien_dien.utils.RegexData;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerNgServiceImpl implements CustomerNgService {
    static List<CustomerNg> customerNgList = new LinkedList<>();

    static Scanner scanner = new Scanner(System.in);

    public static final String REGEX_ID_CUSTOMER_NG = "(KHNG)[-][\\d]{5}";

    @Override
    public void addNew() {
        ReadAndWrite.readCustomerNg("src/_quan_ly_tien_dien/data/customerNg.csv", customerNgList);
        String id;
        boolean checkId = true;
        do {
            System.out.println("Nhập Id: ");
            id = RegexData.regexCustomerNg(REGEX_ID_CUSTOMER_NG);
            checkId = false;
            for (CustomerNg item: customerNgList) {
                if (item.getId().equals(id)) {
                    System.out.println("id đã bị trùng, xin hãy nhập lại");
                    checkId = true;
                }
            }
        }while (checkId);

        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập quốc tịch");
        String nationality = scanner.nextLine();

        CustomerNg customerNg = new CustomerNg(id, name, nationality);
        customerNgList.add(customerNg);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeCustomerNg("src/_quan_ly_tien_dien/data/customerNg.csv", customerNgList);
    }

    @Override
    public void view() {
        customerNgList.clear();

        ReadAndWrite.readCustomerNg("src/_quan_ly_tien_dien/data/customerNg.csv", customerNgList);

        for (CustomerNg item: customerNgList) {
            System.out.println(item);
        }
    }

    @Override
    public void search() {
        customerNgList.clear();

        ReadAndWrite.readCustomerNg("src/_quan_ly_tien_dien/data/customerNg.csv", customerNgList);

        System.out.println("Nhập tên khách hàng muốn tìm: ");
        String name = scanner.nextLine();

        boolean flag = false;
        for (CustomerNg item: customerNgList) {
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
}
