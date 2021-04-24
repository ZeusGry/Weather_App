package Entity;

import Entity.Weather.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Result {

    @Id
    @GeneratedValue
    private Integer id;

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
