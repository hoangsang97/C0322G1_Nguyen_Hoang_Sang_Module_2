package _quan_ly_codegym.services.impl;

import _quan_ly_codegym.models.Student;
import _quan_ly_codegym.models.Teacher;
import _quan_ly_codegym.services.Person;
import _quan_ly_codegym.services.TeacherService;
import _quan_ly_codegym.utils.ReadAndWrite;
import _quan_ly_codegym.utils.RegexData;

import java.util.*;

public class TeacherServiceImpl implements TeacherService {
    static Scanner scanner =  new Scanner(System.in);

    static List<Teacher> teacherList = new LinkedList<>();

    private static final String REGEX_BIRTHDAY = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    static final String REGEX_SEX = "^(nam|nu|khac)$";

    public static final String REGEX_ID_STUDENT = "(SV)[-][\\d]{4}";

    @Override
    public void addNew() {
        ReadAndWrite.readTeacher("src/_quan_ly_codegym/data/experience.csv", teacherList);
        String id;
        boolean checkId = true;
        do {
            System.out.println("Nhập ID: ");
            id = RegexData.regexStudent(REGEX_ID_STUDENT);
            checkId = false;
            for (Teacher item: teacherList) {
                if (item.getId().equals(id)) {
                    System.out.println("id đã bị trùng, xin hãy nhập lại");
                    checkId = true;
                }
            }
        }while (checkId);

        System.out.println("Nhập Tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày tháng năm sinh (dd/MM/yyyy): ");
        String dateOfBirth = scanner.nextLine();
        System.out.println("Nhập giới tính: ");
        String sex = RegexData.regexSex(REGEX_SEX);
        System.out.println("Nhập chuyên môn: ");
        String regular = scanner.nextLine();

        Teacher teacher = new Teacher(id, name, dateOfBirth, sex, regular);
        teacherList.add(teacher);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeTeacher("src/_quan_ly_codegym/data/fresher.csv", teacherList);
    }

    @Override
    public void delete() {
        teacherList.clear();

        ReadAndWrite.readTeacher("src/_quan_ly_codegym/data/fresher.csv", teacherList);

        for (Teacher item: teacherList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn xóa: ");
        String id = scanner.nextLine();
        teacherList.removeIf(item -> id.equals(item.getId()));

        System.out.println("đã xóa thành công");

        ReadAndWrite.writeTeacher("src/_quan_ly_codegym/data/fresher.csv", teacherList);
    }

    @Override
    public void view() {
        teacherList.clear();

        ReadAndWrite.readTeacher("src/_quan_ly_codegym/data/fresher.csv", teacherList);

        for (Teacher item: teacherList) {
            System.out.println(item);
        }
    }

    @Override
    public void search() {
        teacherList.clear();

        ReadAndWrite.writeTeacher("src/_quan_ly_codegym/data/fresher.csv", teacherList);

        System.out.println("Nhập tên giáo viên muốn tìm: ");
        String name = scanner.nextLine();

        boolean flag = false;
        for (Teacher item: teacherList) {
            if (name.contains(item.getName())) {
                System.out.println(item);
            } else {
                flag = true;
            }
        }

        if (flag) {
            System.out.println("Không tìm thấy tên giáo viên");
        }
    }
}
