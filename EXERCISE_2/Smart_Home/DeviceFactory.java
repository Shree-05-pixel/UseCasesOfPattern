package EXERCISE_2.Smart_Home;



public class DeviceFactory {
    public static Device createDevice(String type, int id) {
        switch(type.toLowerCase()) {
            case "light": return new Light(id);
            case "thermostat": return new Thermostat(id);
            case "door": return new Door(id); // wrap later in proxy if needed
            default: throw new IllegalArgumentException("Invalid device type: " + type);
        }
    }
}

