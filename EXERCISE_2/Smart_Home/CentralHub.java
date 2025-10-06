package EXERCISE_2.Smart_Home;


import java.util.ArrayList;
import java.util.List;

/**
 * CentralHub is the Subject in Observer Pattern.
 * Manages devices, notifies observers, and coordinates automation.
 */
public class CentralHub implements Subject {
    private final List<Device> devices;
    private final List<Observer> observers;

    public CentralHub() {
        this.devices = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    public void addDevice(Device d) {
        if (d == null) {
            LoggerUtil.log("Attempted to add null device.");
            return;
        }
        devices.add(d);
        LoggerUtil.log("Device added: " + d.getDevice() + " [ID=" + d.getId() + "]");
    }

    public Device removeDevice(int id) {
        for (Device d : devices) {
            if (d.getId() == id) {
                devices.remove(d);
                LoggerUtil.log("Device removed: " + d.getDevice() + " [ID=" + id + "]");
                return d;
            }
        }
        LoggerUtil.log("Device with ID " + id + " not found.");
        return null;
    }

    public Device getDeviceById(int id) {
        return devices.stream().filter(d -> d.getId() == id).findFirst().orElse(null);
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void showDeviceStatuses() {
        if (devices.isEmpty()) {
            LoggerUtil.log("No devices added.");
            return;
        }
        devices.forEach(d -> LoggerUtil.log(d.getStatus()));
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String eventType, Object data) {
        observers.forEach(o -> o.update(eventType, data));
    }
}

