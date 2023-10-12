# Chain of Responsibility Design Pattern Example

## Table of Contents
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)


## Introduction

This project provides an example implementation of the Chain of Responsibility design pattern in Java. The Chain of Responsibility pattern is a behavioral design pattern that allows you to pass requests along a chain of handlers. Each handler decides either to process the request or pass it to the next handler in the chain. This pattern promotes loose coupling and flexibility in handling requests.

## Motivation

The Chain of Responsibility design pattern is beneficial when:

- You have a series of handlers that need to process requests in a specific order.
- You want to avoid hardcoding the processing logic in the sender of the request.
- You need to decouple the sender from the receiver.
- You aim to provide multiple objects with an opportunity to handle a request.

This pattern simplifies the design and makes it easy to add, modify, or remove handlers without affecting the client code.

## Real-World Example

**Scenario**: In an order processing system, you have a series of handlers for order validation, discount calculation, and order confirmation. The Chain of Responsibility pattern can be used to process an order through this chain of handlers.

```java
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
```