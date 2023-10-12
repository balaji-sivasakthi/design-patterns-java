# Flyweight Design Pattern Example

## Table of Contents
- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)


## Introduction

This project provides an example implementation of the Flyweight design pattern in Java. The Flyweight pattern is a structural design pattern that focuses on efficient memory usage by sharing as much as possible with similar objects. It's particularly useful when you need to create a large number of similar objects while minimizing memory and computational expenses.

## Motivation

The Flyweight design pattern is beneficial when:

- You need to create a large number of objects, and their similarity allows you to share common state or behavior.
- Memory usage and computational expenses are concerns.
- You want to separate intrinsic (shared) state from extrinsic (unique) state.

This pattern reduces memory overhead and can significantly improve performance in scenarios where many similar objects are involved.

## Real-World Example

**Scenario**: In a text editor application, there is a need to display a large amount of text with various fonts and styles. Using separate font and style objects for each character would be memory-intensive. The Flyweight pattern can be applied to share common font and style objects for identical characters.

```java
// Flyweight interface
interface TextCharacter {
    void display();
}

// Concrete Flyweight (Shared)
class CharacterStyle implements TextCharacter {
    private char character;
    private String style;

    CharacterStyle(char character, String style) {
        this.character = character;
        this.style = style;
    }

    public void display() {
        System.out.println("Character: " + character + ", Style: " + style);
    }
}

// Flyweight Factory
class CharacterStyleFactory {
    private Map<Character, CharacterStyle> characterStyleMap = new HashMap<>();

    CharacterStyle getCharacterStyle(char character, String style) {
        characterStyleMap.putIfAbsent(character, new CharacterStyle(character, style));
        return characterStyleMap.get(character);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        CharacterStyleFactory factory = new CharacterStyleFactory();

        String text = "Hello, Flyweight Pattern!";
        for (char c : text.toCharArray()) {
            TextCharacter character = factory.getCharacterStyle(c, "Times New Roman 12pt");
            character.display();
        }
    }
}
```