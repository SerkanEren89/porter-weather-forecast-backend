package com.serkaneren.weather.controller;

import com.serkaneren.weather.dto.LanguageDto;
import com.serkaneren.weather.service.LanguagesService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Language controller
 *
 * @author eren
 */
@RestController
@CrossOrigin
@Log4j2
@RequestMapping("/languages")
public class LanguageController {

    private final LanguagesService languagesService;

    public LanguageController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getLanguages() {
        log.info("Get all languages");
        return new ResponseEntity<>(languagesService.getLanguages(), HttpStatus.OK);
    }
}
