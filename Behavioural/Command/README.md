# Command Design Pattern Example

## Table of Contents
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Command design pattern in Java. The Command pattern is a behavioral design pattern that encapsulates a request as an object, allowing for parameterization of clients with requests and operations. It provides a way to decouple the sender of a request from its receiver and supports undoable operations.

## Motivation

The Command design pattern is beneficial when:

- You want to decouple the sender of a request from its receiver.
- You need to parameterize clients with queues, requests, and operations.
- You aim to support undoable operations and logging.
- You want to implement the callback mechanism.

This pattern provides a flexible and extensible way to manage commands and operations in an application.

## Real-World Example

**Scenario**: In a home automation system, you have various devices like lights, fans, and thermostats that you want to control through a remote control. The Command pattern can be used to encapsulate the commands for turning these devices on and off, allowing undoable operations.

```java
// Command interface
interface Command {
    void execute();
    void undo();
}

// Concrete Command
class LightOnCommand implements Command {
    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}

// Receiver
class Light {
    void turnOn() {
        System.out.println("Light is on");
    }

    void turnOff() {
        System.out.println("Light is off");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOn);

        remoteControl.pressButton();  // Turns the light on
    }
}
```