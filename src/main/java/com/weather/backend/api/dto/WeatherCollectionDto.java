package com.weather.backend.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class WeatherCollectionDto {
    private List<WeatherDayDto> dailyWeather;
}