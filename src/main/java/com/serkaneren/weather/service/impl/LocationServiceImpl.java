package com.serkaneren.weather.service.impl;

import com.serkaneren.weather.dto.LocationDto;
import com.serkaneren.weather.exception.LocationNotFound;
import com.serkaneren.weather.service.LocationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Location service implementation
 *
 * @author eren
 */
@Service
public class LocationServiceImpl implements LocationService {

    @Value("${geocode.apikey}")
    private String geocodeApikey;

    /**
     * {@inheritDoc}
     */
    @Override
    public LocationDto getLocation(float latitude, float longitude) {
        String request = "https://geocode.xyz/" + latitude + ","+ longitude +"?json=1&auth=" + geocodeApikey;
        RestTemplate restTemplate = new RestTemplate();
        LocationDto location = restTemplate.getForEntity(request, LocationDto.class).getBody();
        if (location == null) {
            throw new LocationNotFound(latitude, longitude);
        }
        return location;
    }
}

