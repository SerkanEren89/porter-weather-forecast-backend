package com.serkaneren.weather.controller;

import com.serkaneren.weather.dto.WeatherDto;
import com.serkaneren.weather.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/weathers")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/daily")
    public ResponseEntity<WeatherDto> getAllWeatherData(@RequestParam float latitude,
                                                        @RequestParam float longitude,
                                                        @RequestParam String lang) {
        return new ResponseEntity<>(weatherService.getAllWeatherData(latitude, longitude, lang), HttpStatus.OK);
    }

    @GetMapping("/hourly")
    public ResponseEntity<WeatherDto> getHourlyWeatherData(@RequestParam float latitude,
                                                           @RequestParam float longitude,
                                                           @RequestParam String lang) {
        return new ResponseEntity<>(weatherService.getHourlyWeatherData(latitude, longitude, lang), HttpStatus.OK);
    }
}
