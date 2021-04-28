package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WindGust {
    @JsonProperty("Speed")
    public Speed speed;
}
