package _quan_ly_tien_dien.utils;

import _quan_ly_tien_dien.exception.DateException;
import _quan_ly_tien_dien.exception.InvalidIdCustomerNgException;
import _quan_ly_tien_dien.exception.InvalidIdCustomerVnException;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    public static String regexCustomerVn(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdCustomerVnException("Bạn đã nhập sai mã định dạng. Mã định dạng phải là  KHVN-XXXXX");
                }
            } catch (InvalidIdCustomerVnException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexCustomerNg(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdCustomerNgException("Bạn đã nhập sai mã định dạng. Mã định dạng phải là  KHNG-XXXXX");
                }
            } catch (InvalidIdCustomerNgException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexIdBill(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdCustomerNgException("Bạn đã nhập sai mã định dạng. Mã định dạng phải là  LKH-XXX");
                }
            } catch (InvalidIdCustomerNgException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexDate (String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    check = false;
                } else {
                    throw new DateException("Định dạng nhập vào không đúng");
                }
            } catch (DateException e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
}
