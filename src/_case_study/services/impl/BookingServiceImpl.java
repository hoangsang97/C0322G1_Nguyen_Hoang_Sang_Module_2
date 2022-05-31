package _case_study.services.impl;

import _case_study.models.booking.Booking;
import _case_study.models.facility.House;
import _case_study.models.facility.Room;
import _case_study.models.person.Customer;
import _case_study.models.facility.Facility;
import _case_study.models.facility.Villa;
import _case_study.services.BookingService;
import _case_study.utils.BookingComparator;
import _case_study.utils.ReadAndWrite;
import ss05_access_modifier_static_method_static_property.test.Demo;

import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    static List<String[]> listLine = new ArrayList<>();

    public Set<Booking> sendBooking() {
        return bookingSet;
    }

    @Override
    public void addBooking() {

        int id = 1;
        if (!bookingSet.isEmpty()) {
            id = bookingSet.size();
        }
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();


        boolean check = false;
        do {
            try {
                System.out.println("Nhập ngày bắt đầu thuê: ");
                String starDate = scanner.nextLine();
                System.out.println("Nhập ngày trả phòng: ");
                String endDate = scanner.nextLine();

                Booking booking = new Booking(id, starDate, endDate, customer, facility);
                bookingSet.add(booking);
                String line = booking.getIdBooking() + "," + booking.getStarDate() + "," + booking.getEndDate() + "," + booking.getCustomer().getId() + "," + booking.getFacility().getIdFacility();
                ReadAndWrite.writeFile("src/_case_study/data/booking.csv", line);
                System.out.println("Đã tạo booking thành công");
                check = false;
            } catch (DateTimeParseException e) {
                System.out.println("Nhập sai định dạng ngày tháng năm, xin vui lòng nhập lại");
                check = true;
            }
        } while (check);
    }

    @Override
    public void displayListBooking() {
        List<String[]> listLine = ReadAndWrite.readFile("src/_case_study/data/booking.csv");
        List<String[]> listCustomer = ReadAndWrite.readFile("src/_case_study/data/customer.csv");
        List<String[]> listFacility = ReadAndWrite.readFile("src/_case_study/data/villa.csv");

        for (String[] item : listLine) {
            Customer customer = null;
            Villa villa = null;
            for (String[] itemCustomer: listCustomer) {
                if (itemCustomer[0].equals(item[3])) {
                    customer = new Customer(Integer.parseInt(itemCustomer[0]), itemCustomer[1], Integer.parseInt(itemCustomer[2]), itemCustomer[3], itemCustomer[4], itemCustomer[5], itemCustomer[6], itemCustomer[7]);
                }
            }
            for (String[] itemFacility: listFacility) {
                if (itemFacility[0].equals(item[4])) {
                    villa = new Villa(Integer.parseInt(itemFacility[0]), itemFacility[1], Double.parseDouble(itemFacility[2]), Integer.parseInt(itemFacility[3]), Integer.parseInt(itemFacility[4]), itemFacility[5], itemFacility[6], Double.parseDouble(itemFacility[7]), Integer.parseInt(itemFacility[8]));
                }
            }
            Booking booking = new Booking(Integer.parseInt(item[0]), item[1], item[2], customer, villa);
            bookingSet.add(booking);
        }

        for (Booking item : bookingSet) {
            System.out.println(item);
        }
    }

    public static Customer chooseCustomer() {
        System.out.println("Danh sách khách hàng: ");
        listLine = ReadAndWrite.readFile("src/_case_study/data/customer.csv");
        customerList.clear();
        for (String[] item : listLine) {
            Customer customer = new Customer(Integer.parseInt(item[0]), item[1], Integer.parseInt(item[2]), item[3], item[4], item[5], item[6], item[7]);
            customerList.add(customer);
        }

        for (Customer item : customerList) {
            System.out.println(item);
        }

        System.out.println("Nhập id khách hàng: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = true;

        while (true) {
            for (Customer item : customerList) {
                if (id == item.getId()) {
                    return item;
                }
            }

            if (check) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại id khách hàng: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
    }

    public static Facility chooseFacility() {
        System.out.println("Danh sách dịch vụ: ");
        facilityMap.clear();
        listLine = ReadAndWrite.readFile("src/_case_study/data/villa.csv");
        for (String[] item : listLine) {
            Villa villa = new Villa(Integer.parseInt(item[0]), item[1],
                    Double.parseDouble(item[2]),
                    Integer.parseInt(item[3]),
                    Integer.parseInt(item[4]), item[5], item[6],
                    Double.parseDouble(item[7]),
                    Integer.parseInt(item[8]));
            facilityMap.put(villa, Integer.parseInt(item[9]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/house.csv");
        for (String[] item : listLine) {
            House house = new House(Integer.parseInt(item[0]), item[1],
                    Double.parseDouble(item[2]),
                    Integer.parseInt(item[3]),
                    Integer.parseInt(item[4]), item[5], item[6],
                    Integer.parseInt(item[7]));
            facilityMap.put(house, Integer.parseInt(item[8]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/room.csv");
        for (String[] item : listLine) {
            Room room = new Room(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6]);
            facilityMap.put(room, Integer.parseInt(item[7]));
        }

        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println("Nhập id dịch vụ: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = true;
        Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
        while (true) {
            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                if (id == entry.getKey().getIdFacility()) {
                    int count = facilityMap.get(entry.getKey());
                    facilityMap.put(entry.getKey(), count + 1);
                    String lines = "";

                    for (Map.Entry<Facility, Integer> entryVilla : facilityMap.entrySet()) {
                        if (entryVilla.getKey() instanceof Villa) {
                            villaIntegerMap.put((Villa) entryVilla.getKey(), entryVilla.getValue());
                            for (Map.Entry<Villa, Integer> entryVillas : villaIntegerMap.entrySet()) {
                                String line = entryVillas.getKey().getIdFacility() + "," + entryVillas.getKey().getNameService() + "," + entryVillas.getKey().getAreaUse() + "," + entryVillas.getKey().getRentalPrice() + "," + entryVillas.getKey().getRentalPeopleMax() + "," + entryVillas.getKey().getStyleRental() + "," + entryVillas.getKey().getStandardVilla() + "," + entryVillas.getKey().getAreaPool() + "," + entryVillas.getKey().getFloor() + "," + entryVillas.getValue();
                                lines += line;
                            }
                        }
                    }

                    ReadAndWrite.writeFile("src/_case_study/data/villa.csv", lines);
                    return entry.getKey();
                }
            }

            if (check) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại id dịch vụ: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
    }
}
