public class Logger {
    // 1. Private static instance of the class
    private static volatile Logger instance;

    // 2. Private constructor to prevent instantiation using the 'new' keyword
    private Logger() {
        
    }

    // 3. Public static method to provide global access 
    public static Logger getInstance() {
        // no locking check
        if (instance == null) {
            // Lock the class block so only one thread can enter at a time
            synchronized (Logger.class) {
                // Second check (with locking) - ensures only one instance is created
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // A simple method to demonstrate the logger's functionality
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}