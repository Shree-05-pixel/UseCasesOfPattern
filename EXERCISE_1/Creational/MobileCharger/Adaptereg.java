package EXERCISE_1.Creational.MobileCharger;

import java.util.Scanner;

// Target Interface
interface MobileCharger {
    void charge();
}

// Adaptee 1
class SamsungCharger {
    void samsungCharge() {
        System.out.println(" Charging Samsung phone using Samsung port...");
    }
}

// Adaptee 2
class IphoneCharger {
    void iphoneCharge() {
        System.out.println(" Charging iPhone using Lightning port...");
    }
}

// Adaptee 3
class OnePlusCharger {
    void oneplusCharge() {
        System.out.println("Charging OnePlus phone using Type-C port...");
    }
}

// Adapter
class UniversalChargerAdapter implements MobileCharger {
    private Object phone;

    public UniversalChargerAdapter(Object phone) {
        this.phone = phone;
    }

    @Override
    public void charge() {
        if (phone instanceof SamsungCharger) {
            ((SamsungCharger) phone).samsungCharge();
        } else if (phone instanceof IphoneCharger) {
            ((IphoneCharger) phone).iphoneCharge();
        } else if (phone instanceof OnePlusCharger) {
            ((OnePlusCharger) phone).oneplusCharge();
        } else {
            System.out.println(" Unknown phone type!");
        }
    }
}

// Client
public class Adaptereg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Enter your phone brand (Samsung / iPhone / OnePlus): ");
        String choice = sc.nextLine().toLowerCase();

        MobileCharger charger;

        switch (choice) {
            case "samsung":
                charger = new UniversalChargerAdapter(new SamsungCharger());
                break;
            case "iphone":
                charger = new UniversalChargerAdapter(new IphoneCharger());
                break;
            case "oneplus":
                charger = new UniversalChargerAdapter(new OnePlusCharger());
                break;
            default:
                System.out.println(" Invalid choice!");
                return;
        }

        charger.charge();
    }
}

