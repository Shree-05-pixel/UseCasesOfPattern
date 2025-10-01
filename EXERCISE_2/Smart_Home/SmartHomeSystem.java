package Smart_Home;

import java.util.Scanner;

public class SmartHomeSystem {
    public static void main(String[] args) {
        CentralHub hub = new CentralHub();
        Scheduler scheduler = new Scheduler();
        Automation automation = new Automation();
        Scanner scanner = new Scanner(System.in);

        while(true) {
            try {
                System.out.println("\n===== Smart Home Menu =====");
                System.out.println("1. Add Device");
                System.out.println("2. Remove Device");
                System.out.println("3. Turn On Device");
                System.out.println("4. Turn Off Device");
                System.out.println("5. Set Schedule");
                System.out.println("6. Add Automation Trigger");
                System.out.println("7. Show Device Statuses");
                System.out.println("8. Show Schedules");
                System.out.println("9. Run Automation Triggers");
                System.out.println("10. Set Thermostat Temperature By ID");
                System.out.println("11. Add Authorized Users for Door");
                System.out.println("12. Exit");
                System.out.print("Enter option: ");

                int option = Integer.parseInt(scanner.nextLine());
                switch(option) {
                    case 1:
                        System.out.print("Enter device type (light, thermostat, door): ");
                        String type = scanner.nextLine().toLowerCase();
                        System.out.print("Enter device ID: ");
                        int id = Integer.parseInt(scanner.nextLine());

                        Device d = null;
                        switch(type) {
                            case "light" -> d = new Light(id);
                            case "thermostat" -> d = new Thermostat(id);
                            case "door" -> {
                                Door door = new Door(id);
                                d = new DeviceProxy(door, "admin"); // default admin
                            }
                            default -> LoggerUtil.log("Invalid device type.");
                        }
                        if(d!=null) hub.addDevice(d);
                        break;

                    case 2:
                        System.out.print("Enter device ID to remove: ");
                        int rid = Integer.parseInt(scanner.nextLine());
                        hub.removeDevice(rid);
                        break;

                    case 3:
                        System.out.print("Enter device ID to turn ON: ");
                        int tid = Integer.parseInt(scanner.nextLine());
                        Device td = hub.getDeviceById(tid);
                        if(td instanceof DeviceProxy proxy) {
                            System.out.print("Enter username: ");
                            String user = scanner.nextLine();
                            proxy.secureTurnOn(user);
                        } else if(td!=null) {
                            td.turnOn();
                        } else LoggerUtil.log("Device not found.");
                        break;

                    case 4:
                        System.out.print("Enter device ID to turn OFF: ");
                        int offId = Integer.parseInt(scanner.nextLine());
                        Device dOff = hub.getDeviceById(offId);
                        if(dOff!=null) dOff.turnOff();
                        else LoggerUtil.log("Device not found.");
                        break;

                    case 5:
                        System.out.print("Enter device ID to schedule: ");
                        int sid = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter time (HH:MM): ");
                        String time = scanner.nextLine();
                        System.out.print("Enter command (Turn On/Turn Off): ");
                        String cmd = scanner.nextLine();
                        scheduler.setSchedule(sid, time, cmd);
                        break;

                    case 6:
                        System.out.print("Enter condition (e.g., temperature > 40): ");
                        String cond = scanner.nextLine();
                        System.out.print("Enter action (e.g., turnOff(1)): ");
                        String act = scanner.nextLine();
                        automation.addTrigger(cond, act);
                        break;

                    case 7: hub.showDeviceStatuses(); break;
                    case 8: scheduler.showSchedules(); break;
                    case 9: automation.runTriggers(hub); break;

                    case 10:
                        System.out.print("Enter Thermostat ID: ");
                        int thId = Integer.parseInt(scanner.nextLine());
                        Device thDev = hub.getDeviceById(thId);
                        if(thDev instanceof Thermostat th) {
                            System.out.print("Enter current temperature: ");
                            int temp = Integer.parseInt(scanner.nextLine());
                            th.setCurrentTemp(temp);
                            LoggerUtil.log(th.getUserView());
                        } else LoggerUtil.log("Device not found or not a Thermostat.");
                        break;

                    case 11:
                        System.out.print("Enter Door ID: ");
                        int doorId = Integer.parseInt(scanner.nextLine());
                        Device door = hub.getDeviceById(doorId);
                        if(door instanceof DeviceProxy proxy) {
                            System.out.print("Enter username to authorize: ");
                            String user = scanner.nextLine();
                            proxy.addAuthorizedUser(user);
                        } else LoggerUtil.log("Device is not a Door proxy.");
                        break;

                    case 12: LoggerUtil.log("Exiting..."); scanner.close(); System.exit(0);

                    default: LoggerUtil.log("Invalid option.");
                }

            } catch(Exception e) {
                LoggerUtil.log("Error: " + e.getMessage());
            }
        }
    }
}
