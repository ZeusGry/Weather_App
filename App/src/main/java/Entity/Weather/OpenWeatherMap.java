package Entity.Weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OpenWeatherMap extends WeatherHelper {
    @Id
    @GeneratedValue
    private Integer id;


    public OpenWeatherMap(Double temperature, Double pressure, Double humidity, Double speedWind, Double directionWind) {
        super(temperature, pressure, humidity, speedWind, directionWind);
    }


    public OpenWeatherMap() {
    }
}

