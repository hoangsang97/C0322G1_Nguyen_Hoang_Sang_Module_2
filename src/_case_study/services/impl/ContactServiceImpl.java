package _case_study.services.impl;

import _case_study.controllers.FuramaController;
import _case_study.models.booking.Booking;
import _case_study.models.booking.Contract;
import _case_study.models.person.Customer;
import _case_study.services.ContactService;

import java.util.*;

public class ContactServiceImpl implements ContactService {
    static List<Contract> contractList = new ArrayList<>();
    static Queue<Booking> bookingQueue = new LinkedList<>();
    static Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void createNewContract() {
        for (Booking item : bookingSet) {
            bookingQueue.add(item);
        }

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
            System.out.println("Đã tạo thành công hợp đồng: " + contract);
        }
    }

    @Override
    public void displayListContract() {
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
