import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    
    private Map<Integer, Product> inventory;

    public InventoryManager() {
        inventory = new HashMap<>();
    }

    // Add 
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Delete 
    public void deleteProduct(int productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Update 
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display 
    public void displayInventory() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}
