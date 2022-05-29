package _case_study.services.impl;

import _case_study.models.facility.Facility;
import _case_study.models.facility.House;
import _case_study.models.facility.Room;
import _case_study.models.facility.Villa;
import _case_study.services.FacilityService;
import _case_study.utils.ReadAndWrite;
import _case_study.utils.RegexData;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {

    public static final String REGEX_STR = "[A-Z][a-z]+";
    public static final String REGEX_ID_VILLA = "[\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[1-9]|([1][0-9])$";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";

    private static  Map<Integer, Facility> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        List<String[]> list = new ArrayList<>();
        facilityIntegerMap.clear();
        for (String[] item: list) {
            Villa villa = new Villa(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Double.parseDouble(item[7]), Integer.parseInt(item[8]));
            House house = new House(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Integer.parseInt(item[7]));
            facilityIntegerMap.put(0, villa);
            facilityIntegerMap.put(1, house);
        }

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
        String line = villa.getIdFacility() + "," + villa.getNameService() + "," + villa.getAreaUse() + "," + villa.getRentalPrice() + "," + villa.getRentalPeopleMax() + "," + villa.getStyleRental() + "," + villa.getStandardVilla() + "," + villa.getAreaPool() + "," + villa.getFloor();
        ReadAndWrite.writeFile("src/_case_study/data/villa.csv", line);
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
        System.out.println("Nhập diện tích sử dụng");
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
        String line = house.getIdFacility() + "," + house.getNameService() + "," + house.getAreaUse() + "," + house.getRentalPrice() + "," + house.getRentalPeopleMax() + "," + house.getStyleRental() + "," + house.getStandardHouse() + "," + house.getFloor();
        ReadAndWrite.writeFile("src/_case_study/data/house.csv", line);
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
