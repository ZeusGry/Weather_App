package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RootAccWeather {
    @JsonProperty("Headline")
    public Headline headline;
    @JsonProperty("DailyForecasts")
    public List<DailyForecast> dailyForecasts;
}
