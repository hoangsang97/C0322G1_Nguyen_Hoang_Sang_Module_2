package _quan_ly_codegym.utils;

import _case_study.utils.AgeException;
import _quan_ly_codegym.exception.InvalidIdStudentException;
import _quan_ly_codegym.exception.InvalidIdTeacherException;
import _quan_ly_codegym.exception.SexException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class RegexData {
    static Scanner scanner = new Scanner(System.in);

    public static String regexStudent(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdStudentException("Bạn đã nhập sai mã định dạng. Mã định dạng phải là SV-XXXX");
                }
            } catch (InvalidIdStudentException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexTeacher(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new InvalidIdTeacherException("Bạn đã nhập sai mã định dạng. Mã định dạng phải là GV-XXXX");
                }
            } catch (InvalidIdTeacherException e) {
                System.out.println(e.getMessage());
            }
        } while (check);
        return temp;
    }

    public static String regexSex(String regex) {
        boolean check = true;
        String temp = null;
        do {
            temp = scanner.nextLine();
            check = false;
            try {
                if (!temp.matches(regex)) {
                    check = true;
                    throw new SexException("Bạn đã nhập sai mã định dạng. Giới tính phải có 1 trong 3 giá trị sau ( Nam, Nữ hoặc khác)");
                }
            } catch (SexException e) {
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
