package ss12_java_collection_framework.exercise.array_list.service;

import ss12_java_collection_framework.exercise.array_list.model.Product;
import ss12_java_collection_framework.exercise.array_list.utils.ProductPriceAugmentComparator;
import ss12_java_collection_framework.exercise.array_list.utils.ReadAndWrite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> productList = new ArrayList<>();

    @Override
    public void addNewProduct() {
        System.out.println("Nhập id");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập Giá");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập Số lượng");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập nhà sản xuất");
        String production = scanner.nextLine();
        Product product = new Product(id, name, price, amount, production);
        productList.add(product);
        String line = product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getAmount() + "," + product.getProduction();
        ReadAndWrite.write("src/ss12_java_collection_framework/exercise/array_list/data/product.csv", line);
        System.out.println("Add new success");
    }

    @Override
    public void displayListProduct() {
        List<String[]> listLine = ReadAndWrite.read("src/ss12_java_collection_framework/exercise/array_list/data/product.csv");
        productList.clear();
        for (String[] item: listLine) {
            Product product = new Product(Integer.parseInt(item[0]), item[1], Double.parseDouble(item[2]), Integer.parseInt(item[3]), item[4]);
            productList.add(product);
        }

        Collections.sort(productList);
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
            System.out.println("Delete successfully");
        }
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
