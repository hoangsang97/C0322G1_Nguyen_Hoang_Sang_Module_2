package ss17_io_binarifile_and_serialization.exercise.copy_the_binary_file;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
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
        ReadAndWriteBinary.write("src/ss17_io_binarifile_and_serialization/exercise/copy_the_binary_file/product.csv", productList);
        System.out.println("Add new success");
    }

    @Override
    public void displayListProduct() {
        productList = (List<Product>) ReadAndWriteBinary.read("src/ss17_io_binarifile_and_serialization/exercise/copy_the_binary_file/product.csv");
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
    private static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    @Override
    public void copyTheBinaryFile(){
        File sourceFile = new File("src/ss17_io_binarifile_and_serialization/exercise/copy_the_binary_file/product.csv");
        File destFile = new File("src/ss17_io_binarifile_and_serialization/exercise/copy_the_binary_file/productCopy.csv");

        try {
            copyFileUsingJava7Files(sourceFile, destFile);
            //copyFileUsingStream(sourceFile, destFile);
            System.out.println("Đã sao chép xong");
        } catch (IOException ioe) {
            System.out.println("Không thể sao chép tệp đó");
            System.out.println(ioe.getMessage());
        }
    }

    private static void copyFileStream(File source, File dest) {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
