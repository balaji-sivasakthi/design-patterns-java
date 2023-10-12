package Structural.Adapter;

// Target interface for power input
interface Target {
    void plugIntoPowerSupply();
}

// Adaptee (device with specific power input)
class Device {
    void specificPowerInput() {
        System.out.println("Device with specific power input is plugged in.");
    }
}

// Adapter class to adapt the device to a different power supply
class PowerAdapter implements Target {
    private Device device;

    PowerAdapter(Device device) {
        this.device = device;
    }

    public void plugIntoPowerSupply() {
        // Convert the power input for the device
        device.specificPowerInput();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        Device device = new Device();
        Target target = new PowerAdapter(device);

        // Use the device with the adapter in different countries
        target.plugIntoPowerSupply();
    }
}