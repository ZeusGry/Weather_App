package mapService.mapAccuWeather;

import Entity.Weather.AccuWeather;
import Entity.Weather.OpenWeatherMap;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class RootAccWeather {
    @JsonProperty("DateTime")
    public Date dateTime;
    @JsonProperty("EpochDateTime")
    public int epochDateTime;
    @JsonProperty("WeatherIcon")
    public int weatherIcon;
    @JsonProperty("IconPhrase")
    public String iconPhrase;
    @JsonProperty("HasPrecipitation")
    public boolean hasPrecipitation;
    @JsonProperty("IsDaylight")
    public boolean isDaylight;
    @JsonProperty("Temperature")
    public Temperature temperature;
    @JsonProperty("RealFeelTemperature")
    public RealFeelTemperature realFeelTemperature;
    @JsonProperty("WetBulbTemperature")
    public WetBulbTemperature wetBulbTemperature;
    @JsonProperty("DewPoint")
    public DewPoint dewPoint;
    @JsonProperty("Wind")
    public Wind wind;
    @JsonProperty("WindGust")
    public WindGust windGust;
    @JsonProperty("RelativeHumidity")
    public int relativeHumidity;
    @JsonProperty("IndoorRelativeHumidity")
    public int indoorRelativeHumidity;
    @JsonProperty("Visibility")
    public Visibility visibility;
    @JsonProperty("Ceiling")
    public Ceiling ceiling;
    @JsonProperty("UVIndex")
    public int uVIndex;
    @JsonProperty("UVIndexText")
    public String uVIndexText;
    @JsonProperty("PrecipitationProbability")
    public int precipitationProbability;
    @JsonProperty("RainProbability")
    public int rainProbability;
    @JsonProperty("SnowProbability")
    public int snowProbability;
    @JsonProperty("IceProbability")
    public int iceProbability;
    @JsonProperty("TotalLiquid")
    public TotalLiquid totalLiquid;
    @JsonProperty("Rain")
    public Rain rain;
    @JsonProperty("Snow")
    public Snow snow;
    @JsonProperty("Ice")
    public Ice ice;
    @JsonProperty("CloudCover")
    public int cloudCover;
    @JsonProperty("MobileLink")
    public String mobileLink;
    @JsonProperty("Link")
    public String link;

    public AccuWeather getAccuWeather() {
        return new AccuWeather(temperature.getValue(),null,(double) relativeHumidity, wind.getSpeed(), wind.getDirection());
    }
}
