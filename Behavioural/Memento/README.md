# Memento Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Memento design pattern in Java. The Memento pattern is a
behavioral design pattern that allows you to capture and externalize the internal state of an object without violating
encapsulation. It is used for saving and restoring an object's state or implementing undo/redo functionality.

## Motivation

The Memento design pattern is beneficial when:

- You need to capture and save an object's state to implement undo/redo functionality.
- You want to create checkpoints or snapshots of an object's state.
- You need to save an object's state and restore it later.
- You aim to encapsulate an object's internal state without exposing it to clients.

This pattern is useful for applications that require state management, version control, or history tracking.

## Real-World Example

**Scenario**: In a text editor application, you want to provide undo and redo functionality for text changes. The
Memento pattern can be used to capture and save the state of the text editor at different points in time and allow users
to revert to previous states.

```java
// Originator
class TextEditor {
    private String content;

    void setContent(String content) {
        this.content = content;
    }

    String getContent() {
        return content;
    }

    Memento save() {
        return new Memento(content);
    }

    void restore(Memento memento) {
        content = memento.getState();
    }
}

// Memento
class Memento {
    private String state;

    Memento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}

// Caretaker
class History {
    private List<Memento> mementos = new ArrayList<>();

    void save(Memento memento) {
        mementos.add(memento);
    }

    Memento get(int index) {
        return mementos.get(index);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        History history = new History();

        textEditor.setContent("First text");
        history.save(textEditor.save());

        textEditor.setContent("Modified text");
        history.save(textEditor.save());

        textEditor.setContent("Latest text");
        history.save(textEditor.save());

        System.out.println("Current content: " + textEditor.getContent());

        textEditor.restore(history.get(1)); // Revert to the second state

        System.out.println("Content after restoring: " + textEditor.getContent());
    }
}
```