package _case_study.services.impl;

import _case_study.models.booking.Booking;
import _case_study.models.facility.Facility;
import _case_study.models.facility.House;
import _case_study.models.facility.Room;
import _case_study.models.facility.Villa;
import _case_study.models.person.Customer;
import _case_study.services.PromotionService;
import _case_study.utils.BookingComparator;
import _case_study.utils.ReadAndWrite;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static Stack<Booking> stackBooking = new Stack<>();

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayCustomerService() {
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

        System.out.println("danh s??ch kh??ch h??ng s??? t???ng voucher");
        for (Booking item : bookingSet) {
            System.out.println(stackBooking.push(item));
        }
    }

    @Override
    public void displayCustomerVoucher() {
        displayCustomerService();
        System.out.println("Nh???p s??? l?????ng voucher khuy???n m??i 10%: ");
        int inputVoucher10 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nh???p s??? l?????ng voucher khuy???n m??i 20%: ");
        int inputVoucher20 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nh???p s??? l?????ng voucher khuy???n m??i 50%: ");
        int inputVoucher50 = Integer.parseInt(scanner.nextLine());

        try {
            for (int i = 0; i < inputVoucher10; i++) {
                System.out.println(stackBooking.pop() + " nh???n ???????c voucher khuy???n m??i 10%");
            }
            for (int i = 0; i < inputVoucher20; i++) {
                System.out.println(stackBooking.pop() + " nh???n ???????c voucher khuy???n m??i 20%");
            }
            for (int i = 0; i < inputVoucher50; i++) {
                System.out.println(stackBooking.pop() + " nh???n ???????c voucher khuy???n m??i 50%");
            }
        } catch (EmptyStackException e) {
            System.out.println("???? h???t kh??ch h??ng nh???n");
        }
    }
}
