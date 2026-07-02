import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    
    // Create the logger instance tied to this specific class
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        
        // Simulating a critical failure
        logger.error("This is an error message: Database connection failed.");
        
        // Simulating a potential issue that doesn't stop the application
        logger.warn("This is a warning message: Memory usage is getting high.");
        
        // Bonus: Info and Debug levels (Good for general tracking)
        logger.info("This is an info message: Application started successfully.");
        logger.debug("This is a debug message: Calculating user permissions...");
    }
}