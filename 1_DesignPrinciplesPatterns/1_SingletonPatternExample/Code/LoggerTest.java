public class LoggerTest {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        Logger l2 = Logger.getInstance();
        if (l1 == l2)
            System.out.println("Logger is a singleton. Both references point to the same instance.");
        else
            System.out.println("Logger is not a singleton. Different instances were created.");
        l1.log("Log message.");
    }
}