package com.serkaneren.weather.exception;

public class WeatherNotFound extends RuntimeException {

    public WeatherNotFound(float latitude, float longitude) {
        super("Weather can not be found with the latitude: " + latitude + " , longitude: " + longitude);
    }
}
