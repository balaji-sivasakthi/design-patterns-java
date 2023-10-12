package Behavioural.State;

// State interface
interface TrafficLightState {
    void handleRequest();
}

// Concrete states
class RedLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Changing to green...");
    }
}

class GreenLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Changing to yellow...");
    }
}

class YellowLightState implements TrafficLightState {
    public void handleRequest() {
        System.out.println("Changing to red...");
    }
}

// Context
class TrafficLight {
    private TrafficLightState currentState;

    TrafficLight() {
        currentState = new RedLightState();
    }

    void setState(TrafficLightState state) {
        currentState = state;
    }

    void change() {
        currentState.handleRequest();
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        trafficLight.change(); // Changing to green...
        trafficLight.setState(new GreenLightState());
        trafficLight.change(); // Changing to yellow...
        trafficLight.setState(new YellowLightState());
        trafficLight.change(); // Changing to red...
    }
}