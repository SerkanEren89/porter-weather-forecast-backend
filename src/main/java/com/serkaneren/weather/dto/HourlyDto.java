package com.serkaneren.weather.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HourlyDto {
    private String summary;

    private String icon;

    private String iconToShow;

    private List<WeatherHourlyDataDto> data;
}
