public class Main {

    public static void main(String[] args) {

        InventoryManager manager = new InventoryManager();

        manager.addProduct(
                new Product(101, "Laptop", 20, 55000));

        manager.addProduct(
                new Product(102, "Mouse", 100, 500));

        manager.displayInventory();

        System.out.println();

        manager.updateProduct(
                101, "Gaming Laptop", 15, 65000);

        manager.displayInventory();

        System.out.println();

        manager.deleteProduct(102);

        manager.displayInventory();
    }
}