import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        logger.info("Starting the logging example application");
        
        logger.trace("This is a trace message - most detailed");
        logger.debug("This is a debug message - for debugging purposes");
        logger.info("This is an info message - general information");
        logger.warn("This is a warning message");
        logger.error("This is an error message");

        String userName = "Admin";
        int attempts = 3;
        logger.warn("User {} failed to login after {} attempts", userName, attempts);

        try {
            System.out.println(10/0);
        } catch (ArithmeticException e) {
            logger.error("An arithmetic error occurred: {}", e.getMessage(), e);
        }
        
        logger.info("Logging example application completed");
    }
}
