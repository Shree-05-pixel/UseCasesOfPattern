package EXERCISE_2.Smart_Home;



import java.util.HashSet;
import java.util.Set;

/**
 * Proxy pattern: secure access to Doors.
 */
public class DeviceProxy implements Device {
    private final Device device;
    private final Set<String> authorizedUsers;

    public DeviceProxy(Device device, String adminUser) {
        this.device = device;
        this.authorizedUsers = new HashSet<>();
        this.authorizedUsers.add(adminUser);
    }

    public void addAuthorizedUser(String user) {
        authorizedUsers.add(user);
        LoggerUtil.log("User " + user + " authorized for device " + device.getId());
    }

    public boolean isAuthorized(String user) {
        return authorizedUsers.contains(user);
    }

    public void secureTurnOn(String user) {
        if (isAuthorized(user)) {
            device.turnOn();
            LoggerUtil.log("Access granted. " + user + " Locked device " + device.getId());
        } else LoggerUtil.log("Access denied for " + user);
    }

    public void secureTurnOff(String user) {
        if (isAuthorized(user)) {
            device.turnOff();
            LoggerUtil.log("Access granted. " + user + "Unlocked device " + device.getId());
        } else LoggerUtil.log("Access denied for " + user);
    }

    @Override
    public void turnOn() { LoggerUtil.log("Use secureTurnOn(user) for Door " + device.getId()); }

    @Override
    public void turnOff() { LoggerUtil.log("Use secureTurnOff(user) for Door " + device.getId()); }

    @Override
    public String getStatus() { return device.getStatus(); }

    @Override
    public int getId() { return device.getId(); }

    @Override
    public void update() { device.update(); }

    public Device getWrappedDevice() { return device; }

    @Override
    public String getDevice() { return device.getDevice(); }
}

