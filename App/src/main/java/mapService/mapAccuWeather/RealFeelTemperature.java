package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RealFeelTemperature {
    @JsonProperty("Minimum")
    public Minimum minimum;
    @JsonProperty("Maximum")
    public Maximum maximum;
}
