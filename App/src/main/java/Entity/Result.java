package Entity;

import Entity.Weather.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.MathWeather;
import hibernate_core.HibernateHelper;
import json.JSONAsker;
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
        List<WeatherHelper> tempList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        for (Servis servis : Servis.values()) {
            if (servis.isWeather()) {
                String json = JSONAsker.getJSON(JSONAsker.urlMaker(servis, localization));
                switch (servis) {
                    case ACCUWEATHER:
                        try {
                            accuWeather = objectMapper.readValue(json.substring(1, json.length()), RootAccWeather.class).getAccuWeather();
                            tempList.add(accuWeather);
                        } catch (JsonProcessingException e) {
                            System.out.println("Nie udało się pobrać pogody z AccuWeather");
                        }
                        break;
                    case WEATHER_STACK:
                        try {
                            weatherStack = objectMapper.readValue(json, RootWeatherStack.class)
                                    .getWeatherStack();
                            tempList.add(weatherStack);
                        } catch (JsonProcessingException e) {
                            System.out.println("Nie udało się pobrać pogody z WeatherStack");
                        }
                        break;
                    case OPEN_WEATHER:
                        try {
                            openWeatherMap = objectMapper.readValue(json, RootOpenWeatherMap.class)
                                    .getOpenWeatherMap();
                            tempList.add(openWeatherMap);
                        } catch (JsonProcessingException e) {
                            System.out.println("Nie udało się pobrać pogody z OpenWeather");
                        }
                        break;
                }
            }
        }

        WeatherHelper[] weathers = tempList.toArray(new WeatherHelper[0]);

        averageWeather = new AverageWeather(MathWeather.calculateAvgTemperature(weathers)
                .orElse(0), MathWeather.calculateAvgPressure(weathers)
                .orElse(0), MathWeather.calculateAvgHumidity(weathers)
                .orElse(0), MathWeather.calculateAvgSpeedWind(weathers), MathWeather.calculateAvgDirectionWind());

        try (Session session = HibernateHelper.INSTANCE.getSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(accuWeather);
            session.persist(averageWeather);
            session.persist(openWeatherMap);
            session.persist(weatherStack);
            session.persist(this);
            transaction.commit();
        }

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
