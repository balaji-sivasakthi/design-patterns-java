package Creational.Prototype;

// Prototype interface for graphic elements
interface GraphicPrototype {
    GraphicPrototype clone();
    void draw();
    void setAttributes(String attributes);
}

// Concrete Graphic prototypes
class Circle implements GraphicPrototype {
    private String attributes;
    Circle(String attributes){
        this.attributes = attributes;
    }
    public GraphicPrototype clone() {
        return new Circle(this.attributes);
    }

    public void draw() {
        // Draw a circle with the specified attributes.
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}

class Rectangle implements GraphicPrototype {
    private String attributes;
    Rectangle(String attributes){
        this.attributes = attributes;
    }

    public GraphicPrototype clone() {
        return new Rectangle(this.attributes);
    }

    public void draw() {
        // Draw a rectangle with the specified attributes.
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
}

// Graphics Editor
public class GraphicsEditor {
    public static void main(String[] args) {
        GraphicPrototype circlePrototype = new Circle("red, radius=10");
        GraphicPrototype rectanglePrototype = new Rectangle("blue, width=20, height=30");

        // User clones and customizes graphic elements
        GraphicPrototype customCircle = circlePrototype.clone();
        customCircle.setAttributes("green, radius=15");

        GraphicPrototype customRectangle = rectanglePrototype.clone();
        customRectangle.setAttributes("yellow, width=25, height=40");

        // User can draw and manipulate customized graphic elements
        customCircle.draw();
        customRectangle.draw();
    }
}