package _bai_thi.controlles;

import _bai_thi.service.LongTermService;
import _bai_thi.service.ShortTermService;
import _bai_thi.service.impl.LongTermServiceImpl;
import _bai_thi.service.impl.ShortTermServiceImpl;

import java.util.Scanner;

public class DisplayBanking {
    static int choose = 0;

    static Scanner scanner = new Scanner(System.in);

    static LongTermService longTermService = new LongTermServiceImpl();

    static ShortTermService shortTermService = new ShortTermServiceImpl();

    public static void disPlayBanking() {
        do {
            System.out.println("-----------Manager Banking------------");
            System.out.println("1. Thêm mới sổ tiết kiệm");
            System.out.println("2. Xoá sổ tiết kiệm");
            System.out.println("3. Xem danh sách sổ tiết kiệm");
            System.out.println("4. Thoát");
            System.out.println("Enter your choose");

            switch (exceptionPerson(choose)) {
                case 1:
                    addNewBanking();
                    break;
                case 2:
                    deleteBanking();
                    break;
                case 3:
                    viewBanking();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void addNewBanking() {
        do {
            System.out.println("--------Thêm mới Banking----------");
            System.out.println("1. Thêm mới sổ tiết kiệm dài hạn");
            System.out.println("2. Thêm mới sổ tiết kiệm ngắn hạn");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("Thêm mới sổ tiết kiệm dài hạn");
                    longTermService.addNew();
                    break;
                case 2:
                    System.out.println("Thêm mới sổ tiết kiệm ngắn hạn");
                    shortTermService.addNew();
                    break;
                case 3:
                    disPlayBanking();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
                    break;
            }
        } while (true);
    }

    public static void deleteBanking() {
        do {
            System.out.println("--------Xóa Banking----------");
            System.out.println("1. xóa sổ tiết kiệm dài hạn");
            System.out.println("2. xóa sổ tiết kiệm ngắn hạn");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("xóa sổ tiết kiệm dài hạn");
                    longTermService.delete();
                    break;
                case 2:
                    System.out.println("xóa sổ tiết kiệm ngắn hạn");
                    shortTermService.delete();
                    break;
                case 3:
                    disPlayBanking();
                    break;
                default:
                    System.out.println("Không có option này, xin hãy nhập lại");
            }
        } while (true);
    }

    public static void viewBanking() {
        do {
            System.out.println("--------Xem Banking----------");
            System.out.println("1. xem sổ tiết kiệm dài hạn");
            System.out.println("2. xem sổ tiết kiệm ngắn hạn");
            System.out.println("3. quay lại menu chính");
            System.out.println("Enter your choose");
            switch (exceptionPerson(choose)) {
                case 1:
                    System.out.println("danh sách sổ tiết kiệm dài hạn");
                    longTermService.view();
                    break;
                case 2:
                    System.out.println("danh sách tiết kiệm ngắn hạn");
                    shortTermService.view();
                    break;
                case 3:
                    disPlayBanking();
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
