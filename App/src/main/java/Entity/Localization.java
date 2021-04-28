package Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate_core.HibernateHelper;
import json.JSONAsker;
import json.Keys;
import json.Servis;
import mapService.localization_map.RootAccuWeatherLocalization;
import mapService.mapAccuWeather.RootAccWeather;
import mapService.mapOpenWeatherMap.RootOpenWeatherMap;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Localization {
    @Id
    String ID;
    String city;
    String region;
    String country;
    Double longitude;
    Double latitude;

    public Localization(String city, String country) {
        boolean isOkey = true;
        this.city = city.substring(0, 1).toUpperCase() + city.substring(1);
        this.country = country.toUpperCase();
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        isOkey = fillLocalization(isOkey, objectMapper);


        transactionCommit(isOkey);
    }

    private void transactionCommit(boolean isOkey) {
        try (Session session = HibernateHelper.INSTANCE.getSession()) {
            Transaction transaction = session.beginTransaction();
            if (isOkey) {
                session.persist(this);
                transaction.commit();
            } else {
                transaction.rollback();
            }
        }
    }

    private boolean fillLocalization(boolean isOkey, ObjectMapper objectMapper) {
        try {
            RootOpenWeatherMap tempLoc = objectMapper.readValue(JSONAsker.getJSON(createURLForNewLozalizarion()), RootOpenWeatherMap.class);
            if (tempLoc.getLat() == null) {
                isOkey = false;
            } else {
                longitude = tempLoc.getLon();
                latitude = tempLoc.getLat();
            }
        } catch (JsonProcessingException e) {
            System.out.println("Nie znaleziono takiego miejsca");
            isOkey = false;
        }
        if (isOkey) {
            try {
                this.ID = objectMapper.readValue(JSONAsker.getJSON(JSONAsker.urlMaker(Servis.ACCUWEATHER_LOCATIONS, this)), RootAccuWeatherLocalization.class).getKey();
            } catch (JsonProcessingException e) {
                System.out.println("Nie znaleziono takiego miejsca");
                isOkey = false;
            }
        }
        return isOkey;
    }

    private String createURLForNewLozalizarion() {
        return Servis.OPEN_WEATHER.getUrl()
                .replace("KeyToPut", Keys.getKeys()
                        .getKeyOpenWeatherMap())
                .replace("lat=Latination", "q=" +this.city)
                .replace("lon=Longitude", this.country)
                .replaceFirst("&", ",");
    }

    @Override
    public String toString() {
        return "Miasto='" + city + '\'' +
                ", kraj='" + country + '\'';
    }

    public Localization() {
    }

    public static List<Localization> getList() {
        try (Session session = HibernateHelper.INSTANCE.getSession()) {
            return session.createQuery("SELECT s FROM Localization s", Localization.class)
                    .getResultList();
        }
    }

    public String getID() {
        return ID;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }



}
