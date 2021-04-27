package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AirAndPollen {
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Value")
    public int value;
    @JsonProperty("Category")
    public String category;
    @JsonProperty("CategoryValue")
    public int categoryValue;
    @JsonProperty("Type")
    public String type;
}
