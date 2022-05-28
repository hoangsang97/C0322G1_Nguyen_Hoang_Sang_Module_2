package _case_study.services.impl;

import _case_study.models.person.Customer;
import _case_study.services.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Customer item: customerList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập giới tính");
        String sex = scanner.nextLine();
        System.out.println("Nhập chứng minh");
        String idCard = scanner.nextLine();
        System.out.println("Nhập Email");
        String email = scanner.nextLine();
        System.out.println("Nhập loại khách hàng");
        String typeCustomer = scanner.nextLine();
        System.out.println("Nhập Địa chỉ");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, name, age, sex, idCard, email, typeCustomer, address);
        customerList.add(customer);
        System.out.println("Đã thêm khách hàng thành công");
    }

    @Override
    public void edit() {
        int checkId = 0;
        System.out.println("Nhập id muốn sửa: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == inputId) {
                System.out.println("Nhập tên");
                String name = scanner.nextLine();
                System.out.println("Nhập tuổi");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập giới tính");
                String sex = scanner.nextLine();
                System.out.println("Nhập chứng minh");
                String idCard = scanner.nextLine();
                System.out.println("Nhập Email");
                String email = scanner.nextLine();
                System.out.println("Nhập loại khách hàng");
                String typeCustomer = scanner.nextLine();
                System.out.println("Nhập Địa chỉ");
                String address = scanner.nextLine();

                customerList.get(i).setName(name);
                customerList.get(i).setAge(age);
                customerList.get(i).setSex(sex);
                customerList.get(i).setIdCard(idCard);
                customerList.get(i).setEmail(email);
                customerList.get(i).setTypeCustomer(typeCustomer);
                customerList.get(i).setAddress(address);

                System.out.println("Cập nhập thành công");
                checkId++;
            }
        }
        if (checkId == 0) {
            System.out.println("Không tìm thấy id");
        }
    }

    @Override
    public void delete() {

    }
}
