package _case_study.services.impl;

import _case_study.models.facility.Facility;
import _case_study.models.facility.House;
import _case_study.models.facility.Room;
import _case_study.models.facility.Villa;
import _case_study.services.FacilityService;
import _case_study.utils.RegexData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {

    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "[\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";

    private static Map<Integer, Facility> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Map.Entry<Integer, Facility> item : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + item.getValue() + " Số lần đã thuê: " + item.getKey());
        }
    }

    @Override
    public void displayMaintain() {

    }

    @Override
    public void addNewVilla() {
        int id = Integer.parseInt(inputId());
        String name = inputName();
        double area = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputTotalPay());
        System.out.println("Nhập số lượng người");
        int people = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu thuê");
        String renType = scanner.nextLine();
        System.out.println("Nhập tiêu chuẩn");
        String standard = scanner.nextLine();
        System.out.println("Nhập diện tích hồ bơi");
        double areaPool = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số tầng");
        int floor = Integer.parseInt(scanner.nextLine());

        Villa villa = new Villa(id, name, area, price, people, renType, standard, areaPool, floor);
        facilityIntegerMap.put(0, villa);
        System.out.println("Đã thêm mới villa thành công");
    }

    private String inputId() {
        System.out.println("Nhập id");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_VILLA, "Bạn đã nhập sai định dạng, mã định dạng phải có dạng là XXXX");
    }

    private String inputName() {
        System.out.println("Nhập tên dịch vụ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, tên dịch vụ phải viết hoa chữ cái đầu");
    }

    private String inputArea() {
        System.out.println("Nhập diện tích hồ bơi");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA, "Bạn đã nhập sai định dạng, diện tích phải lớn hơn 30");
    }

    private String inputTotalPay() {
        System.out.println("Nhập giá tiền");
        return RegexData.regexStr(scanner.nextLine(), REGEX_INT, "Bạn đã nhập sai định dạng, giá tiền phải là số dương");
    }

    @Override
    public void addNewHouse() {
        int id = Integer.parseInt(inputId());
        String name = inputName();
        double area = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputTotalPay());
        System.out.println("Nhập số lượng người");
        int people = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu thuê");
        String renType = scanner.nextLine();
        System.out.println("Nhập tiêu chuẩn");
        String standard = scanner.nextLine();
        System.out.println("Nhập số tầng");
        int floor = Integer.parseInt(scanner.nextLine());

        House house = new House(id, name, area, price, people, renType, standard, floor);
        facilityIntegerMap.put(0, house);
        System.out.println("Đã thêm mới house thành công");
    }

    @Override
    public void addNewRoom() {
        int id = Integer.parseInt(inputId());
        String name = inputName();
        double area = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputTotalPay());
        System.out.println("Nhập số lượng người");
        int people = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập kiểu thuê");
        String renType = scanner.nextLine();
        System.out.println("Nhập Dịch vụ miễn phí");
        String freeService = scanner.nextLine();

        Room room = new Room(id, name, area, price, people, renType, freeService);
        facilityIntegerMap.put(0, room);
        System.out.println("Đã thêm mới room thành công");
    }
}
