package com.serkaneren.weather.service;

import com.serkaneren.weather.dto.LocationDto;

/**
 * Location service
 *
 * @author eren
 */
public interface LocationService {

    LocationDto getLocation(float latitude, float longitude);
}
