package com.serkaneren.weather.controller;

import com.serkaneren.weather.dto.LocationDto;
import com.serkaneren.weather.service.LocationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Location controller
 *
 * @author eren
 */
@RestController
@CrossOrigin
@Log4j2
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<LocationDto> getLocation(@RequestParam float latitude,
                                                   @RequestParam float longitude) {
        log.info("Get location with latitude: {} and longitude: {}", latitude, longitude);
        return new ResponseEntity<>(locationService.getLocation(latitude, longitude), HttpStatus.OK);
    }
}
