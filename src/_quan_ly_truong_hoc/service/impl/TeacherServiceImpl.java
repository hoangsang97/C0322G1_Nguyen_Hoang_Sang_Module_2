package _quan_ly_truong_hoc.service.impl;

import _quan_ly_truong_hoc.exception.NotFoundEmployeeException;
import _quan_ly_truong_hoc.models.Teacher;
import _quan_ly_truong_hoc.service.TeacherService;
import _quan_ly_truong_hoc.utils.PersonDateComparator;
import _quan_ly_truong_hoc.utils.PersonNameComparator;
import _quan_ly_truong_hoc.utils.ReadAndWrite;
import _quan_ly_truong_hoc.utils.RegexData;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TeacherServiceImpl implements TeacherService {
    public static Scanner scanner = new Scanner(System.in);

    public static List<Teacher> teacherList = new LinkedList<>();

    private static final String REGEX_BIRTHDAY = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    public static final String REGEX_INT = "^[0-9]+$";

    @Override
    public void view() {
        teacherList.clear();

        ReadAndWrite.readTeacher("src/_quan_ly_truong_hoc/data/teacher.csv", teacherList);

        for (Teacher item: teacherList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        teacherList.clear();

        ReadAndWrite.readTeacher("src/_quan_ly_truong_hoc/data/teacher.csv", teacherList);

        int id = 0;

        if (teacherList.isEmpty()) {
            id = 1;
        } else {
            for (Teacher item: teacherList) {
                id = item.getId() + 1;
            }
        }

        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String sex = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
        String dateOfBirth = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
        System.out.println("Nhập địa chỉ: ");
        String address = scanner.nextLine();
        System.out.println("Nhập lương dạy một giờ: ");
        double salary = Double.parseDouble(RegexData.regexSalary(REGEX_INT));
        System.out.println("Nhập số giờ dạy trong tháng: ");
        int time = Integer.parseInt(RegexData.regexTime(REGEX_INT));

        Teacher teacher = new Teacher(id, name, sex, dateOfBirth, address, salary, time);
        teacherList.add(teacher);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeTeacher("src/_quan_ly_truong_hoc/data/teacher.csv", teacherList);
    }

    @Override
    public void delete() {
        teacherList.clear();

        ReadAndWrite.readTeacher("src/_quan_ly_truong_hoc/data/teacher.csv", teacherList);

        for (Teacher item: teacherList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn xóa: ");

        int id = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int i = 0; i < teacherList.size(); i++) {
            if (id == teacherList.get(i).getId()) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = Integer.parseInt(scanner.nextLine());

                switch (inputChoose) {
                    case 1:
                        teacherList.remove(i);
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

        ReadAndWrite.writeTeacher("src/_quan_ly_truong_hoc/data/teacher.csv", teacherList);
    }

    @Override
    public void sort() {
        teacherList.clear();

        ReadAndWrite.readTeacher("src/_quan_ly_truong_hoc/data/teacher.csv", teacherList);

        System.out.println("1. sắp xếp theo tên");
        System.out.println("2. sắp xếp ngày sinh");
        System.out.println("Enter your choose");

        int inputChoose = Integer.parseInt(scanner.nextLine());
        if (inputChoose == 1) {
            Collections.sort(teacherList, new PersonNameComparator());

            for (Teacher item: teacherList) {
                System.out.println(item);
            }
        } else if (inputChoose == 2) {
            Collections.sort(teacherList, new PersonDateComparator());

            for (Teacher item: teacherList) {
                System.out.println(item);
            }
        } else {
            System.out.println("Không có option này!");
        }
    }

    @Override
    public void edit() {
        teacherList.clear();
        ReadAndWrite.readTeacher("src/_quan_ly_truong_hoc/data/teacher.csv", teacherList);

        for (Teacher item: teacherList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn sửa: ");

        int id = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int i = 0; i < teacherList.size(); i++) {
            if (id == teacherList.get(i).getId()) {
                System.out.println("Nhập Tên: ");
                String name = scanner.nextLine();
                System.out.println("Nhập giới tính: ");
                String sex = scanner.nextLine();
                System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
                String dateOfBirth = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
                System.out.println("Nhập địa chỉ: ");
                String address = scanner.nextLine();
                System.out.println("Nhập lương dạy một giờ: ");
                double salary = Double.parseDouble(RegexData.regexSalary(REGEX_INT));
                System.out.println("Nhập số giờ dạy trong tháng: ");
                int time = Integer.parseInt(RegexData.regexTime(REGEX_INT));

                teacherList.get(i).setName(name);
                teacherList.get(i).setSex(sex);
                teacherList.get(i).setDateOfBirth(dateOfBirth);
                teacherList.get(i).setAddress(address);
                teacherList.get(i).setSalary(salary);
                teacherList.get(i).setTime(time);

                System.out.println("Sửa thành công!");

                count++;
            }
        }

        try {
            if (count == 0) {
                throw new NotFoundEmployeeException("Id không tồn tại");
            }
        } catch (NotFoundEmployeeException e){
            System.out.println(e.getMessage());
        }

        ReadAndWrite.writeTeacher("src/_quan_ly_truong_hoc/data/teacher.csv", teacherList);
    }
}
