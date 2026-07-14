public class Main {
    public static void main(String[] args) {
        // Array must be sorted by productId for Binary Search to work!
        Product[] inventory = {
            new Product(101, "Wireless Mouse", "Electronics"),
            new Product(105, "Mechanical Keyboard", "Electronics"),
            new Product(208, "Coffee Mug", "Home"),
            new Product(310, "Desk Lamp", "Office"),
            new Product(450, "Ergonomic Chair", "Furniture")
        };

        System.out.println("--- Linear Search ---");
        Product foundLinear = SearchSystem.linearSearch(inventory, 310);
        System.out.println("Found: " + (foundLinear != null ? foundLinear.productName : "Not Found"));

        System.out.println("\n--- Binary Search ---");
        Product foundBinary = SearchSystem.binarySearch(inventory, 105);
        System.out.println("Found: " + (foundBinary != null ? foundBinary.productName : "Not Found"));
    }
}