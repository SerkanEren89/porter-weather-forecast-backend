package com.serkaneren.weather.service.impl;

import com.serkaneren.weather.dto.WeatherDailyDataDto;
import com.serkaneren.weather.dto.WeatherDto;
import com.serkaneren.weather.dto.WeatherHourlyDataDto;
import com.serkaneren.weather.enums.IconEnum;
import com.serkaneren.weather.service.WeatherService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    public WeatherDto getAllWeatherData(float latitude, float longitude, String lang) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherDto weatherDto = restTemplate.getForEntity("https://api.darksky.net/forecast/e7a87149c31e0029912b136eef77d4cb/" +
                latitude + "," + longitude +
                "?exclude=currently,flags,hourly&units=si&lang=" + lang, WeatherDto.class).getBody();
        IconEnum icon = IconEnum.findByFrom(weatherDto.getDaily().getIcon());
        weatherDto.getDaily().setIconToShow(icon != null ? icon.getTo() : null);
        weatherDto.getDaily().getData().forEach(data -> {
            data.setDate(new Date(data.getTime() * 1000));
            data.setTemperatureHighInt(Math.round(data.getTemperatureHigh()));
            data.setTemperatureMinInt(Math.round(data.getTemperatureMin()));
        });
        return weatherDto;
    }

    @Override
    public WeatherDto getHourlyWeatherData(float latitude, float longitude, String lang) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherDto weatherDto = restTemplate.getForEntity("https://api.darksky.net/forecast/e7a87149c31e0029912b136eef77d4cb/" +
                        latitude + "," + longitude +"?exclude=currently,flags&units=si&lang=" + lang, WeatherDto.class).getBody();
        List<WeatherHourlyDataDto> firstFiveData = weatherDto.getHourly().getData().subList(0, 5);
        firstFiveData.forEach(data -> {
            data.setTemperatureInt(Math.round(data.getTemperature()));
            data.setDate(new Date(data.getTime() * 1000));

        });
        weatherDto.getHourly().setData(firstFiveData);
        IconEnum icon = IconEnum.findByFrom(weatherDto.getHourly().getIcon());
        weatherDto.getHourly().setIconToShow(icon != null ? icon.getTo() : null);
        WeatherDailyDataDto dailyData = weatherDto.getDaily().getData().get(0);
        dailyData.setTemperatureHighInt(Math.round(dailyData.getTemperatureHigh()));
        dailyData.setTemperatureMinInt(Math.round(dailyData.getTemperatureMin()));
        dailyData.setApparentTemperatureHighInt(Math.round(dailyData.getApparentTemperatureHigh()));
        dailyData.setHumidityInt(Math.round(dailyData.getHumidity() * 100));
        weatherDto.getDaily().setData(Collections.singletonList(dailyData));
        return weatherDto;
    }
}
