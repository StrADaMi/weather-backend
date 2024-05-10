package com.weather.backend.domain.model;

public record DayWeatherWithEnergyProduction(DayWeather dayWeather, Double estimateEnergyProduction) {
}