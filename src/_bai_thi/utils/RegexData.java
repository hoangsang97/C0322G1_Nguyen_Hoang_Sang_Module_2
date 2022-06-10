package _bai_thi.utils;

import _bai_thi.exception.DateException;
import _bai_thi.exception.InvalidIdBankingException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    public static String regexIdBanking(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdBankingException("Bạn đã nhập sai mã định dạng. Mã định dạng phải là STK-XXXX");
                }
            } catch (InvalidIdBankingException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexDate(String temp, String regex) {
        boolean check = true;
        while (check) {
            try {
                if (Pattern.matches(regex, temp)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate age = LocalDate.parse(temp, formatter);
                    LocalDate now = LocalDate.now();
                    int current = Period.between(age, now).getYears();
                    if (current < 100) {
                        check = false;
                    } else {
                        throw new DateException("date phải đúng định dạng");
                    }
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
