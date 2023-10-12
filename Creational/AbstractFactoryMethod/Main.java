package Creational.AbstractFactoryMethod;

// Abstract Factory interface
interface UIAbstractFactory {
    Button createButton();

    Checkbox createCheckbox();
}

// Abstract Product: Button
interface Button {
    void render();
}

// Abstract Product: Checkbox
interface Checkbox {
    void render();
}

// Concrete Factory 1: Light Theme Factory
class LightThemeFactory implements UIAbstractFactory {
    public Button createButton() {
        return new LightButton();
    }

    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}

// Concrete Factory 2: Dark Theme Factory
class DarkThemeFactory implements UIAbstractFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}

// Concrete Products for Light Theme
class LightButton implements Button {
    public void render() {
        System.out.println("Rendering a light button");
    }
}

// Concrete Products for Dark Theme
class DarkButton implements Button {
    public void render() {
        System.out.println("Rendering a dark button");
    }
}

// Concrete Products for Light Theme
class LightCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering a light checkbox");
    }
}

// Concrete Products for Dark Theme
class DarkCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering a dark checkbox");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        UIAbstractFactory factory = new LightThemeFactory();

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render(); // Output: Rendering a light button
        checkbox.render(); // Output: Rendering a light checkbox

        factory = new DarkThemeFactory();

        button = factory.createButton();
        checkbox = factory.createCheckbox();

        button.render(); // Output: Rendering a dark button
        checkbox.render(); // Output: Rendering a dark checkbox
    }
}
