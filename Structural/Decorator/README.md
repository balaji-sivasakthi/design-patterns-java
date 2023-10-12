# Decorator Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)
- [Usage](#usage)

## Introduction

This project provides an example implementation of the Decorator design pattern in Java. The Decorator pattern is a
structural design pattern that allows behavior to be added to individual objects, either statically or dynamically,
without affecting the behavior of other objects from the same class. It promotes the open-closed principle, enabling the
addition of new functionality without altering existing code.

## Motivation

The Decorator design pattern is beneficial when:

- You want to add new responsibilities to objects dynamically and transparently.
- You need to extend the behavior of objects without subclassing.
- You aim to keep classes open for extension but closed for modification.

This pattern is particularly useful for enhancing the behavior of objects without creating an excessive number of
subclasses.

## Real-World Example

**Scenario**: In a coffee shop application, you have a base beverage (e.g., coffee) that customers can order. You want
to allow customers to customize their beverage with various add-ons (e.g., milk, sugar, syrup) while keeping the base
beverage price intact. The Decorator pattern helps achieve this customization without creating a class for each
combination of add-ons.

```java
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
```