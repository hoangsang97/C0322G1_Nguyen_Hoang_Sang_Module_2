package exercise.structure_product.controller;

import exercise.structure_product.service.IProductService;
import exercise.structure_product.service.ProductService;

import java.util.Scanner;

public class Display {
    public static Scanner scanner = new Scanner(System.in);

    public void displayMain() {
        IProductService productService = new ProductService();
        do {
            System.out.println("----------Product Management------------");
            System.out.println("1. Display list product");
            System.out.println("2. Add new product");
            System.out.println("3. Search product");
            System.out.println("4. Delete product");
            System.out.println("5. Update product");
            System.out.println("6. Exit");
            System.out.println("Choose option");
            Scanner scanner = new Scanner(System.in);
            int choose = Integer.parseInt(scanner.nextLine());

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
                    System.out.println("Delete product");
                    productService.removeProductByiD();
                    break;
                case 5:
                    System.out.println("Update product");
                    productService.updateProductById();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}
