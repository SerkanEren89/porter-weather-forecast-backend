package com.serkaneren.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WeatherHourlyDataDto implements Serializable {

    private float temperature;

    private int temperatureInt;

    private Long time;

    private Date date;

    private String icon;
}
