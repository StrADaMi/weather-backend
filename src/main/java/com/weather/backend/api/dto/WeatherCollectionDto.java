package com.weather.backend.api.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class WeatherCollectionDto {
    private List<WeatherDayDto> dailyWeather;
}