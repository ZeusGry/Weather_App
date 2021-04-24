package Entity.Weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AccuWeather extends WeatherHelper {
    @Id
    @GeneratedValue
    private Integer id;

    public AccuWeather(Double temperature, Double pressure, Double humidity, Double speedWind, Double directionWind) {
        super(temperature, pressure, humidity, speedWind, directionWind);
    }

    public AccuWeather() {
    }
}
