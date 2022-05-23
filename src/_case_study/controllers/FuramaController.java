package _case_study.controllers;

import _case_study.services.EmployeeService;
import _case_study.services.impl.CustomerServiceImpl;
import _case_study.services.impl.EmployeeServiceImpl;
import _case_study.services.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    public static Scanner sc = new Scanner(System.in);

    public static void displayMainMenu() {
        do {
            System.out.println("----------Menu Manager-----------");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");

            System.out.println("--------Choose---------");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    displayEmployeeManagement();
                    break;
                case 2:
                    displayCustomerManagement();
                    break;
                case 3:
                    displayFacilityManagement();
                    break;
                case 4:
                    System.out.println("Booking Management");
                    System.out.println("1. Add new booking");
                    System.out.println("2. Display list booking");
                    System.out.println("3. Create new contracts");
                    System.out.println("4. Display list contracts");
                    System.out.println("5. Edit contracts");
                    System.out.println("6. Return main menu");
                    break;
                case 5:
                    System.out.println("Promotion Management");
                    System.out.println("1. Display list customers use service");
                    System.out.println("2. Display list customers get voucher");
                    System.out.println("3. Return main menu");
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }

    public static void displayEmployeeManagement() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        do {
            System.out.println("-------------Employee Management------------");
            System.out.println("1. Display list employees");
            System.out.println("2. Add new employee");
            System.out.println("3. Edit employee");
            System.out.println("4. Return main menu");
            System.out.println("--------Choose---------");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("------Display list employees-------");
                    employeeService.display();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
            }
        } while (true);
    }

    public static void displayCustomerManagement() {
        CustomerServiceImpl customerService = new CustomerServiceImpl();
        do {
            System.out.println("-------------Customer Management------------");
            System.out.println("1. Display list customers");
            System.out.println("2. Add new customers");
            System.out.println("3. Edit customers");
            System.out.println("4. Return main menu");
            System.out.println("--------Choose---------");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("------Display list employees-------");
                    customerService.display();
                    break;
                case 2:
                    System.out.println("--------Add new customers---------");
                    customerService.addNew();
                    break;
            }
        } while (true);
    }

    public static void displayFacilityManagement() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        do {
            System.out.println("-------------Facility Management------------");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display list facility maintenance");
            System.out.println("4. Return main menu");
            System.out.println("--------Choose---------");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("------Display list facility-------");
                    facilityService.display();
                    break;
                case 2:
                    System.out.println("--------Add new facility---------");
                    addNewFacilityManagement();
                    break;
            }
        } while (true);
    }

    public static void addNewFacilityManagement() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        do {
            System.out.println("-------------Add New Facility Management------------");
            System.out.println("1. Add new Villa");
            System.out.println("2. Add new House");
            System.out.println("3. Add new Room");
            System.out.println("4. Return main menu");
            System.out.println("--------Choose---------");
            int choose = Integer.parseInt(sc.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("------Add new Villa-------");
                    facilityService.addNewVilla();
                    displayFacilityManagement();
                    break;
            }
        } while (true);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
