package Structural.Bridge;

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