# Abstract Factory Design Pattern Example - UI Library

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Usage](#usage)
- [Real-Time Example](#real-time-example)

## Introduction

This project provides an example implementation of the Abstract Factory design pattern in Java. The Abstract Factory is
a creational design pattern that provides an interface for creating families of related or dependent objects without
specifying their concrete classes. In this example, we demonstrate how to use the Abstract Factory pattern to create a
user interface library that supports different themes while maintaining a consistent look and feel.

## Motivation

The Abstract Factory design pattern is useful when:

- A system needs to be configured with multiple families of objects.
- Objects must be created with a common theme or style.
- A system should be independent of how its UI elements are created and presented.

This pattern allows for the creation of families of objects that are consistent and can be easily switched, providing a
flexible and maintainable solution for building complex systems.

## Usage

To use the Abstract Factory pattern in your project, follow these steps:

1. Create one or more interfaces or abstract classes representing the abstract factory. These interfaces should declare
   methods for creating various abstract products.
2. Implement concrete factories that provide specific implementations for the abstract products. Each concrete factory
   should implement the abstract factory interface.
3. Define one or more interfaces or abstract classes for the abstract products.
4. Implement concrete product classes that extend the abstract product interfaces.
5. In the client code, use the abstract factory to create families of related objects, ensuring a consistent theme or
   style. The client should interact with the abstract factory and abstract products without knowledge of their concrete
   implementations.

Example code is provided in the "Real-Time Example" section below.

## Real-Time Example

**Scenario**: This project provides a user interface library that allows developers to create consistent UI elements
with different themes (light and dark). Here's how to use the Abstract Factory pattern in your project:

```java
// Abstract Factory interface
interface UIAbstractFactory {
    Button createButton();

    Checkbox createCheckbox();
}

// Concrete Factory 1: Light Theme Factory
class LightThemeFactory implements UIAbstractFactory {
    public Button createButton() {
        return new LightButton();
    }

    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

// Concrete Factory 2: Dark Theme Factory
class DarkThemeFactory implements UIAbstractFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

// Abstract Product: Button
interface Button {
    void render();
}

// Concrete Products for Light Theme
class LightButton implements Button {
    public void render() {
        System.out.println("Rendering a light button");
    }
}

// Concrete Products for Dark Theme
class DarkButton implements Button {
    public void render() {
        System.out.println("Rendering a dark button");
    }
}

// Abstract Product: Checkbox
interface Checkbox {
    void render();
}

// Concrete Products for Light Theme
class LightCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering a light checkbox");
    }
}

// Concrete Products for Dark Theme
class DarkCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering a dark checkbox");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        UIAbstractFactory factory = new LightThemeFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render(); // Output: Rendering a light button
        checkbox.render(); // Output: Rendering a light checkbox

        factory = new DarkThemeFactory();

        button = factory.createButton();
        checkbox = factory.createCheckbox();

        button.render(); // Output: Rendering a dark button
        checkbox.render(); // Output: Rendering a dark checkbox
    }
}

```
