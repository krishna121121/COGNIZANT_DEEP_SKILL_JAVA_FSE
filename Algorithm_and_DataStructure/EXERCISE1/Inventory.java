package Algorithm_and_DataStructure.EXERCISE1;

import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> inventory;

    public Inventory(){
        inventory = new HashMap<>();
    }

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
        System.out.println("Product added successfully.");
    }

    public void updateProduct(int productId, String name, int quantity, double price) {
        Product product = inventory.get(productId);

        if (product != null) {
            product.setProductName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void deleteProduct(int productId) {
        if (inventory.remove(productId) != null) {
            System.out.println("Product deleted successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void displayProduct(int productId) {
        Product product = inventory.get(productId);

        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }
}