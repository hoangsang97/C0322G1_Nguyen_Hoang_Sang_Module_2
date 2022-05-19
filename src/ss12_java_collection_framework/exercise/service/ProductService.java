package ss12_java_collection_framework.exercise.service;

import ss12_java_collection_framework.exercise.model.Product;
import ss12_java_collection_framework.exercise.utils.ProductPriceAugmentComparator;
import ss12_java_collection_framework.exercise.utils.ProductPriceReductionAugmentComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> productList = new ArrayList<>();


    static {
        productList.add(new Product(1, "iphone X", 200, 10, "America"));
        productList.add(new Product(2, "iphone 11", 200, 10, "America"));
        productList.add(new Product(3, "iphone 12", 500, 10, "America"));
        productList.add(new Product(5, "iphone 13", 400, 10, "America"));
        productList.add(new Product(4, "iphone 14", 300, 10, "America"));
        Collections.sort(productList, new ProductPriceAugmentComparator());
    }

    @Override
    public void addNewProduct() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập Giá");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Số lượng");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất");
        String production = scanner.nextLine();
        int id = productList.get(productList.size() - 1).getId() + 1;
        Product product = new Product(id, name, price, amount, production);
        productList.add(product);
        System.out.println("Add new success");
    }

    @Override
    public void displayListProduct() {
        for (Product item: productList) {
            System.out.println(item);
        }
    }

    @Override
    public void removeProductByiD() {
        System.out.println("Nhập id bạn muốn xóa: ");
        int inputRemoveId = Integer.parseInt(scanner.nextLine());
        if ((inputRemoveId - 1) >= productList.size()) {
            System.out.println("Không tồn tại id");
        } else {
            productList.remove(inputRemoveId - 1);
        }
        System.out.println("Delete successfully");
    }

    @Override
    public void findProductByName() {
        System.out.println("Nhập tên bạn muốn tìm: ");
        String inputName = scanner.nextLine();
        int temp = 0;
        for (int i = 0; i < productList.size(); i++) {
            if ((productList.get(i)).getName().contains(inputName)) {
                System.out.println(productList.get(i));
                temp ++;
            }
        }

        if (temp == 0) {
            System.out.println("không tìm thấy tên");
        }
    }

    @Override
    public void updateProductById() {
        System.out.println("Nhập id bạn muốn sửa: ");
        int inputUpdateId = Integer.parseInt(scanner.nextLine());
        int temp = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == inputUpdateId) {
                System.out.println("Nhập tên");
                String name = scanner.nextLine();
                System.out.println("Nhập Giá");
                double price = Double.parseDouble(scanner.nextLine());
                System.out.println("Nhập Số lượng");
                int amount = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập nhà sản xuất");
                String production = scanner.nextLine();

                productList.get(i).setName(name);
                productList.get(i).setPrice(price);
                productList.get(i).setAmount(amount);
                productList.get(i).setProduction(production);
                temp ++;
                System.out.println("successful update");
            }
        }

        if (temp == 0) {
            System.out.println("không tìm thấy id");
        }
    }
}
