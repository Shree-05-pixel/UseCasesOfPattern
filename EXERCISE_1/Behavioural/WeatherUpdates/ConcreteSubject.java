package EXERCISE_1.Behavioural.WeatherUpdates;

import java.util.ArrayList;
import java.util.List;


public class ConcreteSubject implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String weather; // current weather update

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(weather);
        }
    }

    // Set new weather update
    public void setWeather(String weather) {
        this.weather = weather;
        System.out.println("Weather Station updated: " + weather);
        notifyObservers();
    }
}

}

