package com.weather.backend.api.client;

import com.weather.backend.api.dto.weatherclient.InternalWeatherApiCollectionDto;
import com.weather.backend.api.mapper.WeatherClientDtoMapper;
import com.weather.backend.domain.exception.ApplicationException;
import com.weather.backend.domain.model.DayWeather;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class ExternalWeatherApiClient {
    private final RestTemplate restTemplate;
    private final WeatherClientDtoMapper weatherClientDtoMapper;

    public List<DayWeather> getWeather(String latitude, String longitude) {
        try {
            String url = String.format("https://api.open-meteo.com/v1/forecast" +
                    "?latitude=%s" +
                    "&longitude=%s" +
                    "&daily=weather_code,temperature_2m_max,temperature_2m_min,daylight_duration" +
                    "&timezone=Europe/Warsaw",
                latitude, longitude);
            InternalWeatherApiCollectionDto dto = restTemplate.exchange(url, HttpMethod.GET, null,
                    InternalWeatherApiCollectionDto.class)
                .getBody();
            Objects.requireNonNull(dto);
            return weatherClientDtoMapper.mapToDayWeather(dto.getData());
        } catch (RestClientException ex) {
            throw new ApplicationException("Error while fetching weather data - external API error");
        } catch (Exception ex) {
            throw new ApplicationException("Internal server error");
        }
    }
}