package ss17_io_binarifile_and_serialization.exercise.product_manager_saves;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static IProductService productService = new ProductService();

    public static void main(String[] args) {
        do {
            System.out.println("----------Product Management------------");
            System.out.println("1. Display list product");
            System.out.println("2. Add new product");
            System.out.println("3. Search product");
            System.out.println("4. Exit");
            System.out.println("Choose option");
            Scanner scanner = new Scanner(System.in);
            int choose = 0;
            boolean check = false;
            do {
                try {
                    choose = Integer.parseInt(scanner.nextLine());
                    check = false;
                } catch (NumberFormatException e) {
                    System.out.println("Nhập sai định dạng, xin hãy nhập lại");
                    check = true;
                }
            } while (check);

            switch (choose) {
                case 1:
                    System.out.println("Display list product");
                    productService.displayListProduct();
                    break;
                case 2:
                    System.out.println("Add new product");
                    productService.addNewProduct();
                    break;
                case 3:
                    System.out.println("Search product");
                    productService.findProductByName();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("không có option mà bạn lựa chọn, xin hãy nhập lại");
            }
        } while (true);
    }
}
