# Power Adapter Simulation with Adapter Pattern

## Table of Contents
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Usage](#usage)
- [Real-World Example](#real-world-example)

## Introduction

This project demonstrates the Adapter design pattern in a real-world scenario by simulating the use of power adapters for electrical devices in different countries. The Adapter pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate, just like electrical devices that need different power adapters to work in different countries.

## Motivation

The Adapter design pattern is useful when:

- You have electrical devices designed for one country's power supply (the "adaptee").
- You want to use these devices in another country with a different power supply (the "target").
- You need a way to adapt the device's power input to the power supply in the target country.
- You want to maintain a consistent interface for using different devices in different countries.

This pattern simplifies the process of making devices compatible with varying power supplies.

## Usage

To use the Adapter pattern in your project, follow these steps:

1. Identify the existing device with an incompatible power input (the "adaptee").
2. Create an adapter class that implements the interface expected by the device (the "target").
3. Inside the adapter class, delegate the power input conversion to the methods of the adaptee.
4. Use the adapter class to make the device work seamlessly with different power supplies in various countries.

Example code is provided in the "Real-World Example" section below.

## Real-World Example

**Scenario**: In this simulation, we have electrical devices (adaptees) designed to work with the power supply in a specific country. Users need to adapt these devices to work in various countries with different power supplies (targets).

```java
// Target interface for power input
interface Target {
    void plugIntoPowerSupply();
}

// Adaptee (device with specific power input)
class Device {
    void specificPowerInput() {
        System.out.println("Device with specific power input is plugged in.");
    }
}

// Adapter class to adapt the device to a different power supply
class PowerAdapter implements Target {
    private Device device;

    PowerAdapter(Device device) {
        this.device = device;
    }

    public void plugIntoPowerSupply() {
        // Convert the power input for the device
        device.specificPowerInput();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Device device = new Device();
        Target target = new PowerAdapter(device);

        // Use the device with the adapter in different countries
        target.plugIntoPowerSupply();
    }
}
