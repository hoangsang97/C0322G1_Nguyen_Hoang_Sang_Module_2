package _bai_thi.service.impl;

import _bai_thi.exception.NotFoundEmployeeException;
import _bai_thi.models.LongTerm;
import _bai_thi.models.ShortTermCoThoiHan;
import _bai_thi.models.ShortTermVoThoiHan;
import _bai_thi.service.ShortTermService;
import _bai_thi.utils.ReadAndWrite;
import _bai_thi.utils.RegexData;

import java.util.*;

public class ShortTermServiceImpl implements ShortTermService {
    public static Scanner scanner = new Scanner(System.in);

    public static List<ShortTermVoThoiHan> shortTermVoThoiHanList = new ArrayList<>();

    public static List<ShortTermCoThoiHan> shortTermCoThoiHanList = new ArrayList<>();

    private static final String REGEX_DATE = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    public static final String REGEX_ID_BANKING = "(STK)[-][\\d]{4}";

    @Override
    public void addNew() {
        System.out.println("Thêm mới sổ tiết kiệm vô thời hạn hay có thời hạn?");
        System.out.println("1. Thêm mới sổ tiết kiệm vô thời hạn");
        System.out.println("2. Thêm mới sổ tiết kiệm có thời hạn");
        int inputChoose = Integer.parseInt(scanner.nextLine());

        if (inputChoose == 1) {
            addNewVoThoiHan();
        } else if (inputChoose == 2) {
            addNewCoThoiHan();
        } else {
            System.out.println("không có option này xin hãy nhập lại");
        }


    }

    @Override
    public void delete() {
        System.out.println("Xoá sổ tiết kiệm vô thời hạn hay có thời hạn?");
        System.out.println("1. Xoá sổ tiết kiệm vô thời hạn");
        System.out.println("2. Xoá sổ tiết kiệm có thời hạn");
        int inputChoose = Integer.parseInt(scanner.nextLine());


        if (inputChoose == 1) {
            deleteShortTermVoThoiHan();
        } else if (inputChoose == 2) {
            deleteShortTermCoThoiHan();
        } else {
            System.out.println("không có option này xin hãy nhập lại");
        }
    }

    @Override
    public void view() {
        shortTermVoThoiHanList.clear();

        ReadAndWrite.readShortTermVoThoiHan("src/_bai_thi/data/shortTermVoThoiHan.csv", shortTermVoThoiHanList);

        shortTermCoThoiHanList.clear();

        ReadAndWrite.readShortTermCoThoiHan("src/_bai_thi/data/shortTermCoThoiHan.csv", shortTermCoThoiHanList);

        for (ShortTermVoThoiHan item: shortTermVoThoiHanList) {
            System.out.println(item);
        }

        for (ShortTermCoThoiHan item: shortTermCoThoiHanList) {
            System.out.println(item);
        }
    }

    public static void addNewVoThoiHan() {
        shortTermVoThoiHanList.clear();
        ReadAndWrite.readShortTermVoThoiHan("src/_bai_thi/data/shortTermVoThoiHan.csv", shortTermVoThoiHanList);

        System.out.println("Nhập mã số sổ: ");
        String id = RegexData.regexIdBanking(REGEX_ID_BANKING);

        int idCustomer = 0;

        if (shortTermVoThoiHanList.isEmpty()) {
            idCustomer = 1;
        } else {
            for (ShortTermVoThoiHan item: shortTermVoThoiHanList) {
                idCustomer = item.getIdCustomer() + 1;
            }
        }

        System.out.println("Nhập ngày mở xổ: ");
        String starDate = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
        System.out.println("Nhập thời gian bắt đầu gửi: ");
        String timeDate = scanner.nextLine();
        System.out.println("Nhập số tiền gửi ");
        double money = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lãi xuất ");
        double interestRate = Double.parseDouble(scanner.nextLine());

        ShortTermVoThoiHan shortTermVoThoiHan = new ShortTermVoThoiHan(id, idCustomer, starDate, timeDate, money, interestRate);
        shortTermVoThoiHanList.add(shortTermVoThoiHan);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeShortTeamVoThoiHan("src/_bai_thi/data/shortTermVoThoiHan.csv", shortTermVoThoiHanList);
    }

    public static void addNewCoThoiHan() {
        shortTermCoThoiHanList.clear();
        ReadAndWrite.readShortTermCoThoiHan("src/_bai_thi/data/shortTermCoThoiHan.csv", shortTermCoThoiHanList);

        System.out.println("Nhập mã số sổ: ");
        String id = RegexData.regexIdBanking(REGEX_ID_BANKING);

        int idCustomer = 0;

        if (shortTermVoThoiHanList.isEmpty()) {
            idCustomer = 1;
        } else {
            for (ShortTermVoThoiHan item: shortTermVoThoiHanList) {
                idCustomer = item.getIdCustomer() + 1;
            }
        }

        System.out.println("Nhập ngày mở xổ: ");
        String starDate = RegexData.regexDate(scanner.nextLine(), REGEX_DATE);
        System.out.println("Nhập thời gian bắt đầu gửi: ");
        String timeDate = scanner.nextLine();
        System.out.println("Nhập số tiền gửi ");
        double money = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lãi xuất ");
        double interestRate = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập kỳ hạn ");
        String deadLine = scanner.nextLine();

        ShortTermCoThoiHan shortTermCoThoiHan = new ShortTermCoThoiHan(id, idCustomer, starDate, timeDate, money, interestRate, deadLine);
        shortTermCoThoiHanList.add(shortTermCoThoiHan);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeShortTeamCoThoiHan("src/_bai_thi/data/shortTermCoThoiHan.csv", shortTermCoThoiHanList);
    }

    public static void deleteShortTermVoThoiHan() {
        shortTermVoThoiHanList.clear();

        ReadAndWrite.readShortTermVoThoiHan("src/_bai_thi/data/shortTermVoThoiHan.csv", shortTermVoThoiHanList);

        for (ShortTermVoThoiHan item: shortTermVoThoiHanList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn xóa: ");

        String id = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < shortTermVoThoiHanList.size(); i++) {
            if (id.equals(shortTermVoThoiHanList.get(i).getId())) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = Integer.parseInt(scanner.nextLine());

                switch (inputChoose) {
                    case 1:
                        shortTermVoThoiHanList.remove(i);
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

        ReadAndWrite.writeShortTeamVoThoiHan("src/_bai_thi/data/shortTermVoThoiHan.csv", shortTermVoThoiHanList);
    }

    public static void deleteShortTermCoThoiHan() {
        shortTermCoThoiHanList.clear();

        ReadAndWrite.readShortTermCoThoiHan("src/_bai_thi/data/shortTermCoThoiHan.csv", shortTermCoThoiHanList);

        for (ShortTermCoThoiHan item: shortTermCoThoiHanList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn xóa: ");

        String id = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < shortTermCoThoiHanList.size(); i++) {
            if (id.equals(shortTermCoThoiHanList.get(i).getId())) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = Integer.parseInt(scanner.nextLine());

                switch (inputChoose) {
                    case 1:
                        shortTermCoThoiHanList.remove(i);
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

        ReadAndWrite.writeShortTeamCoThoiHan("src/_bai_thi/data/shortTermCoThoiHan.csv", shortTermCoThoiHanList);
    }
}
