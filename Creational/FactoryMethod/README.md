# Factory Method Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Usage](#usage)
- [Examples](#examples)

## Introduction

This project provides an example implementation of the Factory Method design pattern in Java. The Factory Method is a
creational design pattern that defines an interface for creating objects but allows subclasses to alter the type of
objects that will be created. In this example, we demonstrate how to use the Factory Method to create objects of
different types while ensuring that the client code remains decoupled from the specific object creation logic.

## Motivation

The Factory Method design pattern is useful when:

- A class cannot anticipate the type of objects it needs to create.
- A class wants to delegate the responsibility of object creation to its subclasses.
- A class needs to be decoupled from the classes it instantiates.

This pattern allows for greater flexibility and extensibility in object creation.

## Usage

To use the Factory Method pattern in your project, follow these steps:

1. Create an interface or an abstract class (the Creator) with a method for creating objects.
2. Implement concrete Creator classes that extend the Creator and provide specific implementations for creating objects.
3. Define an interface or an abstract class for the product that the Creator will create.
4. Create concrete product classes that implement the product interface.
5. In the client code, use the Creator to create objects, but without knowing the specific subclass that is being
   instantiated.

Example code is provided in the "Examples" section below.

## Examples

Here's a simple Java example of the Factory Method pattern:

```java
// Define the Creator interface
interface Creator {
    Product factoryMethod();
}

// Implement concrete Creator classes
class ConcreteCreatorA implements Creator {
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB implements Creator {
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Define the Product interface
interface Product {
    void display();
}

// Implement concrete Product classes
class ConcreteProductA implements Product {
    public void display() {
        System.out.println("Product A");
    }
}

class ConcreteProductB implements Product {
    public void display() {
        System.out.println("Product B");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();
        productA.display();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();
        productB.display();
    }
}
```
