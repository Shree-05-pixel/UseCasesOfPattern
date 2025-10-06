package EXERCISE_2.Smart_Home;



public class Door implements Device {
    private int id;
    private boolean locked = true;

    public Door(int id) { this.id = id; }

    @Override public int getId() { return id; }
    @Override public String getDevice() { return "Door"; }

    @Override public void turnOn() { locked = false; System.out.println("Door " + id + " Unlocked"); }
    @Override public void turnOff() { locked = true; System.out.println("Door " + id + " Locked"); }

    @Override public String getStatus() { return "Door " + id + " is " + (locked ? "Locked" : "Unlocked"); }
    @Override public void update() {}
}

