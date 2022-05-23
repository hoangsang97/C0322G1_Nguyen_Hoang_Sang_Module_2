package exercise.practice_on_array_arrayList_linkedList_map.controller;

import exercise.practice_on_array_arrayList_linkedList_map.model.ManagementStaff;
import exercise.practice_on_array_arrayList_linkedList_map.service.ArrayListStaffService;
import exercise.practice_on_array_arrayList_linkedList_map.service.IStaffService;

import java.util.Scanner;

public class DisplayArrayList {
    IStaffService ArrayListStaffService = new ArrayListStaffService();
    public static Scanner sc = new Scanner(System.in);

    public void displayMain() {
        do {
            System.out.println("-----------Menu Staff-------------");
            System.out.println("1.Display All Staff");
            System.out.println("2.Display ManagementStaff");
            System.out.println("3.Display ProductionStaff");
            System.out.println("4.Display DailyWorker");
            System.out.println("5.Display employee salary");
            System.out.println("6.Exit");
            System.out.println("---------------Choose---------------");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("-----------Display Staff-------------");
                    ArrayListStaffService.displayArrayStaff();
                    break;
                case 2:
                    System.out.println("-----------Display ManagementStaff-------------");
                    ArrayListStaffService.displayManagementStaff();
                    break;
                case 3:
                    System.out.println("-----------Display ProductionStaff-------------");
                    ArrayListStaffService.displayProductionStaff();
                    break;
                case 4:
                    System.out.println("-----------Display DailyWorker-------------");
                    ArrayListStaffService.displayDailyWorkerStaff();
                    break;
                case 5:
                    System.out.println("-----------Display employee salary-------------");
                    ArrayListStaffService.displayEmployeeSalaryStaff();
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
