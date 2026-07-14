import java.util.HashMap;
import java.util.Map;

public class Inventory {
    // HashMap to store products. Key: productId, Value: Product object
    private Map<String, Product> productMap;

    public Inventory() {
        this.productMap = new HashMap<>();
    }

    // 1. Add a Product
    public void addProduct(Product product) {
        if (productMap.containsKey(product.getProductId())) {
            System.out.println("Error: Product ID " + product.getProductId() + " already exists.");
        } else {
            productMap.put(product.getProductId(), product);
            System.out.println("Added: " + product.getProductName());
        }
    }

    // 2. Update a Product (Quantity and Price)
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = productMap.get(productId);
        if (product != null) {
            product.setQuantity(newQuantity);
            product.setPrice(newPrice);
            System.out.println("Updated Product ID: " + productId);
        } else {
            System.out.println("Error: Product ID " + productId + " not found.");
        }
    }

    // 3. Delete a Product
    public void deleteProduct(String productId) {
        if (productMap.remove(productId) != null) {
            System.out.println("Deleted Product ID: " + productId);
        } else {
            System.out.println("Error: Product ID " + productId + " not found.");
        }
    }

    // Utility to display inventory
    public void displayInventory() {
        System.out.println("--- Current Inventory ---");
        for (Product p : productMap.values()) {
            System.out.println(p);
        }
    }
}