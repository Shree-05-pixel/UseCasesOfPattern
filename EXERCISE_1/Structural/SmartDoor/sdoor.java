package SmartDoor;

import java.util.Scanner;

// Subject Interface
interface SmartDoor {
    void open();
}

// Real Subject
class RealSmartDoor implements SmartDoor {
    @Override
    public void open() {
        System.out.println("🚪 Door is opening... Welcome inside!");
    }
}

// Proxy
class SmartDoorProxy implements SmartDoor {
    private RealSmartDoor realDoor;
    private String correctPin = "1234"; // predefined PIN

    public SmartDoorProxy(RealSmartDoor realDoor) {
        this.realDoor = realDoor;
    }

    @Override
    public void open() {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Enter PIN to unlock the Smart Door: ");
        String enteredPin = sc.nextLine();

        if (enteredPin.equals(correctPin)) {
            System.out.println(" Access Granted!");
            realDoor.open();
        } else {
            System.out.println(" Access Denied! Wrong PIN.");
        }
    }
}

// Client
public class sdoor {
    public static void main(String[] args) {
        SmartDoorProxy proxyDoor = new SmartDoorProxy(new RealSmartDoor());
        proxyDoor.open();
    }
}
