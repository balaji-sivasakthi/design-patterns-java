package Behavioural.Interpreter;

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