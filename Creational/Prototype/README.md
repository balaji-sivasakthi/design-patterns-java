# Graphics Editor with Prototype Pattern

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Usage](#usage)
- [Real-Time Example](#real-time-example)

## Introduction

This project provides a simplified graphics editor that utilizes the Prototype design pattern in Java. The Prototype
pattern allows users to create and edit complex shapes and objects by cloning existing objects (prototypes) and making
modifications to them. This approach simplifies the creation and customization of graphic elements.

## Motivation

The Prototype design pattern is useful in a graphics editor when:

- Users need to create objects with similar properties and behaviors.
- Creating new graphic elements from scratch is cumbersome and inefficient.
- Users want to maintain the immutability of prototypes while dynamically modifying copies.

This pattern supports efficient object creation and customization in real-time graphics editing.

## Usage

To use the Prototype pattern in your project, follow these steps:

1. Create a prototype interface or abstract class that defines a method for cloning objects.
2. Implement concrete prototype classes for various graphic elements, each with a `clone` method.
3. In your graphics editor, allow users to select and clone existing graphic elements as prototypes.
4. Enable users to modify properties and behaviors of cloned elements.

Example code is provided in the "Real-Time Example" section below.

## Real-Time Example

**Scenario**: This graphics editor allows users to create and edit graphic elements using the Prototype pattern. Users
can select and clone existing graphic prototypes, making it easy to design and customize graphics.

```java
package Creational.Prototype;

// Prototype interface for graphic elements
interface GraphicPrototype {
    GraphicPrototype clone();

    void draw();

    void setAttributes(String attributes);
}

// Concrete Graphic prototypes
class Circle implements GraphicPrototype {
    private String attributes;

    Circle(String attributes) {
        this.attributes = attributes;
    }

    public GraphicPrototype clone() {
        return new Circle(this.attributes);
    }

    public void draw() {
        // Draw a circle with the specified attributes.
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}

class Rectangle implements GraphicPrototype {
    private String attributes;

    Rectangle(String attributes) {
        this.attributes = attributes;
    }

    public GraphicPrototype clone() {
        return new Rectangle(this.attributes);
    }

    public void draw() {
        // Draw a rectangle with the specified attributes.
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}

// Graphics Editor
public class GraphicsEditor {
    public static void main(String[] args) {
        GraphicPrototype circlePrototype = new Circle("red, radius=10");
        GraphicPrototype rectanglePrototype = new Rectangle("blue, width=20, height=30");

        // User clones and customizes graphic elements
        GraphicPrototype customCircle = circlePrototype.clone();
        customCircle.setAttributes("green, radius=15");

        GraphicPrototype customRectangle = rectanglePrototype.clone();
        customRectangle.setAttributes("yellow, width=25, height=40");

        // User can draw and manipulate customized graphic elements
        customCircle.draw();
        customRectangle.draw();
    }
}
```
