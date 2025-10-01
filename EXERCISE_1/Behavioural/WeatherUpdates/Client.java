package WeatherUpdates;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        ConcreteWeatherData weatherData = new ConcreteWeatherData();
        Scanner scanner = new Scanner(System.in);

        // Default observers
        DisplayDevice phone = new ConcreteDisplayDevice("Phone");
        DisplayDevice tablet = new ConcreteDisplayDevice("Tablet");

        weatherData.registerObserver(phone);
        weatherData.registerObserver(tablet);

        System.out.println("🌦 Weather Station Started!");
        System.out.println("Options:");
        System.out.println("1. Enter new temperature");
        System.out.println("2. Add new display device");
        System.out.println("3. Remove a display device");
        System.out.println("4. Exit");

        while (true) {
            System.out.print("\nChoose option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter temperature: ");
                    String input = scanner.nextLine();
                    try {
                        float temp = Float.parseFloat(input);
                        weatherData.setTemperature(temp);
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid input! Enter a number.");
                    }
                    break;

                case "2":
                    System.out.print("Enter new device name: ");
                    String newDevice = scanner.nextLine();
                    DisplayDevice device = new ConcreteDisplayDevice(newDevice);
                    weatherData.registerObserver(device);
                    System.out.println("✅ Device '" + newDevice + "' added.");
                    break;

                case "3":
                    System.out.print("Enter device name to remove: ");
                    String removeDevice = scanner.nextLine();
                    // Find and remove device by name
                    DisplayDevice toRemove = null;
                    for (DisplayDevice d : new java.util.ArrayList<>(weatherData.devices)) {
                        if (d.toString().equalsIgnoreCase(removeDevice)) {
                            toRemove = d;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        weatherData.removeObserver(toRemove);
                        System.out.println("✅ Device '" + removeDevice + "' removed.");
                    } else {
                        System.out.println("❌ No such device found.");
                    }
                    break;

                case "4":
                    System.out.println("👋 Exiting Weather Station...");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}
