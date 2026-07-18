import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderExample {
    private static final Logger logger = LoggerFactory.getLogger(AppenderExample.class);

    public static void main(String[] args) {
        logger.trace("This is a TRACE message (will not print because root level is DEBUG)");
        
        logger.debug("This is a DEBUG message. It will print to console and app.log.");
        
        logger.info("This is an INFO message indicating normal application flow.");
        
        logger.warn("This is a WARN message. Something unexpected might have happened.");
        
        logger.error("This is an ERROR message. It indicates a failure.");
        
        System.out.println("Check your console output and the 'app.log' file in your project directory!");
    }
}