package json;


import Entity.Localization;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class JSONAsker {

    public static String urlMaker(Servis servis, Localization localization) {
        String URL = servis.getUrl()
                .replace("Longitude", Double.toString(localization.getLongitude()))
                .replace("Latination", Double.toString(localization.getLatitude()))
                .replace("CityKey", Long.toString(localization.getID()));
        switch (servis) {
            case ACCUWEATHER:
                return URL.replace("KeyToPut", Keys.getKeys()
                        .getKeyAccuWeather());
            case OPEN_WEATHER:
                return URL.replace("KeyToPut", Keys.getKeys()
                        .getKeyOpenWeatherMap());
            case WEATHER_STACK:
                return URL.replace("KeyToPut", Keys.getKeys()
                        .getKeyWeatherStack());
            case ACCUWEATHER_LOCATIONS:
                return URL.replace("KeyToPut", Keys.getKeys()
                        .getKeyAccuWeather());
            default:
                return URL;
        }
    }


    public static String getJSON(String url) {
        String json = "nie udało się";
        Request request = new Request.Builder()
                .url(url)
                .build();
        OkHttpClient client = new OkHttpClient();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            json = response.body()
                    .string();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return json;
    }

}
