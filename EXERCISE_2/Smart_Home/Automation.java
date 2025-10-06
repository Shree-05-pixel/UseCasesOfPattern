package EXERCISE_2.Smart_Home;


import java.util.ArrayList;
import java.util.List;

public class Automation {
    private final List<Trigger> triggers;

    public Automation() {
        triggers = new ArrayList<>();
    }

    // Add trigger
    public void addTrigger(String condition, String action) {
        triggers.add(new Trigger(condition, action));
        System.out.println("Trigger added: " + condition + " -> " + action);
    }

    // Run triggers
    public void runTriggers(CentralHub hub) {
        if (triggers.isEmpty()) {
            System.out.println("No automation triggers set.");
            return;
        }

        for (Trigger trigger : triggers) {
            try {
                // Normalize condition: temperature>70 or temperature < 70
                String cond = trigger.getCondition().replaceAll("\\s+", ""); // remove spaces
                String operator = null;
                int value = 0;

                if (cond.contains(">")) {
                    operator = ">";
                    value = Integer.parseInt(cond.split(">")[1]);
                } else if (cond.contains("<")) {
                    operator = "<";
                    value = Integer.parseInt(cond.split("<")[1]);
                } else if (cond.contains("=")) {
                    operator = "=";
                    value = Integer.parseInt(cond.split("=")[1]);
                } else {
                    System.out.println("Invalid condition: " + cond);
                    continue;
                }

                for (Device device : hub.getDevices()) {
                    if (device instanceof Thermostat thermostat) {
                        int temp = thermostat.getCurrentTemp();
                        boolean conditionMet = switch (operator) {
                            case ">" -> temp > value;
                            case "<" -> temp < value;
                            case "=" -> temp == value;
                            default -> false;
                        };

                        if (conditionMet) {
                            // Execute action
                            String act = trigger.getAction().replaceAll("\\s+", "");
                            String actionCommand = act.split("\\(")[0];
                            int actionId = Integer.parseInt(act.replaceAll("[^0-9]", ""));

                            Device actionDevice = hub.getDeviceById(actionId);
                            if (actionDevice != null) {
                                if (actionCommand.equalsIgnoreCase("turnOn")) {
                                    actionDevice.turnOn();
                                    System.out.println("Triggered: turnOn(" + actionId + ")");
                                } else if (actionCommand.equalsIgnoreCase("turnOff")) {
                                    actionDevice.turnOff();
                                    System.out.println("Triggered: turnOff(" + actionId + ")");
                                }
                            } else {
                                System.out.println("Action device not found: " + actionId);
                            }
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println("Failed to run trigger: " + trigger.getAction() + " | Error: " + e.getMessage());
            }
        }

        System.out.println("Automation triggers executed.");
    }
}

