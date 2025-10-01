package EXERCISE_1.Behavioural.WeatherUpdates;
 
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
