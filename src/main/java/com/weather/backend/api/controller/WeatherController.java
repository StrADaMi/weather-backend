package com.weather.backend.api.controller;

import com.weather.backend.api.dto.WeatherCollectionDto;
import com.weather.backend.api.mapper.WeatherDtoMapper;
import com.weather.backend.domain.model.DayWeatherWithEnergyProduction;
import com.weather.backend.domain.service.WeatherService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class WeatherController {
    private final WeatherService weatherService;
    private final WeatherDtoMapper weatherDtoMapper;

    @GetMapping("/api/v1/weather/daily")
    public ResponseEntity<WeatherCollectionDto> content(

            @Min(value = -90, message = "Latitude must be between -90 and 90")
            @Max(value = 90, message = "Latitude must be between -90 and 90")
            @RequestParam(value = "latitude", required = false) String latitude,

            @Min(value = -180, message = "Latitude must be between -180 and 180")
            @Max(value = 180, message = "Latitude must be between -180 and 180")
            @RequestParam(value = "longitude", required = false) String longitude) {

        List<DayWeatherWithEnergyProduction> weathers = weatherService.getWeather(latitude, longitude);
        WeatherCollectionDto weather = weatherDtoMapper.mapToDto(weathers);
        return ResponseEntity.ok()
                .body(weather);
    }
}