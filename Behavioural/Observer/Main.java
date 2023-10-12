package Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete subject
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Observer interface
interface Observer {
    void update(float temperature);
}

// Concrete observer
class TemperatureDisplay implements Observer {
    private float temperature;

    public void update(float temperature) {
        this.temperature = temperature;
        display();
    }

    private void display() {
        System.out.println("Temperature Display: " + temperature + "°C");
    }
}

// Client code
public class Main {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();
        TemperatureDisplay temperatureDisplay = new TemperatureDisplay();

        weatherStation.registerObserver(temperatureDisplay);

        // Simulate a change in temperature
        weatherStation.setTemperature(25.5f);
    }
}