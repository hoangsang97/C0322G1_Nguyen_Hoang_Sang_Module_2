package exercise.practice_on_array_arrayList_linkedList_map.controller;

import exercise.practice_on_array_arrayList_linkedList_map.service.ArrayListStaffService;
import exercise.practice_on_array_arrayList_linkedList_map.service.IStaffService;

import java.util.Scanner;

public class DisplayArrayList {
    static IStaffService arrayListStaffService = new ArrayListStaffService();
    static ArrayListStaffService listStaffService = new ArrayListStaffService();
    public static Scanner sc = new Scanner(System.in);

    public static void displayMain() {
        do {
            System.out.println("-----------Menu Staff-------------");
            System.out.println("1.Display All Staff");
            System.out.println("2.Display ManagementStaff");
            System.out.println("3.Display ProductionStaff");
            System.out.println("4.Display DailyWorker");
            System.out.println("5.Display employee salary");
            System.out.println("6.Display sắp xếp theo lương tăng dần");
            System.out.println("7.Display sắp xếp theo tên tăng dần");
            System.out.println("8.Exit");
            System.out.println("---------------Choose---------------");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("-----------Display Staff-------------");
                    arrayListStaffService.displayArrayStaff();
                    break;
                case 2:
                    System.out.println("-----------Display ManagementStaff-------------");
                    arrayListStaffService.displayManagementStaff();
                    break;
                case 3:
                    System.out.println("-----------Display ProductionStaff-------------");
                    arrayListStaffService.displayProductionStaff();
                    break;
                case 4:
                    System.out.println("-----------Display DailyWorker-------------");
                    arrayListStaffService.displayDailyWorkerStaff();
                    break;
                case 5:
                    System.out.println("-----------Display employee salary-------------");
                    arrayListStaffService.displayEmployeeSalaryStaff();
                    break;
                case 6:
                    System.out.println("-----------Display sắp xếp theo lương tăng dần-------------");
                    listStaffService.displaySaralyComparator();
                    break;
                case 7:
                    System.out.println("-----------Display sắp xếp theo tên tăng dần-------------");
                    listStaffService.displayNameComparator();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
