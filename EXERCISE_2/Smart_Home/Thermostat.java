package Smart_Home;

public class Thermostat implements Device {
    private final int id;
    private int currentTemp;
    private int thresholdTemp;
    private String season;
    private Mode mode;
    private boolean acOn;
    private boolean heaterOn;

    enum Mode { COOL, HEAT, AUTO }

    public Thermostat(int id) {
        this.id = id;
        this.mode = Mode.AUTO;
        this.thresholdTemp = 30;
        this.currentTemp = 25;
        this.season = "Moderate";
    }

    public void setCurrentTemp(int temp) {
        this.currentTemp = temp;
        updateControl();
    }

    public void setThreshold(int threshold) {
        this.thresholdTemp = threshold;

        if (threshold > 40) {
            this.season = "Summer";
            this.mode = Mode.COOL;
        } else if (threshold < 20) {
            this.season = "Winter";
            this.mode = Mode.HEAT;
        } else {
            this.season = "Moderate";
            this.mode = Mode.AUTO;
        }

        updateControl();
    }

    private void updateControl() {
        acOn = (mode == Mode.COOL && currentTemp > thresholdTemp);
        heaterOn = (mode == Mode.HEAT && currentTemp < thresholdTemp);
    }

    @Override
    public String getStatus() {
        return String.format("Thermostat set to %d", thresholdTemp);
    }

    public String getUserView() {
        String controls = (mode == Mode.COOL) ? "AC" :
                (mode == Mode.HEAT) ? "Heater" : "System";
        String onOff = (acOn || heaterOn) ? "On" : "Off";

        return String.format("Thermostat %d | Season: %s | Mode: %s | Threshold: %d | Current: %d | Controls: %s (%s)",
                id, season, mode, thresholdTemp, currentTemp, controls, onOff);
    }

    @Override public int getId() { return id; }
    @Override public String getDevice() { return "Thermostat"; }
    public int getCurrentTemp() { return currentTemp; }
    public int getThresholdTemp() { return thresholdTemp; }
    public Mode getMode() { return mode; }

    @Override public void turnOn() {}
    @Override public void turnOff() {}
    @Override public void update() {}
}
