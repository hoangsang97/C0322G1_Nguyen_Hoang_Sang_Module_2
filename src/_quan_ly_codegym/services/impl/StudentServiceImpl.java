package _quan_ly_codegym.services.impl;

import _quan_ly_codegym.models.Student;
import _quan_ly_codegym.services.StudentService;
import _quan_ly_codegym.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    static Scanner scanner =  new Scanner(System.in);

    static List<Student> studentList = new ArrayList<>();

    @Override
    public void addNew() {
        System.out.println("Nhập ID: ");
        String id = scanner.nextLine();
        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Nhập tên lớp: ");
        String className = scanner.nextLine();
        System.out.println("Nhập điểm: ");
        int point = Integer.parseInt(scanner.nextLine());

        Student student = new Student(id, name, dateOfBirth, sex, className, point);
        studentList.add(student);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeStudent("src/_quan_ly_codegym/data/saving.csv", studentList);
    }

    @Override
    public void delete() {
        studentList.clear();

        ReadAndWrite.readStudent("src/_quan_ly_codegym/data/saving.csv", studentList);

        for (Student item: studentList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn xóa: ");
        String id = scanner.nextLine();
        studentList.removeIf(item -> id.equals(item.getId()));

        System.out.println("đã xóa thành công");

        ReadAndWrite.writeStudent("src/_quan_ly_codegym/data/saving.csv", studentList);
    }

    @Override
    public void view() {
        studentList.clear();

        ReadAndWrite.readStudent("src/_quan_ly_codegym/data/saving.csv", studentList);

        for (Student item: studentList) {
            System.out.println(item);
        }
    }

    @Override
    public void search() {
        studentList.clear();

        ReadAndWrite.readStudent("src/_quan_ly_codegym/data/saving.csv", studentList);

        System.out.println("Nhập tên học sinh muốn tìm: ");
        String name = scanner.nextLine();

        boolean flag = false;
        for (Student item: studentList) {
            if (name.contains(item.getName())) {
                System.out.println(item);
            } else {
               flag = true;
            }
        }

        if (flag) {
            System.out.println("Không tìm thấy tên học sinh");
        }
    }
}
