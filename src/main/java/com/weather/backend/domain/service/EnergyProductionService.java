package com.weather.backend.domain.service;

import com.weather.backend.domain.model.DayWeather;
import com.weather.backend.domain.model.DayWeatherWithEnergyProduction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnergyProductionService {
    private static final Double POWER_OF_SUNLIGHT_INSTALLATION_KW = 2.5;
    private static final Double SUNLIGHT_EFFECTIVITY = 0.2;

    public DayWeatherWithEnergyProduction countEstimateEnergyProduction(DayWeather dayWeather) {
        Double sunlightDurationInHours = dayWeather.sunlightDuration() / 3600.0;
        Double estimateEnergyProduction = sunlightDurationInHours * POWER_OF_SUNLIGHT_INSTALLATION_KW * SUNLIGHT_EFFECTIVITY;
        return new DayWeatherWithEnergyProduction(dayWeather, estimateEnergyProduction);
    }
}
