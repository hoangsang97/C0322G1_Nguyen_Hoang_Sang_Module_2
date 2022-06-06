package _quan_ly_nhan_vien.utils;

import _case_study.utils.AgeException;
import _quan_ly_nhan_vien.exception.InvalidIdCoefficientsSalaryException;
import _quan_ly_nhan_vien.exception.InvalidIdPriceException;
import _quan_ly_nhan_vien.exception.InvalidIdProductException;
import _quan_ly_nhan_vien.exception.InvalidIdSalaryException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    public static String regexSalary(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdSalaryException("Bạn đã nhập sai định dạng, lương cơ bản phải là số dương");
                }
            } catch (InvalidIdSalaryException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexCoefficientsSalary(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdCoefficientsSalaryException("Bạn đã nhập sai định dạng, Hệ số lương phải là số dương");
                }
            } catch (InvalidIdCoefficientsSalaryException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexProduct(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdProductException("Bạn đã nhập sai định dạng, sản phẩm phải là số dương");
                }
            } catch (InvalidIdProductException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexPrice(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdPriceException("Bạn đã nhập sai định dạng, giá mỗi sản phẩm phải là số dương");
                }
            } catch (InvalidIdPriceException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexAge (String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100 && current > 18) {
                        check = false;
                    } else {
                        throw new AgeException("Tuổi phải lớn hơn 18 và bé hơn 100");
                    }
                } else {
                    throw new AgeException("Định dạng nhập vào không đúng");
                }
            } catch (AgeException e) {
                System.out.println(e.getMessage());
                temp = scanner.nextLine();
            }
        }
        return temp;
    }
}
