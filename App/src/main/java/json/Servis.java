package json;

public enum Servis {
    WEATHER_STACK("http://api.weatherstack.com/current?access_key=KeyToPut&query= 40.7831,-73.9712 & units = m"),
    OPEN_WEATHER("http://api.openweathermap.org/data/2.5/weather?lat=40.78&lon=-73.97&units=metric&appid=KeyToPut"),
    ACCUWEATHER("http://dataservice.accuweather.com/forecasts/v1/hourly/1hour/CityKey?apikey=KeyToPut&details=true&metric=true HTTP/1.1"),
    ACCUWEATHER_LOCATIONS("http://dataservice.accuweather.com/locations/v1/cities/geoposition/search?apikey=KeyToPut&q=40.78%2C%20-73.97");

    String url;

    public String getUrl() {
        return url;
    }

    Servis(String url) {
        this.url = url;
    }
}
