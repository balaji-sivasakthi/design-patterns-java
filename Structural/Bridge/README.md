# User Interface Framework with Bridge Pattern

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Usage](#usage)
- [Real-World Example](#real-world-example)

## Introduction

This project showcases the Bridge design pattern in the development of a user interface framework. The Bridge pattern
separates the abstraction of user interface components (e.g., buttons, text fields) from their concrete
implementations (e.g., Windows, macOS). It enables flexibility and reusability when creating UI components that can work
on different platforms.

## Motivation

The Bridge design pattern is beneficial when:

- You want to develop a user interface framework that works on multiple platforms (Windows, macOS, Linux, etc.).
- You need to support various UI component types (buttons, text fields, checkboxes) that can work with different
  platforms.
- You want to avoid a combinatorial explosion of classes (e.g., a class for every UI component on every platform).

This pattern simplifies the development of a UI framework by separating the abstraction (UI components) from their
concrete implementations (platform-specific behavior).

## Usage

To use the Bridge pattern in your project, follow these steps:

1. Identify the need for a user interface framework with multiple platforms and UI component types.
2. Create an abstraction interface or abstract class that defines the methods expected by UI components.
3. Create concrete implementation classes for each platform (e.g., WindowsUI, MacOSUI) that implement the
   platform-specific behavior for UI components.
4. Create concrete UI component classes that extend the abstraction and maintain a reference to an implementation
   object.
5. In the concrete UI component classes, delegate calls to the implementation object for platform-specific behavior.

Example code is provided in the "Real-World Example" section below.

## Real-World Example

**Scenario**: In this project, we're developing a user interface framework that works on different platforms (Windows
and macOS) and supports various UI components (buttons, text fields).

```java
// UI Abstraction
interface UIComponent {
    void draw();
    void onClick();
}

// UI Implementor
interface UIPlatform {
    void drawButton();
    void drawTextField();
    void onClick();
}

// Concrete UI Implementors for Windows and macOS
class WindowsUI implements UIPlatform {
    public void drawButton() {
        System.out.println("Drawing Windows button");
    }

    public void drawTextField() {
        System.out.println("Drawing Windows text field");
    }

    public void onClick() {
        System.out.println("Handling Windows click event");
    }
}

class MacOSUI implements UIPlatform {
    public void drawButton() {
        System.out.println("Drawing macOS button");
    }

    public void drawTextField() {
        System.out.println("Drawing macOS text field");
    }

    public void onClick() {
        System.out.println("Handling macOS click event");
    }
}

// Concrete UI Components
class Button implements UIComponent {
    private UIPlatform platform;

    Button(UIPlatform platform) {
        this.platform = platform;
    }

    public void draw() {
        platform.drawButton();
    }

    public void onClick() {
        platform.onClick();
    }
}

class TextField implements UIComponent {
    private UIPlatform platform;

    TextField(UIPlatform platform) {
        this.platform = platform;
    }

    public void draw() {
        platform.drawTextField();
    }

    public void onClick() {
        platform.onClick();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        UIPlatform windowsUI = new WindowsUI();
        UIPlatform macosUI = new MacOSUI();

        UIComponent windowsButton = new Button(windowsUI);
        UIComponent macosTextField = new TextField(macosUI);

        windowsButton.draw();
        windowsButton.onClick();

        macosTextField.draw();
        macosTextField.onClick();
    }
}
