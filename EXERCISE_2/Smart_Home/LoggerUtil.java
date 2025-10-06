package EXERCISE_2.Smart_Home;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LoggerUtil {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        String time = LocalDateTime.now().format(FORMATTER);
        System.out.println("[" + time + "] " + message);
    }

}
