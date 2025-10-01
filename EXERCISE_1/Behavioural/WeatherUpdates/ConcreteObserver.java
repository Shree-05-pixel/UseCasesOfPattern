package EXERCISE_1.Behavioural.WeatherUpdates;

public class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String weatherUpdate) {
        System.out.println(name + " received weather update: " + weatherUpdate);
    }
}
