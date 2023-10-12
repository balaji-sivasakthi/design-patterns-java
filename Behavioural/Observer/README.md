# Observer Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Observer design pattern in Java. The Observer pattern is a
behavioral design pattern that defines a one-to-many dependency between objects so that when one object changes state,
all its dependents are notified and updated automatically. It is used to implement distributed event handling systems
and maintain consistent states in a system.

## Motivation

The Observer design pattern is beneficial when:

- You need to maintain a consistent state between objects when one object's state changes.
- You want to implement a distributed event handling system.
- You need to notify multiple objects when a change in state occurs.
- You aim to decouple the sender and receiver of notifications.

This pattern simplifies the process of notifying and updating dependent objects and promotes loose coupling between
them.

## Real-World Example

**Scenario**: In a weather monitoring system, you have multiple displays that need to show the current weather
conditions. When the weather changes, all displays should be updated. The Observer pattern can be used to implement this
system.

```java
import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

// Concrete subject
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer interface
interface Observer {
    void update(float temperature);
}

// Concrete observer
class TemperatureDisplay implements Observer {
    private float temperature;

    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    private void display() {
        System.out.println("Temperature Display: " + temperature + "°C");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        TemperatureDisplay temperatureDisplay = new TemperatureDisplay();

        weatherStation.registerObserver(temperatureDisplay);

        // Simulate a change in temperature
        weatherStation.setTemperature(25.5f);
    }
}
```