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
    public static final String REGEX_ID_VILLA = "(SVVL)[-][\\d]{4}";
    public static final String REGEX_ID_HOUSE = "(SVHO)[-][\\d]{4}";
    public static final String REGEX_ID_ROOM = "(SVRO)[-][\\d]{4}";
    public static final String REGEX_AMOUNT = "^[1-9]|([1][0-9])|(20)$";
    public static final String REGEX_INT = "^[0-9]+$";
    public static final String REGEX_AREA = "^([3-9]\\d|[1-9]\\d{2,})$";

    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    static List<String[]> listLine = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        facilityIntegerMap.clear();
        listLine = ReadAndWrite.readFile("src/_case_study/data/villa.csv");
        for (String[] item: listLine) {
            Villa villa = new Villa(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Double.parseDouble(item[7]), Integer.parseInt(item[8]) );
            facilityIntegerMap.put(villa, Integer.parseInt(item[9]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/house.csv");
        for (String[] item: listLine) {
            House house = new House(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Integer.parseInt(item[7]));
            facilityIntegerMap.put(house, Integer.parseInt(item[8]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/room.csv");
        for (String[] item: listLine) {
            Room room = new Room(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6]);
            facilityIntegerMap.put(room, Integer.parseInt(item[7]));
        }
        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + item.getKey() + " Số lần đã thuê: " + item.getValue());
        }
    }

    @Override
    public void displayMaintain() {

    }

    @Override
    public void addNewVilla() {
        int id = Integer.parseInt(inputIdVilla());
        String name = inputName();
        double area = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputTotalPay());
        int people = Integer.parseInt(inputPeople());
        String renType = inputRenType();
        String standard = inputStandard();
        double areaPool = Double.parseDouble(inputAreaPool());
        int floor = Integer.parseInt(inputFloor());

        Villa villa = new Villa(id, name, area, price, people, renType, standard, areaPool, floor);
        String line = villa.getIdFacility() + "," + villa.getNameService() + "," + villa.getAreaUse() + "," + villa.getRentalPrice() + "," + villa.getRentalPeopleMax() + "," + villa.getStyleRental() + "," + villa.getStandardVilla() + "," + villa.getAreaPool() + "," + villa.getFloor();
        ReadAndWrite.writeFile("src/_case_study/data/villa.csv", line);
        System.out.println("Đã thêm mới villa thành công");
    }

    @Override
    public void addNewHouse() {
        int id = Integer.parseInt(inputIdHouse());
        String name = inputName();
        double area = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputTotalPay());
        int people = Integer.parseInt(inputPeople());
        String renType = inputRenType();
        String standard = inputStandard();
        int floor = Integer.parseInt(inputFloor());

        House house = new House(id, name, area, price, people, renType, standard, floor);
        String line = house.getIdFacility() + "," + house.getNameService() + "," + house.getAreaUse() + "," + house.getRentalPrice() + "," + house.getRentalPeopleMax() + "," + house.getStyleRental() + "," + house.getStandardHouse() + "," + house.getFloor();
        ReadAndWrite.writeFile("src/_case_study/data/house.csv", line);
        System.out.println("Đã thêm mới house thành công");
    }

    @Override
    public void addNewRoom() {
        int id = Integer.parseInt(inputIdRoom());
        String name = inputName();
        double area = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputTotalPay());
        int people = Integer.parseInt(inputPeople());
        String renType = inputRenType();
        System.out.println("Nhập Dịch vụ miễn phí");
        String freeService = scanner.nextLine();

        Room room = new Room(id, name, area, price, people, renType, freeService);
        String line = room.getIdFacility() + "," + room.getNameService() + "," + room.getAreaUse() + "," + room.getRentalPrice() + "," + room.getRentalPeopleMax() + "," + room.getStyleRental() + "," + room.getFreeService();
        ReadAndWrite.writeFile("src/_case_study/data/room.csv", line);
        System.out.println("Đã thêm mới room thành công");
    }

    private String inputIdVilla() {
        System.out.println("Nhập id");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_VILLA, "Bạn đã nhập sai định dạng, mã định dạng phải có dạng là SVVL-XXXX");
    }

    private String inputIdHouse() {
        System.out.println("Nhập id");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_HOUSE, "Bạn đã nhập sai định dạng, mã định dạng phải có dạng là SVHO-XXXX");
    }

    private String inputIdRoom() {
        System.out.println("Nhập id");
        return RegexData.regexStr(scanner.nextLine(), REGEX_ID_ROOM, "Bạn đã nhập sai định dạng, mã định dạng phải có dạng là SVRO-XXXX");
    }

    private String inputName() {
        System.out.println("Nhập tên dịch vụ");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, tên dịch vụ phải viết hoa chữ cái đầu");
    }

    private String inputArea() {
        System.out.println("Nhập diện tích sử dụng");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA, "Bạn đã nhập sai định dạng, diện tích sử dụng phải lớn hơn 30");
    }

    private String inputTotalPay() {
        System.out.println("Nhập giá tiền");
        return RegexData.regexStr(scanner.nextLine(), REGEX_INT, "Bạn đã nhập sai định dạng, giá tiền phải là số dương");
    }

    private String inputPeople() {
        System.out.println("Nhập số lượng người");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AMOUNT, "Bạn đã nhập sai định dạng, số lượng người tối đa phải >0 và nhỏ hơn <20");
    }

    private String inputRenType() {
        System.out.println("Nhập kiểu thuê");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, kiểu thuê phải viết hoa chữ cái đầu");
    }

    private String inputStandard() {
        System.out.println("Nhập tiêu chuẩn");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "Bạn đã nhập sai định dạng, tiêu chuẩn phải viết hoa chữ cái đầu");
    }

    private String inputAreaPool() {
        System.out.println("Nhập diện tích hồ bơi");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA, "Bạn đã nhập sai định dạng, diện tích hồ bơi phải lớn hơn 30");
    }

    private String inputFloor() {
        System.out.println("Nhập số tầng");
        return RegexData.regexStr(scanner.nextLine(), REGEX_INT, "Bạn đã nhập sai định dạng, số tầng phải là số nguyên dương");
    }
}
