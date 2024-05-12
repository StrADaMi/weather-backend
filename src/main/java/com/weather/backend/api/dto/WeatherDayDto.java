package com.weather.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WeatherDayDto {
    private String date;
    private int weatherCode;
    private Double maxTemperature;
    private Double minTemperature;
    private Double estimateEnergyProductionInKWh;
}