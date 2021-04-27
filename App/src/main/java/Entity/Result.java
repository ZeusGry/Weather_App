package Entity;

import Entity.Weather.*;
import hibernate_core.HibernateHelper;
import json.JSONAsker;
import json.Servis;
import org.hibernate.Session;
import org.hibernate.Transaction;


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
