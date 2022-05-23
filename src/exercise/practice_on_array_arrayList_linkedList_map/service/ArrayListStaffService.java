package exercise.practice_on_array_arrayList_linkedList_map.service;

import exercise.practice_on_array_arrayList_linkedList_map.model.DailyWorker;
import exercise.practice_on_array_arrayList_linkedList_map.model.ManagementStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.ProductionStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.Staff;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStaffService implements IStaffService {
    public static List<Staff> staffArrayList = new ArrayList<>();

    static {
        staffArrayList.add(new ManagementStaff("tran van a", 2000, "DN", 1000, 1.4));
        staffArrayList.add(new ProductionStaff("tran van b", 1992, "DN", 24));
        staffArrayList.add(new DailyWorker("tran van c", 1991, "DN", 2000));
    }


    @Override
    public void displayArrayStaff() {
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i) != null) {
                System.out.println(staffArrayList.get(i));
            }
        }
    }

    @Override
    public void displayManagementStaff() {
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i) != null && staffArrayList.get(i) instanceof ManagementStaff) {
                System.out.println(staffArrayList.get(i));
            }
        }
    }

    @Override
    public void displayDailyWorkerStaff() {
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i) != null && staffArrayList.get(i) instanceof ProductionStaff) {
                System.out.println(staffArrayList.get(i));
            }
        }
    }

    @Override
    public void displayProductionStaff() {
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i) != null && staffArrayList.get(i) instanceof DailyWorker) {
                System.out.println(staffArrayList.get(i));
            }
        }
    }

    @Override
    public void displayEmployeeSalaryStaff() {
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i) != null) {
                System.out.println(staffArrayList.get(i).employeeSalary());
            }
        }
    }

    /**
     * chỉ cần tạo ra interface có phương thức là hiển thị. rồi viết lại phương thức abstract của lớp cha;
     * vì phương thức lớp con kế thừa của lớp cha;
     *
     * Không nên dùng vòng lặp truyền thống (for i = 0 -> size() – 1 => get(i)) để duyệt qua từng phần tử có trong LinkedList.
     * vì fori duyệt mảng từ đầu tới cuối mảng. tốc độ sẽ chậm.
     *
     * Giả sử công ty ABC thay đổi nhân sự liên tục (xóa và thêm nhân viên) thì nên sử dụng LinkedList.
     * vì dùng linked tốc độ xử lí sẽ nhanh hơn arraylist
     *
     * Ưu và nhược điểm của ArrayList và LinkedList.
     * arrayList: + cấu trúc dạng mảng động
     * + truy xuất phần tử nhanh hơn.
     * + chèn, xoá: chậm hơn
     * + sử dụng lưu trữ cho danh sách ít thay đổi, thường xuyên tìm kiếm.
     *
     * LinkedList: + cấu trúc dạng liên kết đôi
     *   + truy xuất phần tử chậm hơn
     *   + chèn, xoá: nhanh hơn
     *   + sử dụng lưu trữ cho danh sách thường xuyên thay đổi phần tử.
     */
}
