package Smart_Home;

public interface Device {
    int getId();
    String getDevice();
    void turnOn();
    void turnOff();
    String getStatus();
    void update(); // for observer pattern or automation triggers
}
