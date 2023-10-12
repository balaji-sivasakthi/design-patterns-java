# Interpreter Design Pattern Example

## Table of Contents

- [Introduction](#introduction)
- [Motivation](#motivation)
- [Real-World Example](#real-world-example)

## Introduction

This project provides an example implementation of the Interpreter design pattern in Java. The Interpreter pattern is a
behavioral design pattern used to define a grammar for interpreting a language and evaluate language expressions. It
involves defining a syntax tree representing the grammar and then interpreting language expressions using this tree.

## Motivation

The Interpreter design pattern is beneficial when:

- You have a language to interpret and need to provide a way to evaluate expressions in that language.
- You want to implement a language with a simple and consistent grammar.
- You need to parse and evaluate mathematical expressions, SQL queries, regular expressions, etc.
- You aim to provide a way to extend the language with new expressions easily.

This pattern provides a way to parse and evaluate language expressions using a well-defined grammar.

## Real-World Example

**Scenario**: In a simple calculator application, you want to provide the ability to evaluate mathematical expressions.
The Interpreter pattern can be used to define a grammar for mathematical expressions and evaluate them.

```java
// Abstract expression interface
interface Expression {
    int interpret();
}

// Terminal expression
class NumberExpression implements Expression {
    private int number;

    NumberExpression(int number) {
        this.number = number;
    }

    public int interpret() {
        return number;
    }
}

// Non-terminal expression
class AdditionExpression implements Expression {
    private Expression left;
    private Expression right;

    AdditionExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Expression expression = new AdditionExpression(
                new NumberExpression(5),
                new NumberExpression(3)
        );

        int result = expression.interpret();
        System.out.println("Result: " + result); // Output: Result: 8
    }
}
```