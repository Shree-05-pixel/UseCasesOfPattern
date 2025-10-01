package EXERCISE_1.Behavioural.Startegy;

import java.util.Scanner;



public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.println("Enter amount to pay: ");
        int amount = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.println("Choose payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.println("3. Cash on Delivery");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Credit Card Number: ");
                String card = scanner.nextLine();
                context.setPaymentStrategy(new CreditCardPayment(card));
                break;

            case 2:
                System.out.print("Enter UPI ID: ");
                String upi = scanner.nextLine();
                context.setPaymentStrategy(new UPIPayment(upi));
                break;

            case 3:
                context.setPaymentStrategy(new CashOnDeliveryPayment());
                break;

            default:
                System.out.println("Invalid choice");
                return;
        }

        context.payAmount(amount);
        scanner.close();
    }
}

