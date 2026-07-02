public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("--- Testing Singleton Pattern ---");

        // Attempt to create two separate logger objects
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Use the loggers
        logger1.log("System initialized.");
        logger2.log("Connecting to database...");

        // Verification: Check if both variables point to the exact same object in memory
        if (logger1 == logger2) {
            System.out.println("\nSUCCESS: Both logger1 and logger2 hold the same instance.");
        } else {
            System.out.println("\nFAILURE: Multiple instances were created.");
        }

        // Further proof: printing the memory hash codes (they will be identical)
        System.out.println("logger1 memory address hash: " + logger1.hashCode());
        System.out.println("logger2 memory address hash: " + logger2.hashCode());
    }
}