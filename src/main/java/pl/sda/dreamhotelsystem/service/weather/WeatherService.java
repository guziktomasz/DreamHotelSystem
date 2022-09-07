package pl.sda.dreamhotelsystem.service.weather;

import pl.sda.dreamhotelsystem.dto.weathers.WeatherDto;

import java.util.Optional;

public interface WeatherService {
    Optional<WeatherDto> getTemperature();

}
