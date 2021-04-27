package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Sun {
    @JsonProperty("Rise")
    public Date rise;
    @JsonProperty("EpochRise")
    public int epochRise;
    @JsonProperty("Set")
    public Date set;
    @JsonProperty("EpochSet")
    public int epochSet;
}
