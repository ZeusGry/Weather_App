package json;

public enum Servis {
    WEATHER_STACK(true,"http://api.weatherstack.com/current?access_key=KeyToPut&query= Latination,Longitude & units = m"),
    OPEN_WEATHER(true,"http://api.openweathermap.org/data/2.5/weather?lat=Latination&lon=Longitude&units=metric&appid=KeyToPut"),
    ACCUWEATHER(true, "http://dataservice.accuweather.com/forecasts/v1/hourly/1hour/CityKey?apikey=KeyToPut&details=true&metric=true HTTP/1.1"),
    ACCUWEATHER_LOCATIONS(false,"http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey=KeyToPut&q=Latination%2CLongitude");

    String url;
    boolean weather;
    public String getUrl() {
        return url;
    }

    public boolean isWeather() {
        return weather;
    }

    Servis(boolean weather, String url) {
        this.url = url;
        this.weather = weather;
    }
}
