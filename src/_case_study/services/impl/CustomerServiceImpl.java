package _case_study.services.impl;

import _case_study.models.person.Customer;
import _case_study.services.CustomerService;
import _case_study.utils.ReadAndWrite;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    private static List<Customer> customerList = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        List<String[]> lineString = ReadAndWrite.readFile("src/_case_study/data/customer.csv");
        customerList.clear();
        for (String[] item : lineString) {
            Customer customer = new Customer(Integer.parseInt(item[0]), item[1], Integer.parseInt(item[2]), item[3], item[4], item[5], item[6], item[7]);
            customerList.add(customer);
        }
        for (Customer item : customerList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
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
        int id = customerList.get(customerList.size() - 1).getId() + 1;

        Customer customer = new Customer(id, name, age, sex, idCard, email, typeCustomer, address);
        customerList.add(customer);
        String line = customer.getId() + "," + customer.getName() + "," + customer.getAge() + "," + customer.getSex() + "," + customer.getIdCard() + "," + customer.getEmail() + "," + customer.getTypeCustomer() + "," + customer.getAddress();
        ReadAndWrite.writeFile("src/_case_study/data/customer.csv", line);
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
}
