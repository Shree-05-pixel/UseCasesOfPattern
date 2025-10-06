package EXERCISE_2.Smart_Home;


public class Schedule {
    private final int deviceId;
    private final String time;
    private final String command;

    public Schedule(int deviceId, String time, String command) {
        this.deviceId = deviceId;
        this.time = time;
        this.command = command;
    }

    public int getDeviceId() { return deviceId; }
    public String getTime() { return time; }
    public String getCommand() { return command; }

}
