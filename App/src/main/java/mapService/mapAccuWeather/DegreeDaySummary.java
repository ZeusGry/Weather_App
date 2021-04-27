package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DegreeDaySummary {
    @JsonProperty("Heating")
    public Heating heating;
    @JsonProperty("Cooling")
    public Cooling cooling;
}
