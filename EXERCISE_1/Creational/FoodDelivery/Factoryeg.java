package FoodDelivery;

import java.util.Scanner;

// Product Interface
interface Food {
    void prepare();
}

// Concrete Products
class IndianFood implements Food {
    @Override
    public void prepare() {
        System.out.println(" Preparing spicy Indian Thali...");
    }
}

class ChineseFood implements Food {
    @Override
    public void prepare() {
        System.out.println(" Preparing delicious Chinese Noodles...");
    }
}

class ItalianFood implements Food {
    @Override
    public void prepare() {
        System.out.println(" Preparing cheesy Italian Pizza...");
    }
}

// Factory Class
class FoodFactory {
    public static Food getFood(String choice) {
        switch (choice.toLowerCase()) {
            case "indian":
                return new IndianFood();
            case "chinese":
                return new ChineseFood();
            case "italian":
                return new ItalianFood();
            default:
                return null;
        }
    }
}

// Client
public class Factoryeg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("🍴 Welcome to Food Delivery App!");
        System.out.println("Enter cuisine (Indian / Chinese / Italian): ");
        String choice = sc.nextLine();

        Food food = FoodFactory.getFood(choice);

        if (food != null) {
            food.prepare();
        } else {
            System.out.println(" Sorry, we don't serve that cuisine yet!");
        }
    }
}
