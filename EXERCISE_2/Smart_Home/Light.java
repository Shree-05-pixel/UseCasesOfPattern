package Smart_Home;


public class Light implements Device {
    private int id;
    private boolean isOn = false;

    public Light(int id) { this.id = id; }

    @Override public int getId() { return id; }
    @Override public String getDevice() { return "Light"; }

    @Override public void turnOn() { isOn = true; System.out.println("Light " + id + " turned On"); }
    @Override public void turnOff() { isOn = false; System.out.println("Light " + id + " turned Off"); }

    @Override public String getStatus() { return "Light " + id + " is " + (isOn ? "On" : "Off"); }
    @Override public void update() {}
}
