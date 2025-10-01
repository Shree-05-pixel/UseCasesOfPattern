package EXERCISE_1.Behavioural.Startegy;
 import java.util.Scanner;

public class UPIPayment implements PaymentStrategy {
    private String upiId;

    public UPIPayment(String upiId) {   //  added constructor
        this.upiId = upiId;
    }
    @Override
    public void pay(double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter UPI ID: ");
        String upiId = sc.nextLine();
        System.out.println(" Payment of Rs." + amount + " done via UPI (" + upiId + ")");
    }
}
