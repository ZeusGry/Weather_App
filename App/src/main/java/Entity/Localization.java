package Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import hibernate_core.HibernateHelper;
import json.JSONAsker;
import json.Keys;
import json.Mapper;
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

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public Localization(String city, String country) {
        this.city = city.substring(0, 1)
                .toUpperCase() + city.substring(1);
        this.country = country.toUpperCase();
        fillLocalization();
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    private void fillLocalization() {
        boolean isOkey = true;

        try {
            Mapper.setLongiuteAndLatitude(this);
        } catch (JsonProcessingException e) {
            System.out.println("Nie znaleziono takiego miejsca");
            isOkey = false;
        }
        if (isOkey) {
            try {
                Mapper.setLocalizationID(this);
            } catch (JsonProcessingException e) {
                System.out.println("Nie znaleziono takiego miejsca");
            }
        }

    }


    @Override
    public String toString() {
        return "Miasto='" + city + '\'' +
                ", kraj='" + country + '\'';
    }

    public Localization() {
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
