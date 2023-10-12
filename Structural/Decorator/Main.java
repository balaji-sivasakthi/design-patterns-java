package Structural.Decorator;

// Component (Beverage)
interface Beverage {
    double cost();
    String description();
}

// Concrete Component (Base Beverage)
class Coffee implements Beverage {
    public double cost() {
        return 2.0;
    }

    public String description() {
        return "Coffee";
    }
}

// Decorator (Add-On)
abstract class AddOnDecorator implements Beverage {
    private Beverage beverage;

    AddOnDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost();
    }

    public String description() {
        return beverage.description();
    }
}

// Concrete Decorators (Milk, Sugar, Syrup)
class MilkDecorator extends AddOnDecorator {
    MilkDecorator(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return super.cost() + 0.5;
    }

    public String description() {
        return super.description() + ", Milk";
    }
}

class SugarDecorator extends AddOnDecorator {
    SugarDecorator(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return super.cost() + 0.2;
    }

    public String description() {
        return super.description() + ", Sugar";
    }
}

class SyrupDecorator extends AddOnDecorator {
    SyrupDecorator(Beverage beverage) {
        super(beverage);
    }

    public double cost() {
        return super.cost() + 0.3;
    }

    public String description() {
        return super.description() + ", Syrup";
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Beverage coffee = new Coffee();
        Beverage coffeeWithMilk = new MilkDecorator(coffee);
        Beverage coffeeWithMilkAndSugar = new SugarDecorator(coffeeWithMilk);

        System.out.println("Order: " + coffeeWithMilkAndSugar.description());
        System.out.println("Total Cost: $" + coffeeWithMilkAndSugar.cost());
    }
}