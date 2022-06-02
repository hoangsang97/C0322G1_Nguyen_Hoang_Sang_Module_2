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
    static List<String> stringList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String REGEX_BIRTHDAY = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    @Override
    public void display() {
        List<String[]> list = ReadAndWrite.readFile("src/_case_study/data/employee.csv");
        employeeList.clear();
        for (String[] item : list) {
            Employee employee = new Employee(Integer.parseInt(item[0]), item[1], item[2], item[3], item[4], item[5], item[6], item[7], Integer.parseInt(item[8]));
            employeeList.add(employee);
        }

        for (Employee item : employeeList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        List<String[]> list = ReadAndWrite.readFile("src/_case_study/data/employee.csv");
        String line = "";
        stringList.clear();
        employeeList.clear();
        for (String[] item : list) {
            Employee employee = new Employee(Integer.parseInt(item[0]), item[1], item[2], item[3], item[4], item[5], item[6], item[7], Integer.parseInt(item[8]));
            employeeList.add(employee);
        }
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập số tuổi");
        String age = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
        System.out.println("Nhập giới tính");
        String sex = scanner.nextLine();
        System.out.println("Nhập chứng minh");
        String idCard = scanner.nextLine();
        System.out.println("Nhập Email");
        String email = scanner.nextLine();
        System.out.println("Nhập chức vụ");
        String level = scanner.nextLine();
        String position = positions();
        System.out.println("Nhập lương");
        int salary = Integer.parseInt(scanner.nextLine());
        int id = employeeList.get(employeeList.size() - 1).getId() + 1;
        Employee employee = new Employee(id, name, age, sex, idCard, email, level, position, salary);
        employeeList.add(employee);
        System.out.println("Đã thêm thành công");

        ReadAndWrite.writeEmployee("src/_case_study/data/employee.csv", employeeList);
    }

    @Override
    public void edit() {
        String line = "";
        stringList.clear();
        employeeList.clear();

        ReadAndWrite.readEmployee("src/_case_study/data/employee.csv", employeeList);

        int checkId = 0;
        System.out.println("Nhập id muốn sửa: ");
        int inputId = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == inputId) {
                System.out.println("Nhập tên");
                String name = scanner.nextLine();
                System.out.println("Nhập tuổi");
                String age = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
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

        ReadAndWrite.writeEmployee("src/_case_study/data/employee.csv", employeeList);
    }

    public static String positions() {
        String temp;
        boolean check = true;
        do {
            System.out.println("Nhập vị trí");
            System.out.println("1. Lễ tân");
            System.out.println("2. phục vụ");
            System.out.println("3. chuyên viên");
            System.out.println("4. giám sát");
            System.out.println("5. quản lý");
            System.out.println("6 .giám đốc");
            System.out.println("Enter your choose");
            temp = scanner.nextLine();
            switch (temp) {
                case "1":
                    System.out.println("Lễ tân");
                    check = false;
                    break;
                case "2":
                    System.out.println("phục vụ");
                    check = false;
                    break;
                case "3":
                    System.out.println("chuyên viên");
                    check = false;
                    break;
                case "4":
                    System.out.println("giám sát");
                    check = false;
                    break;
                case "5":
                    System.out.println("quản lý");
                    check = false;
                    break;
                case "6":
                    System.out.println("giám đốc");
                    check = false;
                    break;
            }
        } while (check);

        return temp;
    }
}