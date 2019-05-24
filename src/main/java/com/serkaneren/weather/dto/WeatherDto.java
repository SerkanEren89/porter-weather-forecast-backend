package com.serkaneren.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WeatherDto implements Serializable {

    private float latitude;

    private float longitude;

    private DailyDto daily;

    private HourlyDto hourly;
}
