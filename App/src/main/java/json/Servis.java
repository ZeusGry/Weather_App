package json;

public enum Servis {
    WEATHER_STACK("http://api.weatherstack.com/current?access_key=KeyToPut&query= Latination,Longitude & units = m"),
    OPEN_WEATHER("http://api.openweathermap.org/data/2.5/weather?lat=Latination&lon=Longitude&units=metric&appid=KeyToPut"),
    ACCUWEATHER("http://dataservice.accuweather.com/forecasts/v1/hourly/1hour/CityKey?apikey=KeyToPut&details=true&metric=true HTTP/1.1"),
    ACCUWEATHER_LOCATIONS("http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey=KeyToPut&q=Latination%2CLongitude");

    String url;

    public String getUrl() {
        return url;
    }

    Servis(String url) {
        this.url = url;
    }
}
