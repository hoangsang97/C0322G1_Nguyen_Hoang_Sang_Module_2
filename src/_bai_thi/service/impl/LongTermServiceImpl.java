package _bai_thi.service.impl;

import _bai_thi.exception.NotFoundEmployeeException;
import _bai_thi.models.LongTerm;
import _bai_thi.service.LongTermService;
import _bai_thi.utils.ReadAndWrite;
import _bai_thi.utils.RegexData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongTermServiceImpl implements LongTermService {
    public static Scanner scanner = new Scanner(System.in);

    public static List<LongTerm> longTermList = new ArrayList<>();

    private static final String REGEX_DATE = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

    public static final String REGEX_ID_BANKING = "(STK)[-][\\d]{4}";

    @Override
    public void addNew() {
        longTermList.clear();
        ReadAndWrite.readLongTerm("src/_bai_thi/data/longTerm.csv", longTermList);

        System.out.println("Nhập mã số sổ: ");
        String id = RegexData.regexIdBanking(REGEX_ID_BANKING);

        int idCustomer = 0;

        if (longTermList.isEmpty()) {
            idCustomer = 1;
        } else {
            for (LongTerm item: longTermList) {
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
        System.out.println("Nhập ưu đãi: ");
        String preferential = scanner.nextLine();

        LongTerm longTerm = new LongTerm(id, idCustomer, starDate, timeDate, money, interestRate, deadLine, preferential);
        longTermList.add(longTerm);
        System.out.println("thêm mới thành công!");

        ReadAndWrite.writeLongTerm("src/_bai_thi/data/longTerm.csv", longTermList);
    }

    @Override
    public void delete() {
        longTermList.clear();

        ReadAndWrite.readLongTerm("src/_bai_thi/data/longTerm.csv", longTermList);

        for (LongTerm item: longTermList) {
            System.out.println(item);
        }

        System.out.println("nhập id muốn xóa: ");

        String id = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < longTermList.size(); i++) {
            if (id.equals(longTermList.get(i).getId())) {
                System.out.println("Bạn có chắc chắn muốn xóa hay không?");
                System.out.println("1. có");
                System.out.println("2. không");

                int inputChoose = Integer.parseInt(scanner.nextLine());

                switch (inputChoose) {
                    case 1:
                        longTermList.remove(i);
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

        ReadAndWrite.writeLongTerm("src/_bai_thi/data/longTerm.csv", longTermList);
    }

    @Override
    public void view() {
        longTermList.clear();

        ReadAndWrite.readLongTerm("src/_bai_thi/data/longTerm.csv", longTermList);

        for (LongTerm item: longTermList) {
            System.out.println(item);
        }
    }
}
