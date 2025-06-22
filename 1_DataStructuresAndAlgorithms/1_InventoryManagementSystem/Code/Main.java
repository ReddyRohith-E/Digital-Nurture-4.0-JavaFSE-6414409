public class Main {
    public static void main(String[] args) {
        InventoryManager manage = new InventoryManager();

        // Add
        manage.addProduct(new Product(1, "Laptop", 10, 100000));
        manage.addProduct(new Product(2, "Mouse", 50, 2000));
        manage.addProduct(new Product(3, "Keyboard", 30, 5000));

        // Initial Inventory
        System.out.println("Initial Inventory:");
        manage.displayInventory();

        // Update
        manage.updateProduct(new Product(2, "Wireless Mouse", 45, 2500));

        // Delete
        manage.deleteProduct(3);

        // Inventory after updates
        System.out.println("\nUpdated Inventory:");
        manage.displayInventory();
    }
}
