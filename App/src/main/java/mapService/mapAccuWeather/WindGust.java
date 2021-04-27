package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindGust {
    @JsonProperty("Speed")
    public Speed speed;
    @JsonProperty("Direction")
    public Direction direction;
}
