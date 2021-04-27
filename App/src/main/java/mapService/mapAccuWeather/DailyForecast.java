package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class DailyForecast {
    @JsonProperty("Date")
    public Date date;
    @JsonProperty("EpochDate")
    public int epochDate;
    @JsonProperty("Sun")
    public Sun sun;
    @JsonProperty("Moon")
    public Moon moon;
    @JsonProperty("Temperature")
    public Temperature temperature;
    @JsonProperty("RealFeelTemperature")
    public RealFeelTemperature realFeelTemperature;
    @JsonProperty("RealFeelTemperatureShade")
    public RealFeelTemperatureShade realFeelTemperatureShade;
    @JsonProperty("HoursOfSun")
    public double hoursOfSun;
    @JsonProperty("DegreeDaySummary")
    public DegreeDaySummary degreeDaySummary;
    @JsonProperty("AirAndPollen")
    public List<AirAndPollen> airAndPollen;
    @JsonProperty("Day")
    public Day day;
    @JsonProperty("Night")
    public Night night;
    @JsonProperty("Sources")
    public List<String> sources;
}
