package exercise.practice_on_array_arrayList_linkedList_map.service;

import exercise.practice_on_array_arrayList_linkedList_map.model.DailyWorker;
import exercise.practice_on_array_arrayList_linkedList_map.model.ManagementStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.ProductionStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.Staff;

import java.util.LinkedList;
import java.util.List;

public class LinkedListStaffService implements IStaffService{
    public static List<Staff> staffLinkedList = new LinkedList<>();

    static {
        staffLinkedList.add(new ManagementStaff("tran van a", 2000, "DN", 1000, 1.4));
        staffLinkedList.add(new ProductionStaff("tran van b", 1992, "DN", 24));
        staffLinkedList.add(new DailyWorker("tran van c", 1991, "DN", 2000));
    }

    @Override
    public void displayArrayStaff() {
        for (int i = 0; i < staffLinkedList.size(); i++) {
            if (staffLinkedList.get(i) != null) {
                System.out.println(staffLinkedList.get(i));
            }
        }
    }

    @Override
    public void displayManagementStaff() {
        for (int i = 0; i < staffLinkedList.size(); i++) {
            if (staffLinkedList.get(i) != null && staffLinkedList.get(i) instanceof ManagementStaff) {
                System.out.println(staffLinkedList.get(i));
            }
        }
    }

    @Override
    public void displayDailyWorkerStaff() {
        for (int i = 0; i < staffLinkedList.size(); i++) {
            if (staffLinkedList.get(i) != null && staffLinkedList.get(i) instanceof ProductionStaff) {
                System.out.println(staffLinkedList.get(i));
            }
        }
    }

    @Override
    public void displayProductionStaff() {
        for (int i = 0; i < staffLinkedList.size(); i++) {
            if (staffLinkedList.get(i) != null && staffLinkedList.get(i) instanceof DailyWorker) {
                System.out.println(staffLinkedList.get(i));
            }
        }
    }

    @Override
    public void displayEmployeeSalaryStaff() {

    }

    /**
     *  thay đổi nhân sự liên tục (xóa và thêm nhân viên) thì nên sử dụng LinkedList
     *  khi xoá hoặc thêm phần tử linked chỉ cần thay đổi đường liên kết giữa các node.
     *  ưu và nhược giữa arraylist và linked:
     *  arraylist: + cấu trúc dạng mảng rộng;
     *  + truy xuất phần tử nhanh hơn;
     *  + chèn xoá phần tử chậm hơn linked list;
     *  + thường sử dụng cho danh sách it thay đổi, thường xuyên tìm kiếm;
     *  linked list:
     *  + danh sách liên kết đôi;
     *  + truy xuất phần tử chậm hơn;
     *  + thêm, xoá phần tử nhanh hơn;
     *  + sử dụng lưu trữ danh sách thường xuyên thay đổi phần tử
     */
}
