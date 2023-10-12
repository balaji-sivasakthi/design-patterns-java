# Visitor Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Visitor design pattern in Java. The Visitor pattern is a
behavioral design pattern that allows you to separate the algorithm from the object structure. It enables you to add new
operations to objects without modifying their classes, making it ideal for complex object structures.

## Motivation

The Visitor design pattern is beneficial when:

- You have a complex object structure with various types of elements, and you want to perform different operations on
  these elements.
- You want to avoid modifying the classes of the elements when adding new operations.
- You need to encapsulate operations in separate visitor classes and maintain clean object structures.
- You aim to achieve double dispatch, where the method to execute depends on both the type of the visitor and the type
  of the element.

This pattern is useful when you have a family of classes representing different elements and a set of operations that
you want to perform on those elements.

## Real-World Example

**Scenario**: In a geometry application, you have different shapes (e.g., circles, rectangles) that you want to perform
various operations on (e.g., calculate area, perimeter). The Visitor pattern can be used to create visitor classes for
each operation without modifying the shape classes.

```java
// Element interface
interface Shape {
    void accept(Visitor visitor);
}

// Concrete elements
class Circle implements Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    int getRadius() {
        return radius;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Visitor interface
interface Visitor {
    void visit(Circle circle);

    void visit(Rectangle rectangle);
}

// Concrete visitor
class AreaVisitor implements Visitor {
    double totalArea = 0;

    public void visit(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        totalArea += area;
    }

    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        totalArea += area;
    }

    double getTotalArea() {
        return totalArea;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5), new Rectangle(4, 3)};

        AreaVisitor areaVisitor = new AreaVisitor();

        for (Shape shape : shapes) {
            shape.accept(areaVisitor);
        }

        System.out.println("Total area: " + areaVisitor.getTotalArea());
    }
}
```