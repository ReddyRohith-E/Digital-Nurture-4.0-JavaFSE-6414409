public class Logger {
    private static Logger instance;

    private Logger() {
        // Private constructor to prevent instantiation
        System.out.println("Logger instance created.");
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
            System.out.println("Logger instance initialized.");
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(message);
        System.out.println("Log message recorded.");
    }
}