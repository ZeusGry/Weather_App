package mapService.localization_map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RootAccuWeatherLocalization {
        @JsonProperty("Key")
        public String key;

    public String getKey() {
        return key;
    }
}
