package exercise.crud;

import java.util.Scanner;

public class TestProduct {
    static Scanner scanner = new Scanner(System.in);
    public static Product[] productsList = new Product[100];

    public static int count;


    static {
        productsList[0] = new Product(1, "Iphone", 1000, 10, "America");
        productsList[1] = new Product(2, "Xiaomi", 1000, 10, "China");
        productsList[2] = new Product(3, "Dell", 1000, 10, "China");
        productsList[3] = new Product(4, "Mac", 1000, 10, "America");
        productsList[4] = new Product(5, "Iphone", 1000, 10, "America");
        count = 5;
    }

    public static void displayProduct() {
        for (Product item : productsList) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    public static void addNewProduct() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập Giá");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Số lượng");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất");
        String production = scanner.nextLine();
        productsList[count] = new Product(count + 1, name, price, amount, production);
        System.out.println("Add new success");
    }

    public static void searchProduct() {
        int tempSearch = 0;
        System.out.println("Nhập vào tên hoặc nhà sản xuất muốn tìm: ");
        String inputSearch = scanner.nextLine();
        for (Product item: productsList) {
            if (item != null) {
                if (item.getName().contains(inputSearch) || item.getProduction().contains(inputSearch)) {
                    System.out.println(item);
                    tempSearch++;
                }
            }
        }

        if (tempSearch == 0) {
            System.out.println("Không tìm thấy");
        }
    }

    public static void deleteProduct() {
        int tempDelete = 0;
        System.out.println("Nhập vào id muốn xoá: ");
        int inputSearch = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsList.length; i++) {
            if (productsList[i] != null) {
                if (productsList[i].getId() == inputSearch) {
                    productsList[i] = productsList[i + 1];
                    for (int j = i + 1; j < productsList.length && productsList[j + 1] != null; j++) {
                        productsList[j] = productsList[j + 1];
                    }
                    System.out.println("Xoá thành công");
                    tempDelete++;
                }
            }
        }
        if (tempDelete == 0) {
            System.out.println("Xoá không thành công");
        }
    }

    public static void updateProduct() {
        int tempUpdate = 0;
        System.out.println("Nhập vào id muốn sửa: ");
        int inputUpdate = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < productsList.length; i++) {
            if (productsList[i] != null) {
                if (productsList[i].getId() == inputUpdate) {
                    System.out.println("Nhập tên");
                    String name = scanner.nextLine();
                    System.out.println("Nhập Giá");
                    double price = Double.parseDouble(scanner.nextLine());
                    System.out.println("Nhập Số lượng");
                    int amount = Integer.parseInt(scanner.nextLine());
                    System.out.println("Nhập nhà sản xuất");
                    String production = scanner.nextLine();
                    productsList[i] = new Product(i + 1, name, price,amount,production);
                    System.out.println("Sửa thành công");
                    tempUpdate++;
                }
            }
        }
        if (tempUpdate == 0) {
            System.out.println("không tìm thấy");
        }
    }

    public static void main(String[] args) {
        do {
            System.out.println("----------Product Management------------");
            System.out.println("1. Display list product");
            System.out.println("2. Add new product");
            System.out.println("3. Search product");
            System.out.println("4. Delete product");
            System.out.println("5. Update product");
            System.out.println("6. Exit");
            System.out.println("Choose option");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    System.out.println("Display list product");
                    displayProduct();
                    break;
                case 2:
                    System.out.println("Add new product");
                    addNewProduct();
                    break;
                case 3:
                    System.out.println("Search product");
                    searchProduct();
                    break;
                case 4:
                    System.out.println("Delete product");
                    deleteProduct();
                    break;
                case 5:
                    System.out.println("Update product");
                    updateProduct();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}
