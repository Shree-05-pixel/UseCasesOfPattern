package WeatherUpdates;

import java.util.ArrayList;
import java.util.List;

public class ConcreteWeatherData implements WeatherData {
    private float temperature;
    private List<DisplayDevice> devices = new ArrayList<>();

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    @Override
    public void registerObserver(DisplayDevice device) {
        devices.add(device);
    }

    @Override
    public void removeObserver(DisplayDevice device) {
        devices.remove(device);
    }

    @Override
    public void notifyObservers() {
        for (DisplayDevice device : devices) {
            device.update(this);
        }
    }
}
