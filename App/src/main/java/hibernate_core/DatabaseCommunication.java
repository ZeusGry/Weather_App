package hibernate_core;

import Entity.Localization;
import Entity.Result;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DatabaseCommunication {
    public static List<Localization> getLocalizationList() {
        try (Session session = HibernateHelper.INSTANCE.getSession()) {
            return session.createQuery("SELECT loc FROM Localization loc", Localization.class)
                    .getResultList();
        }
    }

    public static void saveLocation(List<Localization> localizationList) {
        try (Session session = HibernateHelper.INSTANCE.getSession()) {
            Transaction transaction = session.beginTransaction();
            for (Localization localization : localizationList) {
                session.persist(localization);
            }
            transaction.commit();
        }
    }

    public static void saveResults(List<Result> resultList) {
        try (Session session = HibernateHelper.INSTANCE.getSession()) {
            Transaction transaction = session.beginTransaction();
            for (Result result : resultList) {
                session.persist(result.getAccuWeather());
                session.persist(result.getAverageWeather());
                session.persist(result.getOpenWeatherMap());
                session.persist(result.getWeatherStack());
                session.persist(result);
            }
            transaction.commit();
        }
    }
}
