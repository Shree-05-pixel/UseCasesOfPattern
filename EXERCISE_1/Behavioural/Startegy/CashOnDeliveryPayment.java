package Startegy;

public class CashOnDeliveryPayment implements PaymentStrategy {
    @Override
    public void pay(double amount) {
        System.out.println("Order placed with Cash on Delivery. Pay Rs." + amount + " on delivery.");
    }
}