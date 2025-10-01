package EXERCISE_1.Behavioural.WeatherUpdates;

import java.util.Scanner;


public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConcreteSubject weatherStation = new ConcreteSubject();

        // Add some observers (subscribers)
        Observer user1 = new ConcreteObserver("Alice");
        Observer user2 = new ConcreteObserver("Bob");
        Observer user3 = new ConcreteObserver("Charlie");

        weatherStation.registerObserver(user1);
        weatherStation.registerObserver(user2);
        weatherStation.registerObserver(user3);

        // Keep taking weather updates from user
        String weather;
        while (true) {
            System.out.print("\nEnter weather update (or type 'exit' to quit): ");
            weather = scanner.nextLine();

            if (weather.equalsIgnoreCase("exit")) {
                System.out.println("Exiting Weather Station...");
                break;
            }

            weatherStation.setWeather(weather);
        }

        scanner.close();
    }
}
