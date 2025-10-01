package EXERCISE_1.Behavioural.Startegy;

public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Allow client to set strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void payAmount(int amount) {
        if (paymentStrategy == null) {
            System.out.println("Please select a payment method first!");
        } else {
            paymentStrategy.pay(amount);
        }
    }
}
