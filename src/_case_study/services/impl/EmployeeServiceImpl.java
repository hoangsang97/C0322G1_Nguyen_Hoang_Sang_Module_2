package _case_study.services.impl;

import _case_study.models.person.Employee;
import _case_study.services.EmployeeService;
import _case_study.utils.ReadAndWrite;
import _case_study.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService {
    private static List<Employee> employeeList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
//    private static final String BIRTHDAY_REGEX = "(^(((0[1-9]|1[0-9]|2[0-8])[\\/](0[1-9]|1[012]))|((29|30|31)[\\/](0[13578]|1[02]))";

    @Override
    public void display() {
//        employeeList = (List<Employee>) ReadAndWrite.read("C:\\Users\\sangn\\Desktop\\C0322G1\\C0322G1_Nguyen_Hoang_Sang_Module_2\\src\\_case_study\\data\\employee.csv");
        for (Employee item : employeeList) {
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
        System.out.println("Nhập chức vụ");
        String level = scanner.nextLine();
        System.out.println("Nhập vị trí");
        String position = scanner.nextLine();
        System.out.println("Nhập lương");
        int salary = Integer.parseInt(scanner.nextLine());

        Employee employee = new Employee(id, name, age, sex, idCard, email, level, position, salary);
        employeeList.add(employee);
        System.out.println("Đã thêm thành công");
//        ReadAndWrite.write(employeeList, "C:\\Users\\sangn\\Desktop\\C0322G1\\C0322G1_Nguyen_Hoang_Sang_Module_2\\src\\_case_study\\data\\employee.csv");
    }

    @Override
    public void edit() {
        int checkId = 0;
        System.out.println("Nhập id muốn sửa: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == inputId) {
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
                System.out.println("Nhập chức vụ");
                String level = scanner.nextLine();
                System.out.println("Nhập vị trí");
                String position = scanner.nextLine();
                System.out.println("Nhập lương");
                int salary = Integer.parseInt(scanner.nextLine());
                employeeList.get(i).setName(name);
                employeeList.get(i).setAge(age);
                employeeList.get(i).setSex(sex);
                employeeList.get(i).setIdCard(idCard);
                employeeList.get(i).setEmail(email);
                employeeList.get(i).setLevel(level);
                employeeList.get(i).setPosition(position);
                employeeList.get(i).setSalary(salary);
                System.out.println("Cập nhập thành công");
                checkId++;
            }
        }
        if (checkId == 0) {
            System.out.println("Không tìm thấy id");
        }
    }

    public void levelEmployee() {
        System.out.println("----------Các cấp bậc chức vụ--------");
        System.out.println("1. Trung cấp");
        System.out.println("2. Cao đẳng");
        System.out.println("3. Đại học ");
        System.out.println("4. sau đại học");
    }

    @Override
    public void delete() {

    }
}