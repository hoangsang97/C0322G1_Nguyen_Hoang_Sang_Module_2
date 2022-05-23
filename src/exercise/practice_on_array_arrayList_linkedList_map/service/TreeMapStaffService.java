package exercise.practice_on_array_arrayList_linkedList_map.service;

import exercise.practice_on_array_arrayList_linkedList_map.model.DailyWorker;
import exercise.practice_on_array_arrayList_linkedList_map.model.ManagementStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.ProductionStaff;
import exercise.practice_on_array_arrayList_linkedList_map.model.Staff;

import java.util.HashMap;

public class TreeMapStaffService {
    public static HashMap<Integer, Staff> staffHashMap = new HashMap<>();

    static {
        staffHashMap.put(1, new ManagementStaff("tran van a", 2000, "DN", 1000, 1.4));
        staffHashMap.put(2, new ProductionStaff("tran van b", 1992, "DN", 24));
        staffHashMap.put(3, new DailyWorker("tran van c", 1991, "DN", 2000));
    }

    public static void main(String[] args) {
        for (Integer item : staffHashMap.keySet()) {
            if (item != null) {
                System.out.println(item + " " + staffHashMap.get(item));
            } else {
                if (staffHashMap.containsKey(item)) {
                    //Đã tồn tại key;
                } else {
                    //Chưa tồn tại key;
                }

            }
        }
    }
}
