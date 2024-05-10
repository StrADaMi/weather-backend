package com.weather.backend.domain.model;

public record DayWeather(String date, int code, Double maxTemperature, Double minTemperature, Double sunlightDuration) {
}