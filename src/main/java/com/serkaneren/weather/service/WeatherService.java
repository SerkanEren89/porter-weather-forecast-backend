package com.serkaneren.weather.service;

import com.serkaneren.weather.dto.WeatherDto;

/**
 * Weather service
 *
 * @author eren
 */
public interface WeatherService {

    /**
     * Get daily data
     *
     * @param latitude  latitude
     * @param longitude longitude
     * @param lang      language
     * @return weather dto
     */
    WeatherDto getDailyWeatherData(float latitude, float longitude, String lang);

    /**
     * Get hourly data
     *
     * @param latitude  latitude
     * @param longitude longitude
     * @param lang      language
     * @return weather dto
     */
    WeatherDto getHourlyWeatherData(float latitude, float longitude, String lang);
}
