package Entity.Weather;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class WeatherHelper {
    protected Double temperature;
    protected Double pressure;
    protected Double humidity;
    protected Double speedWind;
    protected Double directionWind;

    public WeatherHelper(Double temperature, Double pressure, Double humidity, Double speedWind, Double directionWind) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.speedWind = speedWind;
        this.directionWind = directionWind;
    }

    public WeatherHelper() {
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getSpeedWind() {
        return speedWind;
    }

    public Double getDirectionWind() {
        return directionWind;
    }
}
