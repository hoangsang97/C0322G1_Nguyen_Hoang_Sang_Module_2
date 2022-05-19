package ss12_java_collection_framework.exercise.array_list.utils;

import ss12_java_collection_framework.exercise.array_list.model.Product;

import java.util.Comparator;

public class ProductPriceReductionAugmentComparator implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        if (o1.getPrice() < o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() > o2.getPrice()) {
            return -1;
        } else {
            return 1;
        }
    }
}
