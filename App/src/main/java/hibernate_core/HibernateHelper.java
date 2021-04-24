package hibernate_core;

import Entity.Localization;
import Entity.Result;
import Entity.Weather.AccuWeather;
import Entity.Weather.AverageWeather;
import Entity.Weather.OpenWeatherMap;
import Entity.Weather.WeatherStack;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public enum HibernateHelper {
    INSTANCE;
    private SessionFactory sessionFactory;

    HibernateHelper() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(AccuWeather.class)
                .addAnnotatedClass(AverageWeather.class)
                .addAnnotatedClass(OpenWeatherMap.class)
                .addAnnotatedClass(WeatherStack.class)
                .addAnnotatedClass(Localization.class)
                .addAnnotatedClass(Result.class)
                .buildSessionFactory();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
