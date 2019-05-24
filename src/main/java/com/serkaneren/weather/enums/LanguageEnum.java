package com.serkaneren.weather.enums;

import lombok.Getter;

import java.util.Arrays;

public enum LanguageEnum {

    ENGLISH("en", "English"),
    GERMAN("de", "Deutsch"),
    TURKISH("tr", "Turkish");

    @Getter
    String abbr;

    @Getter
    String lang;

    LanguageEnum(String abbr, String lang) {
        this.abbr = abbr;
        this.lang = lang;
    }
}
