package Week1.SingletonPatternExample;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Check if both references point to the same instance
        if (logger1 == logger2) {
            System.out.println("Logger is a singleton. Both references point to the same instance.");
        } else {
            System.out.println("Logger is not a singleton. Different instances were created.");
        }
    }
}