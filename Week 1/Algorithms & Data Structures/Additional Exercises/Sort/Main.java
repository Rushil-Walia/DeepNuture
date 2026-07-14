import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Order[] ordersForBubble = {
            new Order(1, "Alice", 250.50),
            new Order(2, "Bob", 15.00),
            new Order(3, "Charlie", 99.99),
            new Order(4, "Diana", 500.00)
        };

        // Clone the array so we can test both sorts fairly
        Order[] ordersForQuick = ordersForBubble.clone();

        System.out.println("--- Bubble Sort ---");
        OrderSorter.bubbleSort(ordersForBubble);
        for (Order o : ordersForBubble) {
            System.out.println(o.customerName + " - $" + o.totalPrice);
        }

        System.out.println("\n--- Quick Sort ---");
        OrderSorter.quickSort(ordersForQuick, 0, ordersForQuick.length - 1);
        for (Order o : ordersForQuick) {
            System.out.println(o.customerName + " - $" + o.totalPrice);
        }
    }
}