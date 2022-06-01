package _case_study.services.impl;

import _case_study.models.person.Employee;
import _case_study.services.EmployeeService;
import _case_study.utils.ReadAndWrite;

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
            Employee employee = new Employee(Integer.parseInt(item[0]), item[1], Integer.parseInt(item[2]), item[3], item[4], item[5], item[6], item[7], Integer.parseInt(item[8]));
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
            Employee employee = new Employee(Integer.parseInt(item[0]), item[1], Integer.parseInt(item[2]), item[3], item[4], item[5], item[6], item[7], Integer.parseInt(item[8]));
            employeeList.add(employee);
        }
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
        int id = employeeList.get(employeeList.size() - 1).getId() + 1;
        Employee employee = new Employee(id, name, age, sex, idCard, email, level, position, salary);
        employeeList.add(employee);
        System.out.println("Đã thêm thành công");

        for (Employee item : employeeList) {
            line = item.getId() + "," + item.getName() + "," + item.getAge() + "," + item.getSex() + "," + item.getIdCard() + "," + item.getEmail() + "," + item.getLevel() + "," + item.getPosition() + "," + item.getSalary();
            stringList.add(line);
        }

        String str = "";
        for (String item : stringList) {
            str += item + "\n";
        }
        ReadAndWrite.writeFile("src/_case_study/data/employee.csv", str);
    }

    @Override
    public void edit() {
        List<String[]> list = ReadAndWrite.readFile("src/_case_study/data/employee.csv");
        String line = "";
        stringList.clear();
        employeeList.clear();

        for (String[] item : list) {
            Employee employee = new Employee(Integer.parseInt(item[0]), item[1], Integer.parseInt(item[2]), item[3], item[4], item[5], item[6], item[7], Integer.parseInt(item[8]));
            employeeList.add(employee);
        }

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

        for (Employee item : employeeList) {
            line = item.getId() + "," + item.getName() + "," + item.getAge() + "," + item.getSex() + "," + item.getIdCard() + "," + item.getEmail() + "," + item.getLevel() + "," + item.getPosition() + "," + item.getSalary();
            stringList.add(line);
        }

        String str = "";
        for (String item : stringList) {
            str += item + "\n";
        }
        ReadAndWrite.writeFile("src/_case_study/data/employee.csv", str);
    }
}