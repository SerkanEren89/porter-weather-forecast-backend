package com.serkaneren.weather.controller;

import com.serkaneren.weather.dto.LanguageDto;
import com.serkaneren.weather.service.LanguagesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/languages")
public class LanguageController {

    private final LanguagesService languagesService;

    public LanguageController(LanguagesService languagesService) {
        this.languagesService = languagesService;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getLanguages() {
        return new ResponseEntity<>(languagesService.getLanguages(), HttpStatus.OK);
    }
}
