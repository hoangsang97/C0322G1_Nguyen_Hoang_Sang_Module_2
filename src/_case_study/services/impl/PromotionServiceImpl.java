package _case_study.services.impl;

import _case_study.models.booking.Booking;
import _case_study.models.facility.Villa;
import _case_study.models.person.Customer;
import _case_study.services.PromotionService;
import _case_study.utils.BookingComparator;
import _case_study.utils.ReadAndWrite;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    static Set<Booking> bookingSet = new TreeSet<>(new BookingComparator());

    static Stack<Integer> stack = new Stack<>();

    static Stack<Booking> stackBooking = new Stack<>();

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void displayCustomerService() {
        List<String[]> listLine = ReadAndWrite.readFile("src/_case_study/data/booking.csv");
        List<String[]> listCustomer = ReadAndWrite.readFile("src/_case_study/data/customer.csv");
        List<String[]> listFacility = ReadAndWrite.readFile("src/_case_study/data/villa.csv");

        for (String[] item : listLine) {
            Customer customer = null;
            Villa villa = null;
            for (String[] itemCustomer : listCustomer) {
                if (itemCustomer[0].equals(item[3])) {
                    customer = new Customer(Integer.parseInt(itemCustomer[0]), itemCustomer[1], Integer.parseInt(itemCustomer[2]), itemCustomer[3], itemCustomer[4], itemCustomer[5], itemCustomer[6], itemCustomer[7]);
                }
            }
            for (String[] itemFacility : listFacility) {
                if (itemFacility[0].equals(item[4])) {
                    villa = new Villa(Integer.parseInt(itemFacility[0]), itemFacility[1], Double.parseDouble(itemFacility[2]), Integer.parseInt(itemFacility[3]), Integer.parseInt(itemFacility[4]), itemFacility[5], itemFacility[6], Double.parseDouble(itemFacility[7]), Integer.parseInt(itemFacility[8]));
                }
            }
            Booking booking = new Booking(Integer.parseInt(item[0]), item[1], item[2], customer, villa);
            bookingSet.add(booking);
        }

        for (Booking item : bookingSet) {
            stackBooking.push(item);
        }

        System.out.println("danh sách khách hàng sẽ tặng voucher");
        for (Booking item: stackBooking) {
            System.out.println(item + " voucher " + stack.pop());
        }

        System.out.println("số lượng voucher còn lại");
        for (Integer item: stack) {
            System.out.println(item);
        }
    }

    @Override
    public void displayCustomerVoucher() {
        System.out.println("Nhập số lượng voucher khuyến mãi 10%: ");
        int inputVoucher10 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng voucher khuyến mãi 20%: ");
        int inputVoucher20 = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng voucher khuyến mãi 50%: ");
        int inputVoucher50 = Integer.parseInt(scanner.nextLine());

        //

        //

        //

        stack.push(inputVoucher10);
        stack.push(inputVoucher20);
        stack.push(inputVoucher50);

        System.out.println("số lượng voucher khuyến mãi 10%: " + stack.get(0) + " cái");
        System.out.println("số lượng voucher khuyến mãi 20%: " + stack.get(1) + " cái");
        System.out.println("số lượng voucher khuyến mãi 50%: " + stack.get(2) + " cái");
    }
}
