package ss15_xu_li_ngoai_le_va_debug.test;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainDemo {
    static Scanner scanner = new Scanner(System.in);
    public static void Demo() throws FileNotFoundException, NegativeArraySizeException {
        System.out.println("Nhập kích thước của mảng");
        boolean check = false;
        int size = 0;
        do {
            check = false;
            try {
                try {
                    size = Integer.parseInt(scanner.nextLine());
                } catch (Exception e) {
                    System.out.println("Bị lỗi");
                }

            if (size % 2 == 0){
                throw new MyException("Size phải là số lẻ!");
            }
                int[] numArr = new int[size];
                System.out.println(numArr[100]);
            } catch (InputMismatchException e) {
                System.out.println("Không được nhập ký tự chữ, vui lòng nhập lại: ");
                check = true;
                e.printStackTrace();
            } catch (NegativeArraySizeException e) {
                System.out.println("Không được nhập số âm, vui lòng nhập lại: ");
                check = true;
//                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Truy cập quá size, vui lòng nhập lại: ");
                check = true;
            } catch (Exception e) {
                System.out.println("NHập lỗi, vui lòng nhập lại: ");
                check = true;
            }

        } while (check);
    }

    public static void main(String[] args) {
        try {
            Demo();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
