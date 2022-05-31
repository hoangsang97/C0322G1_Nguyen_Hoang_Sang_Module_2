package ss18_string_regex.exercise.validate_the_name_of_the_class;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ValidateClass validateClass = new ValidateClass();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên của lớp học: ");
        String str = scanner.nextLine();
        System.out.println(validateClass.validate(str));
    }
}
