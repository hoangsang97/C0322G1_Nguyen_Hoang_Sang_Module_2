package exercise.employee_and_student_management;

import java.util.Scanner;

public class TestPerson {
    public static Person[] personList = new Person[100];
    public static Scanner sc = new Scanner(System.in);
    public static int count;

    static {
        personList[0] = new Student(1, "Nam", 15, true, 10);
        personList[1] = new Teacher(2, "Hằng", 24, false, 1000000);
        personList[2] = new Student(3, "Thịnh", 14, true, 9);
        personList[3] = new Teacher(4, "Đan", 26, false, 2000000);
        personList[4] = new Student(5, "Duy", 13, true, 8);
        count = 5;
    }

    public static void displayPerson() {
        for (Person item : personList) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public static void displayPersonTeacher() {
        for (Person item : personList) {
            if (item instanceof Teacher) {
                System.out.println(item);
            }
        }
    }

    public static void displayPersonStudent() {
        for (Person item : personList) {
            if (item instanceof Student) {
                System.out.println(item);
            }
        }
    }

    public static void addNewPersonTeacher() {
        System.out.println("Tên: ");
        String name = sc.nextLine();
        System.out.println("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Giới tính: ");
        boolean gender = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Lương");
        double salary = Double.parseDouble(sc.nextLine());

        personList[count] = new Teacher(count + 1, name, age, gender, salary);
        System.out.println("more success");
    }

    public static void addNewPersonStudent() {
        System.out.println("Tên: ");
        String name = sc.nextLine();
        System.out.println("Tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.println("Giới tính: ");
        boolean gender = Boolean.parseBoolean(sc.nextLine());
        System.out.println("Điểm");
        double point = Double.parseDouble(sc.nextLine());

        personList[count] = new Teacher(count + 1, name, age, gender, point);
        System.out.println("more success");
    }

    public static void searchPerson() {
        System.out.println("Nhập vào tên muốn tìm: ");
        String inputName = sc.nextLine();

        for (Person person : personList) {
            if (person != null && person.getName().contains(inputName)) {
                System.out.println(person);
            }
        }
    }

    public static void searchPersonTeacher() {
        System.out.println("Nhập vào tên muốn tìm: ");
        String inputName = sc.nextLine();

        for (Person person : personList) {
            if (person instanceof Teacher && person.getName().contains(inputName)) {
                System.out.println(person);
            }
        }
    }

    public static void searchPersonStudent() {
        System.out.println("Nhập vào tên muốn tìm: ");
        String inputName = sc.nextLine();

        for (Person person : personList) {
            if (person instanceof Student && person.getName().contains(inputName)) {
                System.out.println(person);
            }
        }
    }

    public static void updatePersonTeacher() {
        System.out.println("Nhập id teacher bạn muốn sửa: ");
        int inputId = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Teacher && personList[i].getId() == inputId) {
                System.out.println("Tên: ");
                String name = sc.nextLine();
                System.out.println("Tuổi: ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.println("Giới tính: ");
                boolean gender = Boolean.parseBoolean(sc.nextLine());
                System.out.println("Lương");
                double salary = Double.parseDouble(sc.nextLine());

                personList[i] = new Teacher(inputId, name, age, gender, salary);
                System.out.println("successful fix");
            }
        }
    }

    public static void updatePersonStudent() {
        System.out.println("Nhập id student bạn muốn sửa: ");
        int inputId = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Student && personList[i].getId() == inputId) {
                System.out.println("Tên: ");
                String name = sc.nextLine();
                System.out.println("Tuổi: ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.println("Giới tính: ");
                boolean gender = Boolean.parseBoolean(sc.nextLine());
                System.out.println("Điểm");
                double point = Double.parseDouble(sc.nextLine());

                personList[i] = new Student(inputId, name, age, gender, point);
                System.out.println("successful fix");
            }
        }
    }

    public static void deletePersonTeacher() {
        System.out.println("Nhập id teacher muốn xóa: ");
        int inputIdRemove = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Teacher && personList[i].getId() == inputIdRemove) {
                for (int j = i; j < personList.length && personList[j] != null; j++) {
                    personList[j] = personList[j + 1];
                }
            }
        }
        System.out.println("successful delete");
    }

    public static void deletePersonStudent() {
        System.out.println("Nhập id student muốn xóa: ");
        int inputIdRemove = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < personList.length; i++) {
            if (personList[i] instanceof Student && personList[i].getId() == inputIdRemove) {
                for (int j = i; j < personList.length && personList[j] != null; j++) {
                    personList[j] = personList[j + 1];
                }
            }
        }
        System.out.println("successful delete");
    }

    public static void main(String[] args) {
        do {
            System.out.println("-------------Menu Manager--------------");
            System.out.println("1. Display Person");
            System.out.println("2. Add new Person");
            System.out.println("3. Search Person");
            System.out.println("4. Update Person");
            System.out.println("5. Delete Person");
            System.out.println("6. Exit");

            System.out.print("Selection: ");
            int choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1:
                    System.out.println("--------Menu Display---------");
                    System.out.println("1. Display Person");
                    System.out.println("2. Display Person Teacher");
                    System.out.println("3. Display Person Student");
                    int inputDisplay = Integer.parseInt(sc.nextLine());
                    if (inputDisplay == 1) {
                        System.out.println("Display Person");
                        displayPerson();
                        break;
                    } else if (inputDisplay == 2) {
                        System.out.println("Display Person Teacher");
                        displayPersonTeacher();
                        break;
                    } else {
                        System.out.println("Display Person Student");
                        displayPersonStudent();
                        break;
                    }
                case 2:
                    System.out.println("Add new person");
                    System.out.println("-----------Menu Add new person-----------");
                    System.out.println("1. Add new Teacher");
                    System.out.println("2. Add new Student");

                    int inputAdd = Integer.parseInt(sc.nextLine());
                    if (inputAdd == 1) {
                        System.out.println("Add new Teacher");
                        addNewPersonTeacher();
                    } else {
                        System.out.println("Add new Student");
                        addNewPersonStudent();
                    }
                    break;
                case 3:
                    System.out.println("Search Person");
                    System.out.println("-----------Menu Search-------------");
                    System.out.println("1. Search All");
                    System.out.println("2. Search Teacher");
                    System.out.println("3. Search Student");

                    int inputSearch = Integer.parseInt(sc.nextLine());
                    if (inputSearch == 1) {
                        System.out.println("Search All");
                        searchPerson();
                    } else if (inputSearch == 2) {
                        System.out.println("Search Teacher");
                        searchPersonTeacher();
                    } else {
                        System.out.println("Search Student");
                        searchPersonStudent();
                    }
                    break;
                case 4:
                    System.out.println("Update Person");
                    System.out.println("-----------Menu Update------------");
                    System.out.println("1. Update teacher");
                    System.out.println("2. Update student");

                    int inputUpdate = Integer.parseInt(sc.nextLine());
                    if (inputUpdate == 1) {
                        System.out.println("Update teacher");
                        updatePersonTeacher();
                    } else {
                        System.out.println("Update student");
                        updatePersonStudent();
                    }
                    break;
                case 5:
                    System.out.println("Delete Person");
                    System.out.println("----------Menu Delete----------");
                    System.out.println("1. Delete Teacher");
                    System.out.println("2. Delete Student");
                    int inputDelete = Integer.parseInt(sc.nextLine());
                    if (inputDelete == 1) {
                        System.out.println("Delete Teacher");
                        deletePersonTeacher();
                    } else {
                        System.out.println("Delete Student");
                        deletePersonStudent();
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}
