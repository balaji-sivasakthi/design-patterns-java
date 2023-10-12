# Builder Pattern Example

## Table of Contents
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Usage](#usage)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Builder design pattern in Java to create complex "Order" objects. The Builder pattern is a creational design pattern that separates the construction of a complex object from its representation. It simplifies the creation of complex objects with multiple attributes and options.

## Motivation

The Builder design pattern is useful when:

- You need to create complex objects with many optional attributes.
- You want to improve the readability and maintainability of code when working with object construction.
- You need to ensure the immutability of objects once they are created.

This pattern allows for flexible and fluent object construction, making it easier to work with complex objects in real-world scenarios.

## Usage

To use the Builder pattern in your project, follow these steps:

1. Create a `Director` class, responsible for orchestrating the construction of complex objects.
2. Define an `AbstractBuilder` interface with methods for constructing the different attributes of the object.
3. Create one or more concrete builder classes that implement the `AbstractBuilder` interface to construct the object step by step.
4. Create a `Product` class to represent the complex object.
5. Use the `Director` and concrete builders to construct the `Product` object in a controlled and understandable way.

Example code is provided in the "Real-World Example" section below.


## Real-World Example

**Scenario**: This project demonstrates how to use the Builder pattern to create detailed "Order" objects. Orders can have multiple attributes, including customer information, product details, shipping options, and payment information.

```java
// Director
class OrderDirector {
    private OrderBuilder builder;

    public OrderDirector(OrderBuilder builder) {
        this.builder = builder;
    }

    public Order construct() {
        builder.setCustomer("John Doe")
            .addProduct("Product A", 2)
            .addProduct("Product B", 1)
            .setShippingAddress("123 Main St")
            .setPaymentMethod("Credit Card");
        return builder.build();
    }
}

// Abstract Builder
interface OrderBuilder {
    OrderBuilder setCustomer(String customerName);
    OrderBuilder addProduct(String productName, int quantity);
    OrderBuilder setShippingAddress(String address);
    OrderBuilder setPaymentMethod(String paymentMethod);
    Order build();
}

// Concrete Builder
class ConcreteOrderBuilder implements OrderBuilder {
    private Order order;

    public ConcreteOrderBuilder() {
        this.order = new Order();
    }

    public OrderBuilder setCustomer(String customerName) {
        order.setCustomerName(customerName);
        return this;
    }

    public OrderBuilder addProduct(String productName, int quantity) {
        order.addProduct(productName, quantity);
        return this;
    }

    public OrderBuilder setShippingAddress(String address) {
        order.setShippingAddress(address);
        return this;
    }

    public OrderBuilder setPaymentMethod(String paymentMethod) {
        order.setPaymentMethod(paymentMethod);
        return this;
    }

    public Order build() {
        return order;
    }
}

// Product
class Order {
    private String customerName;
    private Map<String, Integer> products;
    private String shippingAddress;
    private String paymentMethod;

    // Constructor, getters, and setters for attributes.

    public String toString() {
        // Generate a detailed order summary.
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        OrderBuilder builder = new ConcreteOrderBuilder();
        OrderDirector director = new OrderDirector(builder);

        Order order = director.construct();
        System.out.println(order.toString());
    }
}
