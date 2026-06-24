package Algorithm_and_DataStructure.EXERCISE1;

public class Main {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Laptop", 20, 50000);
        Product p2 = new Product(102, "Mouse", 100, 500);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        inventory.displayProduct(101);

        inventory.updateProduct(101, "Gaming Laptop", 15, 65000);

        inventory.displayProduct(101);

        inventory.deleteProduct(102);
    }
}