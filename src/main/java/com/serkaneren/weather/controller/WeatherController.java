package com.serkaneren.weather.controller;

import com.serkaneren.weather.dto.WeatherDto;
import com.serkaneren.weather.service.WeatherService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Weather controller
 *
 * @author eren
 */
@RestController
@CrossOrigin
@RequestMapping("/weathers")
@Log4j2
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/daily")
    public ResponseEntity<WeatherDto> getAllWeatherData(@RequestParam float latitude,
                                                        @RequestParam float longitude,
                                                        @RequestParam String lang) {
        log.info("Get daily weather data with latitude: {} and longitude: {}", latitude, longitude);
        return new ResponseEntity<>(weatherService.getDailyWeatherData(latitude, longitude, lang), HttpStatus.OK);
    }

    @GetMapping("/hourly")
    public ResponseEntity<WeatherDto> getHourlyWeatherData(@RequestParam float latitude,
                                                           @RequestParam float longitude,
                                                           @RequestParam String lang) {
        log.info("Get hourly weather data with latitude: {} and longitude: {}", latitude, longitude);
        return new ResponseEntity<>(weatherService.getHourlyWeatherData(latitude, longitude, lang), HttpStatus.OK);
    }
}
