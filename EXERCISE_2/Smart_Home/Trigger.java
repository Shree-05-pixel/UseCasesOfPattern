package Smart_Home;


public class Trigger {
    private final String condition; // e.g., "temperature > 40"
    private final String action;    // e.g., "turnOn(1)"

    public Trigger(String condition, String action) {
        this.condition = condition;
        this.action = action;
    }

    public String getCondition() { return condition; }
    public String getAction() { return action; }
}

