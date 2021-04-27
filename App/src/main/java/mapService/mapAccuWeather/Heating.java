package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Heating {
    @JsonProperty("Value")
    public double value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
}
