package Behavioural.Mediator;

// Mediator interface
interface AirTrafficControl {
    void requestLanding(Aircraft aircraft);

    void requestTakeoff(Aircraft aircraft);
}

// Concrete Mediator
class ControlTower implements AirTrafficControl {
    public void requestLanding(Aircraft aircraft) {
        System.out.println(aircraft.getName() + " is clear to land.");
    }

    public void requestTakeoff(Aircraft aircraft) {
        System.out.println(aircraft.getName() + " is cleared for takeoff.");
    }
}

// Colleague
class Aircraft {
    private String name;
    private AirTrafficControl mediator;

    Aircraft(String name, AirTrafficControl mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    String getName() {
        return name;
    }

    void requestLanding() {
        mediator.requestLanding(this);
    }

    void requestTakeoff() {
        mediator.requestTakeoff(this);
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        AirTrafficControl controlTower = new ControlTower();

        Aircraft aircraft1 = new Aircraft("Flight 123", controlTower);
        Aircraft aircraft2 = new Aircraft("Flight 456", controlTower);

        aircraft1.requestLanding();
        aircraft2.requestTakeoff();
    }
}