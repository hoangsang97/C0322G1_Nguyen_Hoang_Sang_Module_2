package exercise.test_crud_hai;

import java.util.Arrays;
import java.util.Scanner;

public class Manager {
    public static Scanner scanner = new Scanner(System.in);

    public static int id = 0;
    public static int stt = 1;
    public static Person[] managers = new Person[10];
    public static int[] count = new int[100];

    static {
        managers[0] = new Student(1, 1, "sang", 18, "nam", 10);
        managers[1] = new Student(2, 2, "sang", 18, "nam", 10);
        managers[2] = new Student(3, 3, "sang", 18, "nam", 10);
        managers[3] = new Student(4, 4, "sang", 18, "nam", 10);
    }

    public static void add() {
        System.out.println("1 - Student\n" +
                "2 - Teacher");
        int choose = Integer.parseInt(scanner.nextLine());
        switch (choose) {
            case 1:

                System.out.print("Set name : ");
                String name = scanner.nextLine();
                System.out.print("Set age : ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Set Gender : ");
                String gender = scanner.nextLine();
                System.out.print("Set Point : ");
                double point = Double.parseDouble(scanner.nextLine());
                Student student = new Student(stt, count[id], name, age, gender, point);
                managers[id] = (Person) student;
                stt++;
                id++;
                break;
            case 2:
                System.out.print("Set name : ");
                String name1 = scanner.nextLine();
                System.out.print("Set age : ");
                int age1 = Integer.parseInt(scanner.nextLine());
                System.out.print("Set Gender : ");
                String gender1 = scanner.nextLine();
                System.out.print("Set Salary : ");
                int salary = Integer.parseInt(scanner.nextLine());
                Teacher teacher = new Teacher(stt, count[id], name1, age1, gender1, salary);
                managers[id] = (Person) teacher;
                stt++;
                id++;

                break;
        }
    }


    public static void find() {
        int check = 0;
        System.out.println("Enter char :  ");
        String chart = scanner.nextLine();
        for (int i = 0; i < managers.length; i++) {
            if (managers[i] != null && managers[i].toString().contains(chart)) {
                System.out.println(managers[i]);
                check++;
            }
        }
        if (check > 0) {
            System.out.println("Can't not find ");
        }
    }

    public static void delete() {
        int pending = 0;
        System.out.println("Input No..");
        int no = Integer.parseInt(scanner.nextLine());
        for (int i = no - 1; i < managers.length - 1; i++) {
            managers[i] = null;
            managers[i] = managers[i + 1];
        }
        stt--;
        for (int i = no - 1; i < count.length - 1; i++) {
            pending = count[i];
            count[i] = count[1 + i];
            count[count.length - 1] = pending;
        }

        for (int i = 0; i < managers.length -1; i++) {
            if (managers[i] !=null) {
                managers[i].setStt(i + 1);
            }

        }
        display();

    }

    public static void display() {
        for (int i = 0; i < managers.length; i++) {
            if (managers[i] != null) {
                System.out.println(managers[i]);
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < count.length - 1; i++) {
            count[i] = 100 + i;
        }
        System.out.println(Arrays.toString(count));
        do {
            System.out.println(" ----ManagerStaffTeacherStudent----\n" +
                    "1 - Add\n" +
                    "2 - Find\n" +
                    "3 - Delete\n" +
                    "4 - Display\n" +
                    "5 - Exit\n" +

                    "You choose :");
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    add();
                    break;
                case 2:
                    find();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    display();
                    break;
                case 5:


                    System.exit(0);
            }
        } while (true);
    }
}