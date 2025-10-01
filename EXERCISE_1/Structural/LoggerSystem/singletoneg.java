package LoggerSystem;

import java.util.Scanner;
import java.time.LocalDateTime;

// Singleton Logger Class
class Logger {
    private static Logger instance;

    // Private constructor
    private Logger() {}

    // Global access point
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Log method
    public void log(String message) {
        System.out.println(LocalDateTime.now() + " [LOG] " + message);
    }
}

// Client
public class singletoneg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        System.out.println(" Logger System Started!");
        System.out.println("Enter number of logs to record: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter log message " + i + ": ");
            String msg = sc.nextLine();
            logger.log(msg);
        }

        // Show that only one instance is used
        Logger anotherLogger = Logger.getInstance();
        if (logger == anotherLogger) {
            System.out.println("Both references point to the SAME Logger instance!");
        }
    }
}
