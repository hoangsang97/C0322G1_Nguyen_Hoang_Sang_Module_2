package ss17_io_binarifile_and_serialization.exercise.product_manager_saves;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService{
    public static Scanner scanner = new Scanner(System.in);
    public static List<Product> productList = new LinkedList<>();

    static {
        productList.add(new Product(1, "SamSum", "ĐN", 100));
    }

    @Override
    public void addNewProduct() {
        System.out.println("Nhập tên");
        String name = scanner.nextLine();
        System.out.println("Nhập nhà sản xuất");
        String production = scanner.nextLine();
        System.out.println("Nhập Giá");
        int price = Integer.parseInt(scanner.nextLine());
        int id = productList.get(productList.size() - 1).getId() + 1;

        Product product = new Product(id, name, production, price);
        productList.add(product);
        ReadAndWriteBinary.write("src/ss17_io_binarifile_and_serialization/exercise/product_manager_saves/product.csv", productList);
        System.out.println("Add new success");
    }

    @Override
    public void displayListProduct() {
        productList = (List<Product>) ReadAndWriteBinary.read("src/ss17_io_binarifile_and_serialization/exercise/product_manager_saves/product.csv");
        for (Product item: productList) {
            System.out.println(item);
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
}
