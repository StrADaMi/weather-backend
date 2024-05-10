package com.weather.backend.api.dto.weatherclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class InternalWeatherApiDailyDto {
    @JsonProperty("time")
    private List<String> dayDates;

    @JsonProperty("weather_code")
    private List<Integer> weatherCodes;

    @JsonProperty("temperature_2m_max")
    private List<Double> maxTemperatures;

    @JsonProperty("temperature_2m_min")
    private List<Double> minTemperatures;

    @JsonProperty("daylight_duration")
    private List<Double> daylightDurations;
}