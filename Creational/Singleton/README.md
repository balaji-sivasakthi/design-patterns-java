# Singleton Pattern in Java

## Table of Contents
- [Introduction](#introduction)
- [Purpose](#purpose)
- [Implementation](#implementation)
    - [Classic Singleton](#classic-singleton)
    - [Thread-Safe Singleton](#thread-safe-singleton)
- [Usage](#usage)
- [Best Practices](#best-practices)

## Introduction

The Singleton Pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance. It is widely used when you want to control access to a shared resource or ensure that only one object of a particular class exists throughout your application's lifecycle.

## Purpose

The purpose of this project is to provide a simple implementation of the Singleton Pattern in Java and demonstrate its usage and best practices.

## Implementation

### Classic Singleton

In the classic Singleton pattern, we have a private constructor and a static method to get the single instance. Here's how it's implemented:

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() { }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
```

### Thread-Safe Singleton

To make the Singleton thread-safe, you can use double-check locking. Here's the implementation:

```java
public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() { }

    public static ThreadSafeSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
}
```

## Usage

To use the Singleton pattern in your Java application:

```java
// Create a Singleton instance
Singleton singleton = Singleton.getInstance();

// For the thread-safe version:
ThreadSafeSingleton threadSafeSingleton = ThreadSafeSingleton.getInstance();
```

## Best Practices

- Use the Singleton pattern judiciously. Overusing it can lead to tightly coupled code.
- Consider using the `enum` approach for Singleton as it handles lazy initialization and thread-safety effectively.
- Keep the Singleton class's responsibilities focused on managing its instance rather than performing other unrelated tasks.

