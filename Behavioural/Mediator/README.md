# Mediator Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Mediator design pattern in Java. The Mediator pattern is a
behavioral design pattern that promotes loose coupling among a set of objects by centralizing their communications
through a mediator object. It is used to simplify complex relationships and interactions between objects.

## Motivation

The Mediator design pattern is beneficial when:

- You have a set of objects that need to communicate and collaborate, but you want to avoid the direct coupling between
  them.
- You need to centralize control and logic related to the interactions between objects.
- You aim to reduce the complexity and dependencies in your system.
- You want to encapsulate the interactions between objects in a single component.

This pattern simplifies the interactions between objects and makes the system more maintainable and flexible.

## Real-World Example

**Scenario**: In an air traffic control system, you have various components such as aircraft, runways, and the control
tower. These components need to communicate and coordinate to ensure the safe takeoff, landing, and routing of aircraft.
The Mediator pattern can be used to centralize the communication and control of these components.

```java
// Mediator interface
interface AirTrafficControl {
    void requestLanding(Aircraft aircraft);

    void requestTakeoff(Aircraft aircraft);
}

// Concrete Mediator
class ControlTower implements AirTrafficControl {
    public void requestLanding(Aircraft aircraft) {
        System.out.println(aircraft.getName() + " is clear to land.");
    }

    public void requestTakeoff(Aircraft aircraft) {
        System.out.println(aircraft.getName() + " is cleared for takeoff.");
    }
}

// Colleague
class Aircraft {
    private String name;
    private AirTrafficControl mediator;

    Aircraft(String name, AirTrafficControl mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    String getName() {
        return name;
    }

    void requestLanding() {
        mediator.requestLanding(this);
    }

    void requestTakeoff() {
        mediator.requestTakeoff(this);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        AirTrafficControl controlTower = new ControlTower();

        Aircraft aircraft1 = new Aircraft("Flight 123", controlTower);
        Aircraft aircraft2 = new Aircraft("Flight 456", controlTower);

        aircraft1.requestLanding();
        aircraft2.requestTakeoff();
    }
}
```