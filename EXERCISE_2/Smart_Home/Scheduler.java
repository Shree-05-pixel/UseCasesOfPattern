package Smart_Home;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private final List<Schedule> schedules;

    public Scheduler() { schedules = new ArrayList<>(); }

    public void setSchedule(int deviceId, String time, String command) {
        schedules.add(new Schedule(deviceId, time, command));
        LoggerUtil.log("Schedule set for device " + deviceId + " at " + time + " -> " + command);
    }

    public void showSchedules() {
        if(schedules.isEmpty()) LoggerUtil.log("No schedules set.");
        schedules.forEach(s -> LoggerUtil.log("Device " + s.getDeviceId() + " " + s.getCommand() + " at " + s.getTime()));
    }
}
