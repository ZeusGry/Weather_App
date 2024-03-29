package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {
    @JsonProperty("Speed")
    public Speed speed;
    @JsonProperty("Direction")
    public Direction direction;

    public double getSpeed() {
        return speed.getValue();
    }

    public double getDirection() {
        return direction.getDegrees();
    }
}
