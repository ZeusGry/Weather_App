package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalLiquid {
    @JsonProperty("Value")
    public int value;
    @JsonProperty("Unit")
    public String unit;
    @JsonProperty("UnitType")
    public int unitType;
}
