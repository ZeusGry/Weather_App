package mapService.mapOpenWeatherMap;

import java.util.List;

public class Root {
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
}
