package exercise.practice_on_array_arrayList_linkedList_map.utils;

import exercise.practice_on_array_arrayList_linkedList_map.model.Staff;

import java.util.Comparator;

public class StaffSalaryComparator implements Comparator<Staff> {
    @Override
    public int compare(Staff o1, Staff o2) {
        if (o1.employeeSalary() > o2.employeeSalary()) {
            return 1;
        } else if (o1.employeeSalary() < o2.employeeSalary()) {
            return -1;
        } else {
            return 1;
        }
    }
}
