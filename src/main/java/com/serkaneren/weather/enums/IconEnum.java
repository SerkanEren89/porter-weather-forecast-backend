package com.serkaneren.weather.enums;

import lombok.Getter;

import java.util.Arrays;

public enum IconEnum {

    RAIN("rain", "rainy"),
    SUNNY("clear-day", "sunny");

    @Getter
    String from;

    @Getter
    String to;

    public static IconEnum findByFrom(final String from){
        return Arrays.stream(values()).filter(value -> value.getFrom().equals(from)).findFirst().orElse(null);
    }

    IconEnum(String from, String to) {
        this.from = from;
        this.to = to;
    }
}
