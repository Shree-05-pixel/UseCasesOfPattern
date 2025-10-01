package Startegy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Credit Card Number: ");
        String cardNumber = sc.nextLine();
        System.out.print("Enter CVV: ");
        String cvv = sc.nextLine();
        System.out.println(" Payment of Rs." + amount + " done via Credit Card (" + cardNumber + ")");
    }
}