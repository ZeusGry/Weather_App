package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RealFeelTemperatureShade {
    @JsonProperty("Minimum")
    public Minimum minimum;
    @JsonProperty("Maximum")
    public Maximum maximum;
}
