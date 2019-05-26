package com.serkaneren.weather.exception;

public class LocationNotFound extends RuntimeException {

    public LocationNotFound(float latitude, float longitude) {
        super("Location can not be found with the latitude: " + latitude + " , longitude: " + longitude);
    }
}
