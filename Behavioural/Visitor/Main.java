package Behavioural.Visitor;

// Element interface
interface Shape {
    void accept(Visitor visitor);
}

// Visitor interface
interface Visitor {
    void visit(Circle circle);

    void visit(Rectangle rectangle);
}

// Concrete elements
class Circle implements Shape {
    private int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    int getRadius() {
        return radius;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class Rectangle implements Shape {
    private int width;
    private int height;

    Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int getWidth() {
        return width;
    }

    int getHeight() {
        return height;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

// Concrete visitor
class AreaVisitor implements Visitor {
    double totalArea = 0;

    public void visit(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        totalArea += area;
    }

    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        totalArea += area;
    }

    double getTotalArea() {
        return totalArea;
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(5), new Rectangle(4, 3)};

        AreaVisitor areaVisitor = new AreaVisitor();

        for (Shape shape : shapes) {
            shape.accept(areaVisitor);
        }

        System.out.println("Total area: " + areaVisitor.getTotalArea());
    }
}