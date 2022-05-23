package exercise.practice_on_array_arrayList_linkedList_map.service;

public interface IStaffService {
    void displayArrayStaff();
    void displayManagementStaff();
    void displayDailyWorkerStaff();
    void displayProductionStaff();
    void displayEmployeeSalaryStaff();

    /**
     * khi viết các phương thức (hiển thị, thêm, sửa, xoá... ) dùng chung thì tạo interface,
     * dùng abstract class khi ghi lại phương thức của lớp con;
     */
}
