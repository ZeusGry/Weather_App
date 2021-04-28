package core;

import Entity.Weather.WeatherHelper;

import java.util.Arrays;
import java.util.Objects;
import java.util.OptionalDouble;

public class MathWeather {
    static Double a;
    static Double b;
    static Double c;

    public static OptionalDouble calculateAvgTemperature(WeatherHelper... weathers) {
        return Arrays.stream(weathers)
                .map(WeatherHelper::getTemperature)
                .filter(Objects::nonNull)
                .mapToDouble(e -> e)
                .average();
    }

    public static OptionalDouble calculateAvgPressure(WeatherHelper... weathers) {
        return Arrays.stream(weathers)
                .map(WeatherHelper::getPressure)
                .filter(Objects::nonNull)
                .mapToDouble(e -> e)
                .average();
    }

    public static OptionalDouble calculateAvgHumidity(WeatherHelper... weathers) {
        return Arrays.stream(weathers)
                .map(WeatherHelper::getHumidity)
                .filter(Objects::nonNull)
                .mapToDouble(e -> e)
                .average();
    }

    private static void calculateVector(WeatherHelper... weathers) {
        a = Arrays.stream(weathers)
                .map(weather -> java.lang.Math.sin(Math.toRadians(weather.getDirectionWind())) * weather.getSpeedWind())
                .mapToDouble(e -> e)
                .sum();
        b = Arrays.stream(weathers)
                .map(weather -> java.lang.Math.cos(Math.toRadians(weather.getDirectionWind())) * weather.getSpeedWind())
                .mapToDouble(e -> e)
                .sum();
        c = java.lang.Math.pow(java.lang.Math.pow(a, 2) + java.lang.Math.pow(b, 2), 0.5);
    }

    public static Double calculateAvgSpeedWind(WeatherHelper... weathers) {
        calculateVector(weathers);
        return c / 3;
    }

    public static Double calculateAvgDirectionWind(WeatherHelper... weathers) {
        Double direction = (180+java.lang.Math.toDegrees(Math.atan(a/b)))%360;
        a = null;
        b = null;
        c = null;
        return direction;
    }

}
