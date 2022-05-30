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
                System.out.println("Đã tạo booking thành công");
                for (Map.Entry<Facility, Integer> entry : FacilityServiceImpl.facilityIntegerMap.entrySet()) {

                }
                check = false;
            } catch (DateTimeParseException e) {
                System.out.println("Nhập sai định dạng ngày tháng năm, xin vui lòng nhập lại");
                check = true;
            }
        } while (check);
    }

    @Override
    public void displayListBooking() {
        for (Booking item: bookingSet) {
            System.out.println(item);
        }
    }

    public static Customer chooseCustomer() {
        System.out.println("Danh sách khách hàng: ");
        listLine = ReadAndWrite.readFile("src/_case_study/data/customer.csv");
        customerList.clear();
        for (String[] item: listLine) {
            Customer customer = new Customer(Integer.parseInt(item[0]), item[1], Integer.parseInt(item[2]), item[3], item[4], item[5], item[6], item[7]);
            customerList.add(customer);
        }

        for (Customer item : customerList) {
            System.out.println(item);
        }

        System.out.println("Nhập id khách hàng: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = true;

        while (check) {
            for (Customer item : customerList) {
                if (id == item.getId()) {
                    check = false;
                    return item;
                }
            }

            if (check) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại id khách hàng: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }

    public static Facility chooseFacility() {
        System.out.println("Danh sách dịch vụ: ");
        facilityMap.clear();
        listLine = ReadAndWrite.readFile("src/_case_study/data/villa.csv");
        for (String[] item: listLine) {
            Villa villa = new Villa(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Double.parseDouble(item[7]), Integer.parseInt(item[8]));
            facilityMap.put(villa, 0);
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/house.csv");
        for (String[] item: listLine) {
            House house = new House(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Integer.parseInt(item[7]));
            facilityMap.put(house, 0);
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/room.csv");
        for (String[] item: listLine) {
            Room room = new Room(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6]);
            facilityMap.put(room, 0);
        }
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println("Nhập id dịch vụ: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = true;

        while (check) {
            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                if (id == entry.getKey().getIdFacility()) {
                    check = false;
                    return entry.getKey();
                }
            }

            if (check) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại id dịch vụ: ");
                id = Integer.parseInt(scanner.nextLine());
            }
        }
        return null;
    }
}
