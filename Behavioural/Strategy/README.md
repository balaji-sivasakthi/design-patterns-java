# Strategy Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Strategy design pattern in Java. The Strategy pattern is a
behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. It
allows the client to choose the appropriate algorithm at runtime without altering its context.

## Motivation

The Strategy design pattern is beneficial when:

- You have a set of related algorithms or behaviors that need to be used interchangeably.
- You want to decouple the client from the specific algorithm implementations.
- You need to avoid code duplication by encapsulating the algorithm implementations.
- You aim to provide flexibility to change or extend algorithms without modifying the client.

This pattern is particularly useful when you have a task that can be accomplished in multiple ways, and you want to make
those ways pluggable and switchable.

## Real-World Example

**Scenario**: In a sorting application, you want to provide multiple sorting algorithms (e.g., bubble sort, merge sort,
quicksort) that the user can choose from. The Strategy pattern can be used to encapsulate each sorting algorithm as a
strategy and allow the user to select the desired strategy at runtime.

```java
// Strategy interface
interface SortingStrategy {
    void sort(int[] data);
}

// Concrete strategies
class BubbleSort implements SortingStrategy {
    public void sort(int[] data) {
        // Implementation of bubble sort
        System.out.println("Sorting using Bubble Sort");
    }
}

class MergeSort implements SortingStrategy {
    public void sort(int[] data) {
        // Implementation of merge sort
        System.out.println("Sorting using Merge Sort");
    }
}

class QuickSort implements SortingStrategy {
    public void sort(int[] data) {
        // Implementation of quicksort
        System.out.println("Sorting using QuickSort");
    }
}

// Context
class SortingContext {
    private SortingStrategy strategy;

    SortingContext(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    void executeSort(int[] data) {
        strategy.sort(data);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        int[] data = {5, 2, 8, 9, 1};

        SortingContext context = new SortingContext(new BubbleSort());
        context.executeSort(data); // Sorting using Bubble Sort

        context.setStrategy(new MergeSort());
        context.executeSort(data); // Sorting using Merge Sort
    }
}
```