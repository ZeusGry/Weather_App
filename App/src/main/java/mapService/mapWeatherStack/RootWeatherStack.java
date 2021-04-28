package mapService.mapWeatherStack;

import Entity.Weather.WeatherStack;

public class RootWeatherStack {
    public Request request;
    public Location location;
    public Current current;

    public WeatherStack getWeatherStack() {
        return new WeatherStack((double) current.getTemperature(), (double) current.getPressure(), (double) current.getHumidity(), (double) current.getWind_speed(), (double) current.getWind_degree());
    }
}
