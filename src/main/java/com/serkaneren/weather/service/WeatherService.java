package com.serkaneren.weather.service;

import com.serkaneren.weather.dto.WeatherDto;

public interface WeatherService {

    WeatherDto getAllWeatherData(float latitude, float longitude, String lang);

    WeatherDto getHourlyWeatherData(float latitude, float longitude, String lang);
}
