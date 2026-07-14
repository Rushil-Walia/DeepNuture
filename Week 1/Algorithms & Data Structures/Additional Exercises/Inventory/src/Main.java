public class Main {
    public static void main(String[] args) {
        Inventory warehouse = new Inventory();

        // Test Adding
        warehouse.addProduct(new Product("P001", "Gaming Laptop", 10, 1200.50));
        warehouse.addProduct(new Product("P002", "Wireless Mouse", 50, 25.99));
        
        // Test Updating
        warehouse.updateProduct("P001", 8, 1150.00); // Sold 2 laptops, dropped price
        
        // Test Deleting
        warehouse.deleteProduct("P002"); 
        
        // Display final state
        warehouse.displayInventory();
    }
}