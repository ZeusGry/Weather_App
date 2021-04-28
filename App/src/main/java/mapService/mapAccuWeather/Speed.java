package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Speed {
    @JsonProperty("Value")
    public double value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;

    public double getValue() {
        return value;
    }
}
