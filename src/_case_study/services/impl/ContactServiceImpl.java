package _case_study.services.impl;

import _case_study.models.booking.Booking;
import _case_study.models.booking.Contract;
import _case_study.models.person.Customer;
import _case_study.services.ContactService;

import java.util.*;

public class ContactServiceImpl implements ContactService {
    static List<Contract> contractList = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    @Override
    public void createNewContract() {
        Queue<Booking> bookingQueue = new LinkedList<>();
        Set<Booking> bookingSet = new BookingServiceImpl().sendBooking();
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
//       for (Contract item: contractList) {
//           if
//       }
//
//        while (!bookingQueue.isEmpty()) {
//            Booking booking = bookingQueue.poll();
//            Customer customer = booking.getCustomer();
//
//            System.out.println("Đang sửa hợp đồng cho Booking có thông tin " + booking);
//            System.out.println("Đang sửa hợp đồng cho khách hàng có thông tin " + customer);
//            Contract contract = new Contract();
//            System.out.println("Nhập id hợp đồng muốn chỉnh sửa: ");
//            int inputIdContact = Integer.parseInt(scanner.nextLine());
//            if(contract.getIdContract() == inputIdContact) {
//                System.out.println("Nhập số tiền trả trước: ");
//                String pre = scanner.nextLine();
//                System.out.println("Nhập số chi phí: ");
//                String pay = scanner.nextLine();
//
//                contract.s
//            }
//
//            System.out.println("Đã tạo thành công hợp đồng: " + contract);
//        }
     }
}
