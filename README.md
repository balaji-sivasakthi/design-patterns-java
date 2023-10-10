<h1 align="center">  Design Patterns in Java</h1>

<p align="center">
   This repository demonstrates various design patterns commonly used in software development. Design patterns are reusable solutions to common problems that arise during software design and development. They provide a structured approach to solving design-related issues and improving code maintainability, scalability, and flexibility.
</p>

## Table of Contents

1. [Creational Patterns](#creational-patterns)
   - [Singleton Pattern](#singleton-pattern)
   - [Factory Method Pattern](#factory-method-pattern)
   - [Abstract Factory Pattern](#abstract-factory-pattern)
   - [Builder Pattern](#builder-pattern)
   - [Prototype Pattern](#prototype-pattern)

2. [Structural Patterns](#structural-patterns)
   - [Adapter Pattern](#adapter-pattern)
   - [Bridge Pattern](#bridge-pattern)
   - [Composite Pattern](#composite-pattern)
   - [Decorator Pattern](#decorator-pattern)
   - [Facade Pattern](#facade-pattern)
   - [Flyweight Pattern](#flyweight-pattern)
   - [Proxy Pattern](#proxy-pattern)

3. [Behavioral Patterns](#behavioral-patterns)
   - [Chain of Responsibility Pattern](#chain-of-responsibility-pattern)
   - [Command Pattern](#command-pattern)
   - [Interpreter Pattern](#interpreter-pattern)
   - [Iterator Pattern](#iterator-pattern)
   - [Mediator Pattern](#mediator-pattern)
   - [Memento Pattern](#memento-pattern)
   - [Observer Pattern](#observer-pattern)
   - [State Pattern](#state-pattern)
   - [Strategy Pattern](#strategy-pattern)
   - [Template Method Pattern](#template-method-pattern)
   - [Visitor Pattern](#visitor-pattern)

## Creational Patterns

### Singleton Pattern

**Purpose**: Ensures that a class has only one instance and provides a global point of access to that instance.

### Factory Method Pattern

**Purpose**: Defines an interface for creating an object but lets subclasses alter the type of objects that will be created.

### Abstract Factory Pattern

**Purpose**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

### Builder Pattern

**Purpose**: Separates the construction of a complex object from its representation, allowing the same construction process to create various representations.

### Prototype Pattern

**Purpose**: Creates new objects by copying an existing object, known as the prototype, rather than creating new instances from scratch.

## Structural Patterns

### Adapter Pattern

**Purpose**: Allows the interface of an existing class to be used as another interface, making it compatible with the client's requirements.

### Bridge Pattern

**Purpose**: Separates an object's abstraction from its implementation, allowing both to evolve independently.

### Composite Pattern

**Purpose**: Composes objects into tree structures to represent part-whole hierarchies. It allows clients to treat individual objects and compositions of objects uniformly.

### Decorator Pattern

**Purpose**: Attaches additional responsibilities to objects dynamically, extending their functionality without altering their class.

### Facade Pattern

**Purpose**: Provides a simplified interface to a set of interfaces in a subsystem, making it easier to use.

### Flyweight Pattern

**Purpose**: Minimizes memory usage or computational expenses by sharing as much as possible with other similar objects.

### Proxy Pattern

**Purpose**: Provides a surrogate or placeholder for another object to control access to it.

## Behavioral Patterns

### Chain of Responsibility Pattern

**Purpose**: Passes a request along a chain of handlers. Each handler decides either to process the request or pass it to the next handler in the chain.

### Command Pattern

**Purpose**: Encapsulates a request as an object, thereby allowing for parameterization of clients with queues, requests, and operations.

### Interpreter Pattern

**Purpose**: Defines a grammar for a language and provides an interpreter to interpret sentences in that language.

### Iterator Pattern

**Purpose**: Provides a way to access the elements of an aggregate object sequentially without exposing its underlying representation.

### Mediator Pattern

**Purpose**: Defines an object that encapsulates how a set of objects interact. It promotes loose coupling by keeping objects from referring to each other explicitly.

### Memento Pattern

**Purpose**: Captures and externalizes an object's internal state, allowing the object to be restored to that state later.

### Observer Pattern

**Purpose**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

### State Pattern

**Purpose**: Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

### Strategy Pattern

**Purpose**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. It lets the algorithm vary independently from clients that use it.

### Template Method Pattern

**Purpose**: Defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

### Visitor Pattern

**Purpose**: Represents an operation to be performed on elements of an object structure. It lets you define a new operation without changing the classes of the elements on which it operates.

## Contributing

Contributions to this repository are welcome. Feel free to add examples, explanations, or improvements to existing design patterns.

## License

This project is licensed under the [MIT License](LICENSE).
