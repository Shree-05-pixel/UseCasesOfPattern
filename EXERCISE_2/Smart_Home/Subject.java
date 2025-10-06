package EXERCISE_2.Smart_Home;


public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String eventType, Object data);
}

