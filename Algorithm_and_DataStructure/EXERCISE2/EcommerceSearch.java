package Algorithm_and_DataStructure.EXERCISE2;

import java.util.Arrays;
import java.util.Comparator;

public class EcommerceSearch {

    static class Product {
        int productId;
        String productName;
        String category;

        Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        public String toString() {
            return "ID: " + productId +
                    ", Name: " + productName +
                    ", Category: " + category;
        }
    }

    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int targetId) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Fashion"),
                new Product(108, "Mobile", "Electronics"),
                new Product(101, "Book", "Education"),
                new Product(110, "Watch", "Accessories")
        };

        int searchId = 108;

        Product linearResult = linearSearch(products, searchId);

        if (linearResult != null) {
            System.out.println("Linear Search Result:");
            System.out.println(linearResult);
        } else {
            System.out.println("Product not found using Linear Search.");
        }

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));

        Product binaryResult = binarySearch(products, searchId);

        if (binaryResult != null) {
            System.out.println("\nBinary Search Result:");
            System.out.println(binaryResult);
        } else {
            System.out.println("Product not found using Binary Search.");
        }
    }
}