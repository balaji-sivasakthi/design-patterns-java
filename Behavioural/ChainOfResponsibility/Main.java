package Behavioural.ChainOfResponsibility;

// Handler interface
interface OrderHandler {
    void processOrder(Order order);
}

// Concrete Handler
class ValidationHandler implements OrderHandler {
    public void processOrder(Order order) {
        System.out.println("Validating order...");
        // Validation logic here
    }
}

// Concrete Handler
class DiscountHandler implements OrderHandler {
    public void processOrder(Order order) {
        System.out.println("Calculating discounts...");
        // Discount calculation logic here
    }
}

// Concrete Handler
class ConfirmationHandler implements OrderHandler {
    public void processOrder(Order order) {
        System.out.println("Confirming order...");
        // Order confirmation logic here
    }
}

// Order class
class Order {
    // Order details
}

// Client code
public class Main {
    public static void main(String[] args) {
        Order order = new Order();

        OrderHandler validationHandler = new ValidationHandler();
        OrderHandler discountHandler = new DiscountHandler();
        OrderHandler confirmationHandler = new ConfirmationHandler();

        validationHandler.processOrder(order);
        discountHandler.processOrder(order);
        confirmationHandler.processOrder(order);
    }
}