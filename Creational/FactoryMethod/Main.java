package Creational.FactoryMethod;

// Define the Creator interface
interface Creator {
    Product factoryMethod();
}

// Define the Product interface
interface Product {
    void display();
}

// Implement concrete Creator classes
class ConcreteCreatorA implements Creator {
    public Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreatorB implements Creator {
    public Product factoryMethod() {
        return new ConcreteProductB();
    }
}

// Implement concrete Product classes
class ConcreteProductA implements Product {
    public void display() {
        System.out.println("Product A");
    }
}

class ConcreteProductB implements Product {
    public void display() {
        System.out.println("Product B");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Creator creatorA = new ConcreteCreatorA();
        Product productA = creatorA.factoryMethod();
        productA.display();

        Creator creatorB = new ConcreteCreatorB();
        Product productB = creatorB.factoryMethod();
        productB.display();
    }
}