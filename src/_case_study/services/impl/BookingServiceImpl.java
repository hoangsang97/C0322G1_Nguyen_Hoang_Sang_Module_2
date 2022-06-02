package _case_study.services.impl;

import _case_study.models.booking.Booking;
import _case_study.models.facility.House;
import _case_study.models.facility.Room;
import _case_study.models.person.Customer;
import _case_study.models.facility.Facility;
import _case_study.models.facility.Villa;
import _case_study.models.person.Employee;
import _case_study.services.BookingService;
import _case_study.utils.BookingComparator;
import _case_study.utils.ReadAndWrite;

import java.time.format.DateTimeParseException;
import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner scanner = new Scanner(System.in);

    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityMap = new TreeMap<>();

    static List<String[]> listLine = new ArrayList<>();

    static List<String> stringList = new ArrayList<>();


    public Set<Booking> sendBooking() {
        listLine = ReadAndWrite.readFile("src/_case_study/data/customer.csv");
        customerList.clear();
        Customer customer = null;
        for (String[] item : listLine) {
            customer = new Customer(Integer.parseInt(item[0]), item[1], item[2], item[3], item[4], item[5], item[6], item[7]);
            customerList.add(customer);
        }

        listLine = ReadAndWrite.readFile("src/_case_study/data/villa.csv");
        facilityMap.clear();
        Facility facility = null;
        for (String[] item : listLine) {
            facility = new Villa(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Double.parseDouble(item[7]), Integer.parseInt(item[8]));
            facilityMap.put(facility, Integer.parseInt(item[9]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/house.csv");
        for (String[] item : listLine) {
            facility = new House(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Integer.parseInt(item[7]));
            facilityMap.put(facility, Integer.parseInt(item[8]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/room.csv");
        for (String[] item : listLine) {
            facility = new Room(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6]);
            facilityMap.put(facility, Integer.parseInt(item[7]));
        }

        List<String[]> listBooking = ReadAndWrite.readFile("src/_case_study/data/booking.csv");
        for (String[] item: listBooking) {
            bookingSet.add(new Booking(Integer.parseInt(item[0]), item[1], item[2], customer, facility));
        }
        return bookingSet;
    }

    @Override
    public void addBooking() {
        Customer customer = chooseCustomer();
        Facility facility = chooseFacility();

        boolean check = false;
        do {
            try {
                List<String[]> listBooking = ReadAndWrite.readFile("src/_case_study/data/booking.csv");
                String line = "";
                stringList.clear();
                bookingSet.clear();
                for (String[] item : listBooking) {
                    bookingSet.add(new Booking(Integer.parseInt(item[0]), item[1], item[2], customer, facility));
                }
                System.out.println("Nhập ngày bắt đầu thuê: ");
                String starDate = scanner.nextLine();
                System.out.println("Nhập ngày trả phòng: ");
                String endDate = scanner.nextLine();
                int id = bookingSet.size() + 1;
                Booking booking = new Booking(id, starDate, endDate, customer, facility);
                bookingSet.add(booking);
                System.out.println("Đã tạo booking thành công");

                for (Booking item : bookingSet) {
                    line = item.getIdBooking() + "," + item.getStarDate() + "," + item.getEndDate() + "," + item.getCustomer().getId() + "," + item.getFacility().getIdFacility();
                    stringList.add(line);
                }

                String str = "";
                for (String item : stringList) {
                    str += item + "\n";
                }
                ReadAndWrite.writeFile("src/_case_study/data/booking.csv", str);

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
        List<String[]> listVilla = ReadAndWrite.readFile("src/_case_study/data/villa.csv");
        List<String[]> listHouse = ReadAndWrite.readFile("src/_case_study/data/house.csv");
        List<String[]> listRoom = ReadAndWrite.readFile("src/_case_study/data/room.csv");

        bookingSet.clear();
        for (String[] item : listLine) {
            Customer customer = null;
            Facility facility = null;
            Booking booking = null;

            for (String[] itemCustomer : listCustomer) {
                if (itemCustomer[0].equals(item[3])) {
                    customer = new Customer(Integer.parseInt(itemCustomer[0]), itemCustomer[1], itemCustomer[2], itemCustomer[3], itemCustomer[4], itemCustomer[5], itemCustomer[6], itemCustomer[7]);
                }
            }

            for (String[] itemVilla : listVilla) {
                if (itemVilla[0].equals(item[4])) {
                    facility = new Villa(itemVilla[0], itemVilla[1], Double.parseDouble(itemVilla[2]), Integer.parseInt(itemVilla[3]), Integer.parseInt(itemVilla[4]), itemVilla[5], itemVilla[6], Double.parseDouble(itemVilla[7]), Integer.parseInt(itemVilla[8]));
                }
            }

            for (String[] itemHouse : listHouse) {
                if (itemHouse[0].equals(item[4])) {
                    facility = new House(itemHouse[0], itemHouse[1], Double.parseDouble(itemHouse[2]), Integer.parseInt(itemHouse[3]), Integer.parseInt(itemHouse[4]), itemHouse[5], itemHouse[6], Integer.parseInt(itemHouse[7]));
                }
            }

            for (String[] itemRoom : listRoom) {
                if (itemRoom[0].equals(item[4])) {
                    facility = new Room(itemRoom[0], itemRoom[1], Double.parseDouble(itemRoom[2]), Integer.parseInt(itemRoom[3]), Integer.parseInt(itemRoom[4]), itemRoom[5], itemRoom[6]);
                }
            }

            booking = new Booking(Integer.parseInt(item[0]), item[1], item[2], customer, facility);
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
            Customer customer = new Customer(Integer.parseInt(item[0]), item[1], item[2], item[3], item[4], item[5], item[6], item[7]);
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
        listLine = ReadAndWrite.readFile("src/_case_study/data/villa.csv");
        facilityMap.clear();
        for (String[] item : listLine) {
            Villa villa = new Villa(item[0], item[1],
                    Double.parseDouble(item[2]),
                    Integer.parseInt(item[3]),
                    Integer.parseInt(item[4]), item[5], item[6],
                    Double.parseDouble(item[7]),
                    Integer.parseInt(item[8]));
            facilityMap.put(villa, Integer.parseInt(item[9]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/house.csv");
        for (String[] item : listLine) {
            House house = new House(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6], Integer.parseInt(item[7]));
            facilityMap.put(house, Integer.parseInt(item[8]));
        }
        listLine = ReadAndWrite.readFile("src/_case_study/data/room.csv");
        for (String[] item : listLine) {
            Room room = new Room(item[0], item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), Integer.parseInt(item[4]), item[5], item[6]);
            facilityMap.put(room, Integer.parseInt(item[7]));
        }

        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            System.out.println(entry.getKey());
        }

        System.out.println("Nhập id dịch vụ: ");
        String id = scanner.nextLine();
        boolean check = true;
        while (true) {
            for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
                if (id.equals(entry.getKey().getIdFacility())) {
                    int count = facilityMap.get(entry.getKey());
                    facilityMap.put(entry.getKey(), count + 1);

                    for (Map.Entry<Facility, Integer> entryFacility : facilityMap.entrySet()) {
                        if (entryFacility.getKey() instanceof Villa) {
                            Villa villa = (Villa) entryFacility.getKey();
                            stringList.add(entryFacility.getKey().getIdFacility() + "," + entryFacility.getKey().getNameService() + "," + entryFacility.getKey().getAreaUse() + "," + entryFacility.getKey().getRentalPrice() + "," + entryFacility.getKey().getRentalPeopleMax() + "," + entryFacility.getKey().getStyleRental() + "," + villa.getStandardVilla() + "," + villa.getAreaPool() + "," + villa.getFloor() + "," + entryFacility.getValue());
                        }
                    }

                    String str = "";
                    for (String item : stringList) {
                        str += item + "\n";
                    }
                    ReadAndWrite.writeFile("src/_case_study/data/villa.csv", str);

                    List<String> stringListHouse = new ArrayList<>();
                    for (Map.Entry<Facility, Integer> entryFacility : facilityMap.entrySet()) {
                        if (entryFacility.getKey() instanceof House) {
                            House house = (House) entryFacility.getKey();
                            stringListHouse.add(entryFacility.getKey().getIdFacility() + "," + entryFacility.getKey().getNameService() + "," + entryFacility.getKey().getAreaUse() + "," + entryFacility.getKey().getRentalPrice() + "," + entryFacility.getKey().getRentalPeopleMax() + "," + entryFacility.getKey().getStyleRental() + "," + house.getStandardHouse() + "," + house.getFloor() + "," + entryFacility.getValue());
                        }
                    }

                    String strHouse = "";
                    for (String item : stringListHouse) {
                        strHouse += item + "\n";
                    }
                    ReadAndWrite.writeFile("src/_case_study/data/house.csv", strHouse);

                    return entry.getKey();
                }
            }
            if (check) {
                System.out.println("Bạn đã nhập sai, vui lòng nhập lại id dịch vụ: ");
                id = scanner.nextLine();
            }
        }
    }
}
