package ss18_string_regex.exercise.validate_phone;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ValidatePhone validatePhone = new ValidatePhone();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số điện thoại: ");
        String phone = scanner.nextLine();
        System.out.println(validatePhone.validate(phone));
    }
}
