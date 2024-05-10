package com.weather.backend.api.mapper;

import com.weather.backend.api.dto.WeatherCollectionDto;
import com.weather.backend.api.dto.WeatherDayDto;
import com.weather.backend.domain.model.DayWeather;
import com.weather.backend.domain.model.DayWeatherWithEnergyProduction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherDtoMapper {
    public WeatherCollectionDto mapToDto(List<DayWeatherWithEnergyProduction> weathers) {
        List<WeatherDayDto> dtos = weathers.stream()
            .map(this::mapToDto)
            .toList();

        return new WeatherCollectionDto(dtos);
    }

    private WeatherDayDto mapToDto(DayWeatherWithEnergyProduction model) {
        DayWeather dayWeather = model.dayWeather();
        return new WeatherDayDto(
            dayWeather.date(),
            dayWeather.code(),
            dayWeather.maxTemperature(),
            dayWeather.minTemperature(),
            model.estimateEnergyProduction()
        );
    }
}
