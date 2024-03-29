package mapService.mapWeatherStack;

import java.util.List;

public class Current {
    public String observation_time;
    public int temperature;
    public int weather_code;
    public List<String> weather_icons;
    public List<String> weather_descriptions;
    public int wind_speed;
    public int wind_degree;
    public String wind_dir;
    public int pressure;
    public int precip;
    public int humidity;
    public int cloudcover;
    public int feelslike;
    public int uv_index;
    public int visibility;
    public String is_day;

    public int getTemperature() {
        return temperature;
    }

    public int getWind_speed() {
        return wind_speed;
    }

    public int getWind_degree() {
        return wind_degree;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }
}
