package Startegy;

public class UPIPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter UPI ID: ");
        String upiId = sc.nextLine();
        System.out.println("✅ Payment of Rs." + amount + " done via UPI (" + upiId + ")");
    }
}