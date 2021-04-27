package Entity;

import Entity.Weather.*;
import json.JSONAsker;
import json.Servis;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Result {

    @Id
    @GeneratedValue
    private Integer id;

    public Result(Localization localization) {
        this.localization = localization;
        for (Servis servis : Servis.values()) {
            if (servis.isWeather()) {
                String json = JSONAsker.getJSON(JSONAsker.urlMaker(servis, localization));

                switch (servis) {
                    case ACCUWEATHER:
                        accuWeather = null;
                        break;
                    case WEATHER_STACK:
                        weatherStack = null;
                        break;
                    case OPEN_WEATHER:
                        openWeatherMap = null;
                        break;
                }
            }
        }
    }

    public AverageWeather getAverageWeather() {
        return averageWeather;
    }

    @OneToOne
    AccuWeather accuWeather;
    @OneToOne
    AverageWeather averageWeather;
    @OneToOne
    OpenWeatherMap openWeatherMap;
    @OneToOne
    WeatherStack weatherStack;
    @OneToOne
    Localization localization;
}
