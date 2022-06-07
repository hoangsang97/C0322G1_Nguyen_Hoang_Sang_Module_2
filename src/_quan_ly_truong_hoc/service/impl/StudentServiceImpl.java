package _quan_ly_truong_hoc.service.impl;

import _quan_ly_truong_hoc.exception.NotFoundEmployeeException;
import _quan_ly_truong_hoc.models.Student;
import _quan_ly_truong_hoc.service.StudentService;
import _quan_ly_truong_hoc.utils.PersonDateComparator;
import _quan_ly_truong_hoc.utils.PersonNameComparator;
import _quan_ly_truong_hoc.utils.ReadAndWrite;
import _quan_ly_truong_hoc.utils.RegexData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentServiceImpl implements StudentService {
    public static Scanner scanner = new Scanner(System.in);

    public static List<Student> studentList = new ArrayList<>();

    private static final String REGEX_BIRTHDAY = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    public static final String REGEX_POINT = "^[0-9]$";

    public static final String REGEX_ID_STUDENT = "^([0]{1}\\d{9})$";

    @Override
    public void view() {
        studentList.clear();

        ReadAndWrite.readStudent("src/_quan_ly_truong_hoc/data/student.csv", studentList);

        for (Student item: studentList) {
            System.out.println(item);
        }
    }

    @Override
    public void addNew() {
        studentList.clear();
        ReadAndWrite.readStudent("src/_quan_ly_truong_hoc/data/student.csv", studentList);

        int id = 0;

        if (studentList.isEmpty()) {
            id = 1;
        } else {
            for (Student item: studentList) {
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
        System.out.println("Nhập mã sinh viên: ");
        String idStudent;

        boolean checkIdStudent = true;
        do {
            idStudent = RegexData.regexIdStudent(REGEX_ID_STUDENT);

            for (Student item: studentList) {
                if (idStudent.equals(item.getIdStudent())) {
                    System.out.println("Mã sinh viên đã tồn tại, xin vui lòng nhập lại");
                } else {
                    checkIdStudent = false;
                }
            }
        } while (checkIdStudent);


        System.out.println("Nhập điểm trung bình: ");
        double point = Double.parseDouble(RegexData.regexPoint(REGEX_POINT));

        Student student = new Student(id, name, sex, dateOfBirth, address, idStudent, point);
        studentList.add(student);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeStudent("src/_quan_ly_truong_hoc/data/student.csv", studentList);
    }

    @Override
    public void delete() {
        studentList.clear();

        ReadAndWrite.readStudent("src/_quan_ly_truong_hoc/data/student.csv", studentList);

        for (Student item: studentList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn xóa: ");

        int id = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = Integer.parseInt(scanner.nextLine());

                switch (inputChoose) {
                    case 1:
                        studentList.remove(i);
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

        ReadAndWrite.writeStudent("src/_quan_ly_truong_hoc/data/student.csv", studentList);
    }

    @Override
    public void sort() {
        studentList.clear();

        ReadAndWrite.readStudent("src/_quan_ly_truong_hoc/data/student.csv", studentList);

        System.out.println("1. sắp xếp theo tên");
        System.out.println("2. sắp xếp ngày sinh");
        System.out.println("Enter your choose");

        int inputChoose = Integer.parseInt(scanner.nextLine());
        if (inputChoose == 1) {
            Collections.sort(studentList, new PersonNameComparator());

            for (Student item: studentList) {
                System.out.println(item);
            }
        } else if (inputChoose == 2) {
            Collections.sort(studentList, new PersonDateComparator());

            for (Student item: studentList) {
                System.out.println(item);
            }
        } else {
            System.out.println("Không có option này!");
        }
    }

    @Override
    public void edit() {
        studentList.clear();
        ReadAndWrite.readStudent("src/_quan_ly_truong_hoc/data/student.csv", studentList);

        for (Student item: studentList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn sửa: ");

        int id = Integer.parseInt(scanner.nextLine());

        int count = 0;
        for (int i = 0; i < studentList.size(); i++) {
            if (id == studentList.get(i).getId()) {
                System.out.println("Nhập Tên: ");
                String name = scanner.nextLine();
                System.out.println("Nhập giới tính: ");
                String sex = scanner.nextLine();
                System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
                String dateOfBirth = RegexData.regexAge(scanner.nextLine(), REGEX_BIRTHDAY);
                System.out.println("Nhập địa chỉ: ");
                String address = scanner.nextLine();
                System.out.println("Nhập mã sinh viên: ");
                String idStudent = scanner.nextLine();
                System.out.println("Nhập điểm trung bình: ");
                double point = Double.parseDouble(RegexData.regexPoint(REGEX_POINT));

                studentList.get(i).setName(name);
                studentList.get(i).setSex(sex);
                studentList.get(i).setDateOfBirth(dateOfBirth);
                studentList.get(i).setAddress(address);
                studentList.get(i).setIdStudent(idStudent);
                studentList.get(i).setPoint(point);

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

        ReadAndWrite.writeStudent("src/_quan_ly_truong_hoc/data/student.csv", studentList);
    }
}
