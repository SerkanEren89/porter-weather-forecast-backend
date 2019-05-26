package com.serkaneren.weather.service;

import com.serkaneren.weather.dto.LanguageDto;

import java.util.List;

/**
 * Language service
 *
 * @author eren
 */
public interface LanguagesService {

    /**
     * Get languages
     * @return language dto
     */
    List<LanguageDto> getLanguages();
}
