package Startegy;

import java.util.Scanner;

public class Client{
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter amount to pay: ");
        double amount = sc.nextDouble();
        sc.nextLine(); // consume newline

        while (true) {
            System.out.println("\nChoose Payment Method:");
            System.out.println("1. Credit Card");
            System.out.println("2. UPI");
            System.out.println("3. Cash on Delivery");
            System.out.println("4. Exit");

            System.out.print("Your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    context.setPaymentStrategy(new CreditCardPayment());
                    context.checkout(amount);
                    break;

                case "2":
                    context.setPaymentStrategy(new UPIPayment());
                    context.checkout(amount);
                    break;

                case "3":
                    context.setPaymentStrategy(new CashOnDeliveryPayment());
                    context.checkout(amount);
                    break;

                case "4":
                    System.out.println("Thank you for shopping!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}
