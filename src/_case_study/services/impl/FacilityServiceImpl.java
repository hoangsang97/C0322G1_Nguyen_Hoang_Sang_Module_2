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
            Villa villa = new Villa(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Double.parseDouble(item[7]), Integer.parseInt(item[8]));
            facilityIntegerMap.put(villa, Integer.parseInt(item[9]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/house.csv");
        for (String[] item: listLine) {
            House house = new House(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Integer.parseInt(item[7]));
            facilityIntegerMap.put(house, Integer.parseInt(item[8]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/room.csv");
        for (String[] item: listLine) {
            Room room = new Room(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6]);
            facilityIntegerMap.put(room, Integer.parseInt(item[7]));
        }
        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            System.out.println("Service " + item.getKey() + " S??? l???n ???? thu??: " + item.getValue());
        }
    }

    @Override
    public void displayMaintain() {
        facilityIntegerMap.clear();
        listLine = ReadAndWrite.readFile("src/_case_study/data/villa.csv");
        for (String[] item: listLine) {
            Villa villa = new Villa(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Double.parseDouble(item[7]), Integer.parseInt(item[8]));
            facilityIntegerMap.put(villa, Integer.parseInt(item[9]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/house.csv");
        for (String[] item: listLine) {
            House house = new House(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Integer.parseInt(item[7]));
            facilityIntegerMap.put(house, Integer.parseInt(item[8]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/room.csv");
        for (String[] item: listLine) {
            Room room = new Room(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6]);
            facilityIntegerMap.put(room, Integer.parseInt(item[7]));
        }
        for (Map.Entry<Facility, Integer> item : facilityIntegerMap.entrySet()) {
            if (item.getValue() >= 5) {
                System.out.println(item.getKey() + " S??? l???n ???? thu??: " + item.getValue() + " ??ang b???o tr?? h??? th???ng");
            }
        }
    }

    @Override
    public void addNewVilla() {
        String id = inputIdVilla();
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
        System.out.println("???? th??m m???i villa th??nh c??ng");
    }

    @Override
    public void addNewHouse() {
        String id = inputIdHouse();
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
        System.out.println("???? th??m m???i house th??nh c??ng");
    }

    @Override
    public void addNewRoom() {
        String id = inputIdRoom();
        String name = inputName();
        double area = Double.parseDouble(inputArea());
        int price = Integer.parseInt(inputTotalPay());
        int people = Integer.parseInt(inputPeople());
        String renType = inputRenType();
        System.out.println("Nh???p D???ch v??? mi???n ph??");
        String freeService = scanner.nextLine();

        Room room = new Room(id, name, area, price, people, renType, freeService);
        String line = room.getIdFacility() + "," + room.getNameService() + "," + room.getAreaUse() + "," + room.getRentalPrice() + "," + room.getRentalPeopleMax() + "," + room.getStyleRental() + "," + room.getFreeService();
        ReadAndWrite.writeFile("src/_case_study/data/room.csv", line);
        System.out.println("???? th??m m???i room th??nh c??ng");
    }

    private String inputIdVilla() {
        System.out.println("Nh???p id");
        return RegexData.regexIdVilla(REGEX_ID_VILLA);
    }

    private String inputIdHouse() {
        System.out.println("Nh???p id");
        return RegexData.regexIdHouse(REGEX_ID_HOUSE);
    }

    private String inputIdRoom() {
        System.out.println("Nh???p id");
        return RegexData.regexIdRoom(REGEX_ID_ROOM);
    }

    private String inputName() {
        System.out.println("Nh???p t??n d???ch v???");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "B???n ???? nh???p sai ?????nh d???ng, t??n d???ch v??? ph???i vi???t hoa ch??? c??i ?????u");
    }

    private String inputArea() {
        System.out.println("Nh???p di???n t??ch s??? d???ng");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA, "B???n ???? nh???p sai ?????nh d???ng, di???n t??ch s??? d???ng ph???i l???n h??n 30");
    }

    private String inputTotalPay() {
        System.out.println("Nh???p gi?? ti???n");
        return RegexData.regexStr(scanner.nextLine(), REGEX_INT, "B???n ???? nh???p sai ?????nh d???ng, gi?? ti???n ph???i l?? s??? d????ng");
    }

    private String inputPeople() {
        System.out.println("Nh???p s??? l?????ng ng?????i");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AMOUNT, "B???n ???? nh???p sai ?????nh d???ng, s??? l?????ng ng?????i t???i ??a ph???i >0 v?? nh??? h??n <20");
    }

    private String inputRenType() {
        System.out.println("Nh???p ki???u thu??");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "B???n ???? nh???p sai ?????nh d???ng, ki???u thu?? ph???i vi???t hoa ch??? c??i ?????u");
    }

    private String inputStandard() {
        System.out.println("Nh???p ti??u chu???n");
        return RegexData.regexStr(scanner.nextLine(), REGEX_STR, "B???n ???? nh???p sai ?????nh d???ng, ti??u chu???n ph???i vi???t hoa ch??? c??i ?????u");
    }

    private String inputAreaPool() {
        System.out.println("Nh???p di???n t??ch h??? b??i");
        return RegexData.regexStr(scanner.nextLine(), REGEX_AREA, "B???n ???? nh???p sai ?????nh d???ng, di???n t??ch h??? b??i ph???i l???n h??n 30");
    }

    private String inputFloor() {
        System.out.println("Nh???p s??? t???ng");
        return RegexData.regexStr(scanner.nextLine(), REGEX_INT, "B???n ???? nh???p sai ?????nh d???ng, s??? t???ng ph???i l?? s??? nguy??n d????ng");
    }
}