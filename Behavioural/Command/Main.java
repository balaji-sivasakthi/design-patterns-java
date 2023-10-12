package Behavioural.Command;

// Command interface
interface Command {
    void execute();

    void undo();
}

// Concrete Command
class LightOnCommand implements Command {
    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }

    public void undo() {
        light.turnOff();
    }
}

// Receiver
class Light {
    void turnOn() {
        System.out.println("Light is on");
    }

    void turnOff() {
        System.out.println("Light is off");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOn);

        remoteControl.pressButton();  // Turns the light on
    }
}