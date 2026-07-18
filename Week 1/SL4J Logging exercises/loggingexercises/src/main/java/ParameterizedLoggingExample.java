import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String userName = "JohnDoe";
        int loginAttempts = 3;
        
        // Using {} as placeholders for the variables
        logger.info("User '{}' attempted to log in {} times.", userName, loginAttempts);
        
        // Parameterized logging with an exception
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An error occurred for user {}: {}", userName, e.getMessage());
        }
    }
}