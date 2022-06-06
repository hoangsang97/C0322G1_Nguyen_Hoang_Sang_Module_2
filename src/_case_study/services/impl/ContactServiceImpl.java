package _case_study.services.impl;

import _case_study.controllers.FuramaController;
import _case_study.models.booking.Booking;
import _case_study.models.booking.Contract;
import _case_study.models.facility.Facility;
import _case_study.models.facility.House;
import _case_study.models.facility.Room;
import _case_study.models.facility.Villa;
import _case_study.models.person.Customer;
import _case_study.services.ContactService;
import _case_study.utils.ReadAndWrite;

import java.util.*;

public class ContactServiceImpl implements ContactService {
    static List<Contract> contractList = new ArrayList<>();

    static Queue<Booking> bookingQueue = new LinkedList<>();

    static Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();

    static List<String[]> listLine = new ArrayList<>();

    static List<Customer> customerList = new ArrayList<>();

    static Map<Facility, Integer> facilityMap = new TreeMap<>();

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void createNewContract() {
        bookingQueue.addAll(bookingSet);

        String lineList = null;
        while (!bookingQueue.isEmpty()) {
            Booking booking = bookingQueue.poll();
            Customer customer = booking.getCustomer();

            System.out.println("Đang tạo hợp đồng cho Booking có thông tin " + booking);
            System.out.println("Đang tạo hợp đồng cho khách hàng có thông tin " + customer);
            System.out.println("Nhập id hợp đồng: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập số tiền trả trước: ");
            String pre = scanner.nextLine();
            System.out.println("Nhập số chi phí: ");
            String pay = scanner.nextLine();

            Contract contract = new Contract(id, booking, pre, pay, customer);
            contractList.add(contract);
            String line = contract.getIdContract() + "," + contract.getBooking().getIdBooking() + "," + contract.getPre() + "," + contract.getPay() + "," + contract.getCustomer().getId();
            System.out.println("Đã tạo thành công hợp đồng: " + contract);
            lineList += line + "\n";
        }

        ReadAndWrite.writeFile("src/_case_study/data/contract.csv", lineList);
    }

    @Override
    public void displayListContract() {
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
        Booking booking = null;
        for (String[] item: listBooking) {
            booking = new Booking(Integer.parseInt(item[0]), item[1], item[2], customer, facility);
            bookingSet.add(booking);
        }

        List<String[]> listContract = ReadAndWrite.readFile("src/_case_study/data/contract.csv");
        for (String[] item: listContract) {
            contractList.add(new Contract(Integer.parseInt(item[0]), booking , item[1], item[2], customer));
        }

        for (Contract item : contractList) {
            System.out.println(item);
        }
    }

    @Override
    public void editContract() {
        while (!contractList.isEmpty()) {
            System.out.println("Nhập id hợp đồng muốn chỉnh sửa: ");
            int inputIdContact = Integer.parseInt(scanner.nextLine());
            for (Contract item : contractList) {
                if (item.getIdContract() == inputIdContact) {
                    System.out.println("Nhập số tiền trả trước: ");
                    String pre = scanner.nextLine();
                    System.out.println("Nhập số chi phí: ");
                    String pay = scanner.nextLine();
                    item.setPre(pre);
                    item.setPay(pay);
                    System.out.println("Đã sửa thành công hợp đồng: " + item);
                    FuramaController.displayBookingManagement();
                }
            }
        }
    }
}
