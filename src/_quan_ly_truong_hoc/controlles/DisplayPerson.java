package _quan_ly_truong_hoc.controlles;

import _quan_ly_truong_hoc.service.StudentService;
import _quan_ly_truong_hoc.service.TeacherService;
import _quan_ly_truong_hoc.service.impl.StudentServiceImpl;
import _quan_ly_truong_hoc.service.impl.TeacherServiceImpl;

import java.util.Scanner;

public class DisplayPerson {
    static int choose = 0;

    static Scanner scanner = new Scanner(System.in);

    static StudentService studentService = new StudentServiceImpl();

    static TeacherService teacherService = new TeacherServiceImpl();

    public static void disPlayPerson() {
        do {
            System.out.println("-----------Manager Person------------");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Xóa nhân viên");
            System.out.println("4. sắp xếp");
            System.out.println("5. chỉnh sửa");
            System.out.println("6. Thoát");
            System.out.println("Enter your choose");

            switch (exceptionPerson(choose)) {
                case 1:
                    viewPerson();
                    break;
                case 2:
                    addNewStaff();
                    break;
                case 3:
                    deletePerson();
                    break;
                case 4:
                    sortPerson();
                    break;
                case 5:
                    editPerson();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void addNewStaff() {
        do {
            System.out.println("--------Thêm mới person----------");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("Thêm mới học sinh");
                    studentService.addNew();
                    break;
                case 2:
                    System.out.println("Thêm mới giảng viên");
                    teacherService.addNew();
                    break;
                case 3:
                    disPlayPerson();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void deletePerson() {
        do {
            System.out.println("--------Xóa person----------");
            System.out.println("1. xóa học sinh");
            System.out.println("2. xóa giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("xóa học sinh");
                    studentService.delete();
                    break;
                case 2:
                    System.out.println("xóa giảng viên");
                    teacherService.delete();
                    break;
                case 3:
                    disPlayPerson();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void viewPerson() {
        do {
            System.out.println("--------Xem person----------");
            System.out.println("1. xem học sinh");
            System.out.println("2. xem giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("danh sách học sinh");
                    studentService.view();
                    break;
                case 2:
                    System.out.println("danh sách giảng viên");
                    teacherService.view();
                    break;
                case 3:
                    disPlayPerson();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void sortPerson() {
        do {
            System.out.println("--------sắp xếp person----------");
            System.out.println("1. sắp xếp học sinh");
            System.out.println("2. sắp xếp giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("sắp xếp học sinh");
                    studentService.sort();
                    break;
                case 2:
                    System.out.println("sắp xếp giảng viên");

                    break;
                case 3:
                    disPlayPerson();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void editPerson() {
        do {
            System.out.println("--------Sửa person----------");
            System.out.println("1. Sửa học sinh");
            System.out.println("2. Sửa giảng viên");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("Sửa học sinh");
                    studentService.sort();
                    break;
                case 2:
                    System.out.println("Sửa giảng viên");
                    teacherService.sort();
                    break;
                case 3:
                    disPlayPerson();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static int exceptionPerson(int inputChoose) {
        boolean checkChoose = false;

        do {
            try {
                inputChoose = Integer.parseInt(scanner.nextLine());
                checkChoose = false;
            } catch (NumberFormatException e) {
                System.out.println("Bạn đã nhập sai định dạng, vui lòng nhập lại: ");
                checkChoose = true;
            }
        } while (checkChoose);

        return inputChoose;
    }
}
