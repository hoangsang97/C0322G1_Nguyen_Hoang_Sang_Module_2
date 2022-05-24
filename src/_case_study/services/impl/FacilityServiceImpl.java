package _case_study.services.impl;

import _case_study.models.facility.Facility;
import _case_study.models.facility.Villa;
import _case_study.services.FacilityService;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    private static Map<Integer, Facility> facilityIntegerMap = new LinkedHashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void display() {
        for (Map.Entry<Integer, Facility> item: facilityIntegerMap.entrySet()) {
            System.out.println("Service " + item.getValue() + " Số lần đã thuê: " + item.getKey());
        }
    }

    @Override
    public void displayMaintain() {

    }
    @Override
    public void addNewVilla() {
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập diện tích");
        double area = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập giá tiền");
        int price = Integer.parseInt(scanner.nextLine());
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

    @Override
    public void addNewHouse() {

    }

    @Override
    public void addNewRoom() {

    }
}
