# Facade Design Pattern Example

## Table of Contents
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)
- [Usage](#usage)
- [Examples](#examples)

## Introduction

This project provides an example implementation of the Facade design pattern in Java. The Facade pattern is a structural design pattern that provides a simplified interface to a set of interfaces in a subsystem. It offers a unified, higher-level interface to make it easier for clients to interact with the subsystem while hiding its complexity.

## Motivation

The Facade design pattern is beneficial when:

- You have a complex subsystem with many interrelated components.
- You want to provide a simple and unified interface to the subsystem.
- You aim to decouple clients from the subsystem's internal details.
- You need to make the subsystem more understandable and easy to use.

This pattern simplifies the interaction with complex systems and promotes loose coupling.

## Real-World Example

**Scenario**: In a home theater system, you have various devices such as a DVD player, amplifier, projector, and screen. To watch a movie, you need to perform multiple operations on these devices, like turning them on, setting input sources, and adjusting volumes. The Facade pattern can simplify this process.

```java
// Subsystem components
class DVDPlayer {
    void on() { /* Implementation */ }
    void play(String movie) { /* Implementation */ }
    void stop() { /* Implementation */ }
}

class Amplifier {
    void on() { /* Implementation */ }
    void setSurroundSound() { /* Implementation */ }
    void setVolume(int volume) { /* Implementation */ }
}

class Projector {
    void on() { /* Implementation */ }
    void setInput(DVDPlayer dvdPlayer) { /* Implementation */ }
    void wideScreenMode() { /* Implementation */ }
}

class Screen {
    void down() { /* Implementation */ }
    void up() { /* Implementation */ }
}

// Facade
class HomeTheaterFacade {
    private DVDPlayer dvdPlayer;
    private Amplifier amplifier;
    private Projector projector;
    private Screen screen;

    HomeTheaterFacade(DVDPlayer dvdPlayer, Amplifier amplifier, Projector projector, Screen screen) {
        this.dvdPlayer = dvdPlayer;
        this.amplifier = amplifier;
        this.projector = projector;
        this.screen = screen;
    }

    void watchMovie(String movie) {
        System.out.println("Get ready to watch a movie...");
        screen.down();
        projector.on();
        projector.setInput(dvdPlayer);
        amplifier.on();
        amplifier.setSurroundSound();
        amplifier.setVolume(7);
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    void endMovie() {
        System.out.println("Shutting down the movie...");
        dvdPlayer.stop();
        dvdPlayer.on();
        screen.up();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        DVDPlayer dvdPlayer = new DVDPlayer();
        Amplifier amplifier = new Amplifier();
        Projector projector = new Projector();
        Screen screen = new Screen();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvdPlayer, amplifier, projector, screen);

        homeTheater.watchMovie("The Matrix");
        homeTheater.endMovie();
    }
}
```