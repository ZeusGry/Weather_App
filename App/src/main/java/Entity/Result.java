package Entity;

import Entity.Weather.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.MathWeather;
import hibernate_core.HibernateHelper;
import json.JSONAsker;
import json.Mapper;
import json.Servis;
import mapService.mapAccuWeather.RootAccWeather;
import mapService.mapOpenWeatherMap.RootOpenWeatherMap;
import mapService.mapWeatherStack.RootWeatherStack;
import org.hibernate.Session;
import org.hibernate.Transaction;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Result {

    @Id
    @GeneratedValue
    private Integer id;

    public Result(Localization localization) {
        this.localization = localization;
        List<WeatherHelper> tempList =null;
        for (Servis servis : Servis.values()) {
            if (servis.isWeather()) {
                String json = JSONAsker.getJSON(JSONAsker.urlMaker(servis, localization));
                tempList = Mapper.weatherMapping(this, servis, json);
            }
        }

        WeatherHelper[] weathers = tempList.toArray(new WeatherHelper[0]);

        averageWeather = new AverageWeather(MathWeather.calculateAvgTemperature(weathers)
                .orElse(0), MathWeather.calculateAvgPressure(weathers)
                .orElse(0), MathWeather.calculateAvgHumidity(weathers)
                .orElse(0), MathWeather.calculateAvgSpeedWind(weathers), MathWeather.calculateAvgDirectionWind());
    }

    public AccuWeather getAccuWeather() {
        return accuWeather;
    }

    public OpenWeatherMap getOpenWeatherMap() {
        return openWeatherMap;
    }

    public WeatherStack getWeatherStack() {
        return weatherStack;
    }

    public void setAccuWeather(AccuWeather accuWeather) {
        this.accuWeather = accuWeather;
    }

    public void setOpenWeatherMap(OpenWeatherMap openWeatherMap) {
        this.openWeatherMap = openWeatherMap;
    }

    public void setWeatherStack(WeatherStack weatherStack) {
        this.weatherStack = weatherStack;
    }


    public Result() {
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
