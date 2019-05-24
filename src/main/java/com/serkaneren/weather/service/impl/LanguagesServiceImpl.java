package com.serkaneren.weather.service.impl;

import com.serkaneren.weather.dto.LanguageDto;
import com.serkaneren.weather.enums.LanguageEnum;
import com.serkaneren.weather.service.LanguagesService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguagesServiceImpl implements LanguagesService {

    @Override
    public List<LanguageDto> getLanguages() {
        return Arrays.stream(LanguageEnum.values()).map(lang -> {
         return new LanguageDto(lang.getAbbr(), lang.getLang());
        }).collect(Collectors.toList());
    }
}
