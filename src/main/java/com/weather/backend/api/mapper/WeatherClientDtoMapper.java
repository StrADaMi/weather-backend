package com.weather.backend.api.mapper;

import com.weather.backend.api.dto.weatherclient.InternalWeatherApiDailyDto;
import com.weather.backend.domain.model.DayWeather;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class WeatherClientDtoMapper {
    public List<DayWeather> mapToDayWeather(InternalWeatherApiDailyDto dto) {
        return IntStream.range(0, dto.getDayDates().size())
                .mapToObj(i -> new DayWeather(
                        dto.getDayDates().get(i),
                        dto.getWeatherCodes().get(i),
                        dto.getMaxTemperatures().get(i),
                        dto.getMinTemperatures().get(i),
                        dto.getDaylightDurations().get(i)))
                .collect(Collectors.toList());
    }
}