package com.weather.backend.api.dto.weatherclient;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InternalWeatherApiCollectionDto {
    @JsonProperty("daily")
    private InternalWeatherApiDailyDto data;
}
