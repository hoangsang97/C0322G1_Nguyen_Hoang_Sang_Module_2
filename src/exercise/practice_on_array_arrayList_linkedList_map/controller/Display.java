package exercise.practice_on_array_arrayList_linkedList_map.controller;

import exercise.practice_on_array_arrayList_linkedList_map.service.ArrayStaffService;
import exercise.practice_on_array_arrayList_linkedList_map.service.IStaffService;

import java.util.Scanner;

public class Display {
    IStaffService staffService = new ArrayStaffService();
    public static Scanner sc = new Scanner(System.in);

    public void displayMain() {
        do {
            System.out.println("-----------Menu Staff-------------");
            System.out.println("1.Display All Staff");
            System.out.println("2.Display ManagementStaff");
            System.out.println("3.Display ProductionStaff");
            System.out.println("4.Display DailyWorker");
            System.out.println("5.Exit");
            System.out.println("---------------Choose---------------");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("-----------Display Staff-------------");
                    staffService.displayArrayStaff();
                    break;
                case 2:
                    System.out.println("-----------Display ManagementStaff-------------");
                    staffService.displayManagementStaff();
                    break;
                case 3:
                    System.out.println("-----------Display ProductionStaff-------------");
                    staffService.displayProductionStaff();
                    break;
                case 4:
                    System.out.println("-----------Display DailyWorker-------------");
                    staffService.displayDailyWorkerStaff();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
