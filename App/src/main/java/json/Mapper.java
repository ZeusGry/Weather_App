package json;

import Entity.Localization;
import Entity.Result;
import Entity.Weather.AccuWeather;
import Entity.Weather.OpenWeatherMap;
import Entity.Weather.WeatherHelper;
import Entity.Weather.WeatherStack;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import mapService.localization_map.RootAccuWeatherLocalization;
import mapService.mapAccuWeather.RootAccWeather;
import mapService.mapOpenWeatherMap.RootOpenWeatherMap;
import mapService.mapWeatherStack.RootWeatherStack;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private static ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public static void setLongiuteAndLatitude(Localization localization) throws JsonProcessingException {
        RootOpenWeatherMap tempLoc = objectMapper.readValue(JSONAsker.getJSON(createURLForNewLozalizarion(localization)), RootOpenWeatherMap.class);
        if (tempLoc.getLat() != null) {
            localization.setLongitude(tempLoc.getLon());
            localization.setLatitude(tempLoc.getLat());
        }
    }

    public static void setLocalizationID(Localization localization) throws JsonProcessingException {
        localization.setID(objectMapper.readValue(JSONAsker.getJSON(JSONAsker.urlMaker(Servis.ACCUWEATHER_LOCATIONS, localization)), RootAccuWeatherLocalization.class).getKey());

    }

    private static String createURLForNewLozalizarion(Localization localization) {
        return Servis.OPEN_WEATHER.getUrl()
                .replace("KeyToPut", Keys.getKeys()
                        .getKeyOpenWeatherMap())
                .replace("lat=Latination", "q=" +localization.getCity())
                .replace("lon=Longitude", localization.getCountry())
                .replaceFirst("&", ",");
    }

    public static ArrayList<WeatherHelper> weatherMapping(Result result, Servis servis, String json) {
        ArrayList<WeatherHelper> tempList = new ArrayList<>();
        switch (servis) {
            case ACCUWEATHER:
                try {
                    AccuWeather accuWeather = objectMapper.readValue(json.substring(1, json.length()), RootAccWeather.class).getAccuWeather();
                    result.setAccuWeather(accuWeather);
                    tempList.add(accuWeather);
                } catch (JsonProcessingException e) {
                    System.out.println("Nie udało się pobrać pogody z AccuWeather");
                }
                break;
            case WEATHER_STACK:
                try {
                    WeatherStack weatherStack = objectMapper.readValue(json, RootWeatherStack.class)
                            .getWeatherStack();
                    result.setWeatherStack(weatherStack);
                    tempList.add(weatherStack);
                } catch (JsonProcessingException e) {
                    System.out.println("Nie udało się pobrać pogody z WeatherStack");
                }
                break;
            case OPEN_WEATHER:
                try {
                    OpenWeatherMap openWeatherMap = objectMapper.readValue(json, RootOpenWeatherMap.class)
                            .getOpenWeatherMap();
                    result.setOpenWeatherMap(openWeatherMap);
                    tempList.add(openWeatherMap);
                } catch (JsonProcessingException e) {
                    System.out.println("Nie udało się pobrać pogody z OpenWeather");
                }
                break;
        }
        return tempList;
    }
}
