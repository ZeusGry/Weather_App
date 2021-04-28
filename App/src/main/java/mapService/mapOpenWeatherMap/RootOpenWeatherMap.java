package mapService.mapOpenWeatherMap;

import Entity.Weather.OpenWeatherMap;

import java.util.List;

public class RootOpenWeatherMap {
    public Coord coord;
    public List<Weather> weather;
    public String base;
    public Temperature main;
    public int visibility;
    public Wind wind;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public String name;
    public int cod;



    public OpenWeatherMap getOpenWeatherMap() {
        return new OpenWeatherMap(main.getTemp(),(double) main.getPressure(),(double) main.getHumidity(),wind.getSpeed(),(double) wind.getDeg());
    }

    public Double getLat() {
        if (coord == null) {
            return null;
        }
        return coord.getLat();
    }

    public Double getLon() {
        if (coord == null) {
            return null;
        }
        return coord.getLon();
    }
}
