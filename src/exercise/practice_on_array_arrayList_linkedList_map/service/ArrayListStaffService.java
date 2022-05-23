package exercise.practice_on_array_arrayList_linkedList_map.service;

import exercise.practice_on_array_arrayList_linkedList_map.model.DailyWorker;
import exercise.practice_on_array_arrayList_linkedList_map.model.ManagementStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.ProductionStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.Staff;
import exercise.practice_on_array_arrayList_linkedList_map.utils.StaffBirthComparator;
import exercise.practice_on_array_arrayList_linkedList_map.utils.StaffNameComparator;
import exercise.practice_on_array_arrayList_linkedList_map.utils.StaffNameDecreaseComparator;
import exercise.practice_on_array_arrayList_linkedList_map.utils.StaffSalaryComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListStaffService implements IStaffService {
    public static List<Staff> staffArrayList = new ArrayList<>();

    static {
        staffArrayList.add(new ManagementStaff("tran van c", 2000, "DN", 1000, 1.4));
        staffArrayList.add(new ManagementStaff("tran van b", 1999, "DN", 1000, 1.4));
        staffArrayList.add(new ManagementStaff("tran van a", 2001, "DN", 1000, 1.4));
        staffArrayList.add(new ProductionStaff("tran van a", 1992, "DN", 24));
        staffArrayList.add(new DailyWorker("tran van c", 1991, "DN", 2000));
    }


    @Override
    public void displayArrayStaff() {
        for (int i = 0; i < staffArrayList.size(); i++) {
            for (int j = i + 1; j < staffArrayList.size(); j++) {
                if (staffArrayList.get(i) != null && staffArrayList.get(i).employeeSalary() == staffArrayList.get(j).employeeSalary() ) {
                    Collections.sort(staffArrayList, new StaffNameDecreaseComparator());
                } else {
                    Collections.sort(staffArrayList, new StaffSalaryComparator());
                }
            }
        }

        for (Staff item : staffArrayList) {
            System.out.println(item);
        }
    }

    public void displayNameComparator() {
        Collections.sort(staffArrayList, new StaffNameComparator());
        for (int i = 0; i < staffArrayList.size(); i++) {
            if (staffArrayList.get(i) != null) {
                System.out.println(staffArrayList.get(i));
                System.out.println(staffArrayList.get(i).employeeSalary());
            }
        }
    }

    public void displaySaralyComparator() {
        Collections.sort(staffArrayList, new StaffSalaryComparator());
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
     * Nếu công ty có 1001 nhân viên thì sẽ không vấn đề gì
     * vì sao ArrayList không cần khởi tạo 1000 phần tử trước? :
     * mỗi lần thêm phần tử arraylist sẽ tự động tạo ra một mảng mới và copy lại các phần tử mảng cũ.
     *
     * ưu và nhược điểm của ArrayList so với Array.
     * array : + kích thước cố định
     * + chỉ có thuộc tính length
     * + chỉ có thể lưu trữ kDL nguyên thuỷ và đối tượng
     * + tốc độ duyệt mảng nhanh hơn.
     * arrayList: + kích thước mảng có thể thay đổi
     * + cung cấp nhiều method để thao tác
     * + chỉ lưu trữ kiểu đối tượng
     * + tốc độ duyệt mảng chậm hơn
     */

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
