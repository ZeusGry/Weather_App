package Entity.Weather;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AverageWeather extends WeatherHelper {
    @Id
    @GeneratedValue
    private Integer id;

    public AverageWeather(Double temperature, Double pressure, Double humidity, Double speedWind, Double directionWind) {
        super(temperature, pressure, humidity, speedWind, directionWind);
    }

    @Override
    public String toString() {
        return "Pogoda na bazie trzech serwisów{" +
                "temperatura=" + temperature +
                ", ciśnienie=" + pressure +
                ", wilgotność=" + humidity +
                ", prędkość wiatru=" + speedWind +
                ", kierunek wiatru=" + directionWind +
                '}';
    }

    public AverageWeather() {
    }
}
