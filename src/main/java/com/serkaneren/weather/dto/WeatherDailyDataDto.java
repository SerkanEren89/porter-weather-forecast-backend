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
public class WeatherDailyDataDto implements Serializable {

    private float temperatureHigh;

    private int temperatureHighInt;

    private float temperatureMin;

    private int temperatureMinInt;

    private float apparentTemperatureHigh;

    private int apparentTemperatureHighInt;

    private float humidity;

    private int humidityInt;

    private Long time;

    private Date date;
}
