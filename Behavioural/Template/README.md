# Template Method Design Pattern Example

## Table of Contents
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Template Method design pattern in Java. The Template Method pattern is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure. It's useful for creating a common algorithm structure with room for variations.

## Motivation

The Template Method design pattern is beneficial when:

- You have an algorithm that can be divided into common and specific steps.
- You want to define the common algorithm structure in the superclass and let subclasses provide their own implementations for specific steps.
- You aim to avoid code duplication by reusing the common algorithm in multiple subclasses.
- You need to ensure that certain steps in the algorithm are followed in a specific order.

This pattern is useful when you want to create a consistent algorithm structure while allowing for customization in certain parts of the algorithm.

## Real-World Example

**Scenario**: In a document generation application, you want to provide different document types (e.g., PDF, HTML) that follow a common structure but have variations in the rendering format. The Template Method pattern can be used to define the common structure for document generation and allow subclasses to implement rendering in their specific format.

```java
// Abstract class with template method
abstract class DocumentGenerator {
    // Template method that defines the common algorithm structure
    public void generateDocument() {
        createHeader();
        createContent();
        createFooter();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void createHeader();
    protected abstract void createContent();
    protected abstract void createFooter();
}

// Concrete subclasses with specific implementations
class PdfDocumentGenerator extends DocumentGenerator {
    protected void createHeader() {
        System.out.println("PDF Header");
    }

    protected void createContent() {
        System.out.println("PDF Content");
    }

    protected void createFooter() {
        System.out.println("PDF Footer");
    }
}

class HtmlDocumentGenerator extends DocumentGenerator {
    protected void createHeader() {
        System.out.println("HTML Header");
    }

    protected void createContent() {
        System.out.println("HTML Content");
    }

    protected void createFooter() {
        System.out.println("HTML Footer");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        DocumentGenerator pdfGenerator = new PdfDocumentGenerator();
        DocumentGenerator htmlGenerator = new HtmlDocumentGenerator();

        System.out.println("Generating PDF document:");
        pdfGenerator.generateDocument();

        System.out.println("\nGenerating HTML document:");
        htmlGenerator.generateDocument();
    }
}
```