package _quan_ly_tien_dien.services.impl;

import _quan_ly_tien_dien.models.bill.Bill;
import _quan_ly_tien_dien.models.customer.Customer;
import _quan_ly_tien_dien.models.customer.CustomerVn;
import _quan_ly_tien_dien.services.BillService;
import _quan_ly_tien_dien.utils.ReadAndWrite;
import _quan_ly_tien_dien.utils.RegexData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BillServiceImpl implements BillService {
    static List<Bill> billList = new ArrayList<>();

    static List<Customer> customerList = new LinkedList<>();

    static List<CustomerVn> customerVnList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static final String REGEX_ID_CUSTOMER_BILL = "(LKH)[-][\\d]{3}";

    public static final String REGEX_DATE = "^\\d{1,2}/\\d{1,2}/\\d{4}$";

    @Override
    public void addNew() {
        ReadAndWrite.readCustomer(customerList);

        System.out.println(customerList);

        String id = null;

        String name = null;

        boolean checkIdCustomer = true;
        do {
            System.out.println("Nhập id khách hàng");
            id = scanner.nextLine();
            for (int i = 0; i < customerList.size(); i++) {
                if (id.equals(customerList.get(i).getId())) {
                    checkIdCustomer = false;
                    name = customerList.get(i).getName();
                } else {
                    System.out.println("không tìm thấy id khách hàng, xin vui lòng nhập lại");
                    checkIdCustomer = true;
                }
            }
        } while (checkIdCustomer);

        ReadAndWrite.readBill("src/_quan_ly_tien_dien/data/bill.csv", billList);
        String idBill;
        boolean checkId = true;
        do {
            System.out.println("Nhập mã khách hàng: ");
            idBill = RegexData.regexIdBill(REGEX_ID_CUSTOMER_BILL);
            checkId = false;
            boolean flag = false;
            for (Bill item: billList) {
                if (item.getId().equals(idBill)) {
                    flag = true;
                    checkId = true;
                }
            }

            if (flag) {
                System.out.println("id đã bị trùng, xin hãy nhập lại");
            }
        }while (checkId);
        System.out.println("Nhập ngày ra hoá đơn (dd/MM/yyyy): ");
        String dateBill = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
        System.out.println("Nhập số lượng (số KW tiêu thụ): ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập đơn giá: ");
        double price = Double.parseDouble(scanner.nextLine());

        double totalMoney = 0;

        ReadAndWrite.readCustomerVn("src/_quan_ly_tien_dien/data/customerVN.csv", customerVnList);

        for (Customer item: customerList) {
            if (item instanceof CustomerVn) {
                for (CustomerVn customerVn : customerVnList) {
                    if (amount <= customerVn.getConsume()) {
                        totalMoney = amount * price;
                    } else {
                        totalMoney = amount * price * customerVn.getConsume() + amount * price * 2.5;
                    }
                }
            } else {
                totalMoney = amount * price;
            }
        }

        Bill bill = new Bill(id, name, idBill, dateBill, amount, price, totalMoney);
        billList.add(bill);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeBill("src/_quan_ly_tien_dien/data/bill.csv", billList);
    }

    @Override
    public void edit() {
        ReadAndWrite.readCustomer(customerList);

        billList.clear();
        ReadAndWrite.readBill("src/_quan_ly_tien_dien/data/bill.csv", billList);

        System.out.println("Nhập mã khách hàng: ");
        String idBill = scanner.nextLine();

        boolean flag = true;

        for (Bill item: billList) {
            if (idBill.equals(item.getBillId())) {
                System.out.println("Nhập ngày ra hoá đơn (dd/MM/yyyy): ");
                String dateBill = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
                System.out.println("Nhập số lượng (số KW tiêu thụ): ");
                double amount = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập đơn giá: ");
                double price = Double.parseDouble(scanner.nextLine());

                double totalMoney = 0;

                ReadAndWrite.readCustomerVn("src/_quan_ly_tien_dien/data/customerVN.csv", customerVnList);

                for (Customer customer: customerList) {
                    if (customer instanceof CustomerVn) {
                        for (CustomerVn customerVn : customerVnList) {
                            if (amount <= customerVn.getConsume()) {
                                totalMoney = amount * price;
                            } else {
                                totalMoney = amount * price * customerVn.getConsume() + amount * price * 2.5;
                            }
                        }
                    } else {
                        totalMoney = amount * price;
                    }
                }

                item.setDateBill(dateBill);
                item.setAmount(amount);
                item.setPrice(price);
                item.setTotalMoney(totalMoney);

                System.out.println("Cập nhập thành công!");

                ReadAndWrite.writeBill("src/_quan_ly_tien_dien/data/bill.csv", billList);
            } else {
                flag = false;
            }
        }

        if (flag == false) {
            System.out.println("Không tìm thấy mã khách hàng");
        }
    }

    @Override
    public void view() {
        billList.clear();

        ReadAndWrite.readBill("src/_quan_ly_tien_dien/data/bill.csv", billList);

        for (Bill item: billList) {
            System.out.println(item);
        }
    }
}
