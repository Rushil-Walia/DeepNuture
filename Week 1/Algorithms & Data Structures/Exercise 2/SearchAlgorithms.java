import java.util.Arrays;

// SearchAlgorithms.java
public class SearchAlgorithms {

    // --- Linear Search ---
    // Checks each element one by one until a match is found.
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product p : products) {
            if (p.getProductId() == targetId) {
                return p;
            }
        }
        return null; // Product not found
    }

    // --- Binary Search ---
    // Repeatedly divides the sorted search interval in half.
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midId = products[mid].getProductId();

            if (midId == targetId) {
                return products[mid];
            }
            if (midId < targetId) {
                left = mid + 1; // Target must be in the right half
            } else {
                right = mid - 1; // Target must be in the left half
            }
        }
        return null; // Product not found
    }

    // --- Test Implementation ---
    public static void main(String[] args) {
        // 1. Store products in an array
        Product[] inventory = {
            new Product(105, "Wireless Mouse", "Electronics"),
            new Product(101, "Mechanical Keyboard", "Electronics"),
            new Product(109, "Coffee Maker", "Home Goods"),
            new Product(102, "Desk Lamp", "Home Goods"),
            new Product(107, "Gaming Monitor", "Electronics")
        };

        int searchId = 107;

        // Linear Search Test (Array does not need to be sorted)
        System.out.println("--- Linear Search ---");
        Product foundLinear = linearSearch(inventory, searchId);
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Not Found"));

        // Binary Search Test (Array MUST be sorted first)
        System.out.println("\n--- Binary Search ---");
        Arrays.sort(inventory); // Sorts based on the compareTo method
        Product foundBinary = binarySearch(inventory, searchId);
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Not Found"));
    }
}