package WeatherUpdates;

import java.util.ArrayList;
import java.util.List;

// Abstraction for Subject
 interface WeatherData {
    void registerObserver(DisplayDevice device);
    void removeObserver(DisplayDevice device);
    void notifyObservers();
}
