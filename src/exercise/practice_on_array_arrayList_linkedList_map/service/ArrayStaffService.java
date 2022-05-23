package exercise.practice_on_array_arrayList_linkedList_map.service;

import exercise.practice_on_array_arrayList_linkedList_map.model.DailyWorker;
import exercise.practice_on_array_arrayList_linkedList_map.model.ManagementStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.ProductionStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.Staff;

public class ArrayStaffService implements IStaffService{
    public static Staff[] arrayStaff = new Staff[1000];
    static {
        arrayStaff[0] = new ManagementStaff("tran van a", 2000, "DN", 1000, 1.4);
        arrayStaff[1] = new ProductionStaff("tran van b", 1992, "DN", 24);
        arrayStaff[2] = new DailyWorker("tran van c", 1991, "DN", 2000);
    }

    @Override
    public void displayArrayStaff() {
        for (int i = 0; i < arrayStaff.length; i++) {
            if (arrayStaff[i]!= null){
                System.out.println(arrayStaff[i]);
            }
        }
    }

    @Override
    public void displayManagementStaff() {
        for (int i = 0; i < arrayStaff.length; i++) {
            if (arrayStaff[i]!= null && arrayStaff[i] instanceof ManagementStaff){
                System.out.println(arrayStaff[i]);
            }
        }
    }

    @Override
    public void displayDailyWorkerStaff() {
        for (int i = 0; i < arrayStaff.length; i++) {
            if (arrayStaff[i]!= null && arrayStaff[i] instanceof ProductionStaff){
                System.out.println(arrayStaff[i]);
            }
        }
    }

    @Override
    public void displayProductionStaff() {
        for (int i = 0; i < arrayStaff.length; i++) {
            if (arrayStaff[i]!= null && arrayStaff[i] instanceof DailyWorker){
                System.out.println(arrayStaff[i]);
            }
        }
    }

    @Override
    public void displayEmployeeSalaryStaff() {

    }

    /**
     *  những khó khăn gì khi hiển thị thông tin: check mảng có null hay không
     *
     *  từ khóa instanceof làm chức năng:
     *  kiểm tra kiểu dữ liệu
     *
     *  Nếu công ty có 1001 nhân viên thì sẽ xảy ra lỗi ArrayIndexOutOfBoundsException tràn mảng
     *
     *  Đa hình lúc runtime thể hiện ở overriding
     *  Đa hình lúc compile thể hiện ở overloading
     */
}
