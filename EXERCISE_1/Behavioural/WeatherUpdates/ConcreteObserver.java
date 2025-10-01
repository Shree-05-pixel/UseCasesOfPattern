package WeatherUpdates;

class ConcreteObserver implements DisplayDevice {
    private String deviceName;

    public ConcreteDisplayDevice(String deviceName) {
        this.deviceName = deviceName;
    }

    @Override
    public void update(ConcreteWeatherData data) {
        System.out.println(deviceName + " Display: Temperature is "
                + data.getTemperature() + "°C");
    }

    @Override
    public String toString() {
        return deviceName;
    }
}
