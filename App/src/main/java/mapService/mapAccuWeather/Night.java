package mapService.mapAccuWeather;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Night {
    @JsonProperty("Icon")
    public int icon;
    @JsonProperty("IconPhrase")
    public String iconPhrase;
    @JsonProperty("HasPrecipitation")
    public boolean hasPrecipitation;
    @JsonProperty("ShortPhrase")
    public String shortPhrase;
    @JsonProperty("LongPhrase")
    public String longPhrase;
    @JsonProperty("PrecipitationProbability")
    public int precipitationProbability;
    @JsonProperty("ThunderstormProbability")
    public int thunderstormProbability;
    @JsonProperty("RainProbability")
    public int rainProbability;
    @JsonProperty("SnowProbability")
    public int snowProbability;
    @JsonProperty("IceProbability")
    public int iceProbability;
    @JsonProperty("Wind")
    public Wind wind;
    @JsonProperty("WindGust")
    public WindGust windGust;
    @JsonProperty("TotalLiquid")
    public TotalLiquid totalLiquid;
    @JsonProperty("Rain")
    public Rain rain;
    @JsonProperty("Snow")
    public Snow snow;
    @JsonProperty("Ice")
    public Ice ice;
    @JsonProperty("HoursOfPrecipitation")
    public double hoursOfPrecipitation;
    @JsonProperty("HoursOfRain")
    public double hoursOfRain;
    @JsonProperty("HoursOfSnow")
    public double hoursOfSnow;
    @JsonProperty("HoursOfIce")
    public double hoursOfIce;
    @JsonProperty("CloudCover")
    public int cloudCover;
}
