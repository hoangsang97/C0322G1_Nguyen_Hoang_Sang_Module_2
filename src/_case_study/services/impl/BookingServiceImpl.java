package _case_study.services.impl;

import _case_study.models.booking.Booking;
import _case_study.models.person.Customer;
import _case_study.models.facility.Facility;
import _case_study.models.facility.Villa;
import _case_study.services.BookingService;
import _case_study.utils.BookingComparator;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static Scanner scanner = new Scanner(System.in);
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Integer, Facility> facilityMap = new LinkedHashMap<>();

    static {
        customerList.add(new Customer(1, "tran van a", 18, "Male", "12432121", "sangnguyen@gamil.com", "Vip", "DN"));
        customerList.add(new Customer(2, "tran van b", 10, "FeMale", "13342432121", "sang@gamil.com", "NORMAL", "QN"));
        facilityMap.put(0, new Villa(1, "Villa 1", 200, 150, 10, "Day", "Vip", 15, 2));
        facilityMap.put(1, new Villa(2, "Villa 2", 300, 250, 9, "Day", "NORMAL", 10, 3));
    }

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
        System.out.println("Nhập ngày bắt đầu thuê: ");
        String starDate = scanner.nextLine();
        System.out.println("Nhập ngày trả phòng: ");
        String endDate = scanner.nextLine();
        Booking booking = new Booking(id, starDate, endDate, customer, facility);

        bookingSet.add(booking);
        System.out.println("Đã tạo booking thành công");
    }

    @Override
    public void displayListBooking() {
        for (Booking item: bookingSet) {
            System.out.println(item);
        }
    }

    public static Customer chooseCustomer() {
        System.out.println("Danh sách khách hàng: ");
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
        for (Map.Entry<Integer, Facility> entry : facilityMap.entrySet()) {
            System.out.println(entry.getValue());
        }

        System.out.println("Nhập id dịch vụ: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = true;

        while (check) {
            for (Map.Entry<Integer, Facility> entry : facilityMap.entrySet()) {
                if (id == entry.getValue().getIdFacility()) {
                    check = false;
                    return entry.getValue();
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
