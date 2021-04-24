package Entity.Weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WeatherStack extends WeatherHelper{
    @Id
    @GeneratedValue
    private Integer id;

    public WeatherStack(Double temperature, Double pressure, Double humidity, Double speedWind, Double directionWind) {
        super(temperature, pressure, humidity, speedWind, directionWind);
    }

    public WeatherStack() {
    }
}
