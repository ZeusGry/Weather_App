package mapService.mapOpenWeatherMap;

import Entity.Localization;
import Entity.Weather.OpenWeatherMap;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.JSONAsker;
import json.Servis;

public class MapWeather {
    private final String openWeatherMapUrl = "http://api.openweathermap.org/data/2.5/weather?" +
            "id=2172797&" +
            "appid=8a6fa744d602a1ed0757c5b717b29e3f";
    /*private final String weatherStackUrl = "http://api.weatherstack.com/current?" +
            "access_key=f6545a9b099046e779daf7c41af5dce9&" +
            "query=Warszawa";*/


    public static void main(String[] args) throws JsonProcessingException {
        Localization localization = new Localization();
        localization.setLatitude(50.00);
        localization.setLongitude(50.00);
        localization.setID(200L);
        JSONAsker jsonAsker = new JSONAsker();
        System.out.println(jsonAsker.urlMaker(Servis.OPEN_WEATHER, localization));
        System.out.println(jsonAsker.getJSON(jsonAsker.urlMaker(Servis.OPEN_WEATHER,localization)));
        //mapOpenWeatherMap();

    }
/*    public static void mapOpenWeatherMap () throws JsonProcessingException {

        String jsonOpenWeatherMap = "{\"coord\":{\"lon\":145.7667,\"lat\":-16.9167},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":295.48,\"feels_like\":295.54,\"temp_min\":294.82,\"temp_max\":296.15,\"pressure\":1017,\"humidity\":68},\"visibility\":10000,\"wind\":{\"speed\":3.6,\"deg\":160},\"clouds\":{\"all\":98},\"dt\":1619529497,\"sys\":{\"type\":1,\"id\":9490,\"country\":\"AU\",\"sunrise\":1619468880,\"sunset\":1619510457},\"timezone\":36000,\"id\":2172797,\"name\":\"Cairns\",\"cod\":200}";
        ObjectMapper objectMapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Root root = objectMapper.readValue(jsonOpenWeatherMap, Root.class);
        System.out.println(root);
    }*/
}
