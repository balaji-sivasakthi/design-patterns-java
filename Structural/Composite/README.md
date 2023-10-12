# Composite Design Pattern Example - File System

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)
- [Usage](#usage)

## Introduction

This project provides an example implementation of the Composite design pattern in Java using a simplified file system
as a real-world scenario. The Composite pattern is a structural design pattern that allows you to create hierarchical
structures where individual objects and compositions of objects share the same interface. In this example, folders and
files in a file system are treated as components.

## Motivation

The Composite design pattern is ideal for situations where:

- You need to represent part-whole hierarchies, such as a file system with folders and files.
- You want to treat individual objects and compositions of objects uniformly.
- You aim to simplify client code by avoiding complex conditional statements to differentiate between individual and
  composite objects.

This pattern simplifies the design of hierarchical structures and enables recursive composition.

## Real-World Example

**Scenario**: In this project, we emulate a simplified file system structure using the Composite pattern. Folders and
files in the file system are represented as components.

```java
package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

// Component (common interface)
interface FileSystemComponent {
    void display();
}

// Leaf (File)
class File implements FileSystemComponent {
    private final String name;

    File(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("File: " + name);
    }
}

// Composite (Folder)
class Folder implements FileSystemComponent {
    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void display() {
        System.out.println("Folder: " + name);
        for (FileSystemComponent component : components) {
            component.display();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Folder root = new Folder("Root");
        Folder folder1 = new Folder("Folder 1");
        Folder folder2 = new Folder("Folder 2");
        FileSystemComponent file1 = new File("File 1");
        FileSystemComponent file2 = new File("File 2");

        folder1.addComponent(file1);
        folder2.addComponent(file2);
        root.addComponent(folder1);
        root.addComponent(folder2);

        root.display();
    }
}
```