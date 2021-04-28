package json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Keys {
    static Keys keys;

    public static Keys getKeys() {
        if (keys == null) {
            try {
                ObjectMapper objectMapper = new ObjectMapper()
                        .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                keys = objectMapper.readValue(new File("App/src/main/resources/keys.json"), Keys.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return keys;
    }

    public String getKeyAccuWeather() {
        return keyAccuWeather;
    }

    public String getKeyOpenWeatherMap() {
        return keyOpenWeatherMap;
    }

    public String getKeyWeatherStack() {
        return keyWeatherStack;
    }

    private Keys() {
    }

    private String keyAccuWeather;
    private String keyOpenWeatherMap;
    private String keyWeatherStack;

}
