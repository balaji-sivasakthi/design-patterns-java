# State Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the State design pattern in Java. The State pattern is a behavioral
design pattern that allows an object to alter its behavior when its internal state changes. It enables the object to
appear as if it changes its class based on its state.

## Motivation

The State design pattern is beneficial when:

- You have an object that can have multiple states, and its behavior needs to change dynamically based on those states.
- You want to avoid long, complex conditional statements that check the object's state.
- You need to simplify the code and improve maintainability by encapsulating state-specific behavior.
- You aim to ensure that the object's state transitions are well-defined.

This pattern is useful when dealing with objects that have a finite number of well-defined states and transitions
between them.

## Real-World Example

**Scenario**: In a traffic signal management system, you have traffic lights at intersections that can be in different
states (e.g., green, yellow, red). The State pattern can be used to model the behavior of traffic lights, where the
behavior changes based on the current state.

```java
// State interface
interface TrafficLightState {
    void handleRequest();
}

// Concrete states
class RedLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Changing to green...");
    }
}

class GreenLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Changing to yellow...");
    }
}

class YellowLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Changing to red...");
    }
}

// Context
class TrafficLight {
    private TrafficLightState currentState;

    TrafficLight() {
        currentState = new RedLightState();
    }

    void setState(TrafficLightState state) {
        currentState = state;
    }

    void change() {
        currentState.handleRequest();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.change(); // Changing to green...
        trafficLight.setState(new GreenLightState());
        trafficLight.change(); // Changing to yellow...
        trafficLight.setState(new YellowLightState());
        trafficLight.change(); // Changing to red...
    }
}
```