package pl.sda.dreamhotelsystem.controller.weather;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import pl.sda.dreamhotelsystem.domain.Weather;
import pl.sda.dreamhotelsystem.dto.weathers.WeatherDto;
import pl.sda.dreamhotelsystem.service.weather.WeatherService;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class WeatherController {
    private WeatherService weatherService;
    @Bean
    public Weather getActuallyWeatherInCelsius(){

        float celsiusTemperature = (weatherService.getTemperature().get().getTemperatureValue() - 32) * 5/9;

        Weather weatherMan = new Weather(celsiusTemperature,"C");

        System.out.println(weatherMan);
        return weatherMan;
    }
}


