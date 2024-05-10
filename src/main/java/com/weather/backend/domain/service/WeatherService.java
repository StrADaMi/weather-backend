package com.weather.backend.domain.service;

import com.weather.backend.api.client.ExternalWeatherApiClient;
import com.weather.backend.domain.model.DayWeatherWithEnergyProduction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WeatherService {
    private final ExternalWeatherApiClient externalWeatherApiClient;
    private final EnergyProductionService energyProductionService;

    public List<DayWeatherWithEnergyProduction> getWeather(String latitude, String longitude) {
        return externalWeatherApiClient.getWeather(latitude, longitude)
            .stream()
            .map(energyProductionService::countEstimateEnergyProduction)
            .toList();
    }
}
