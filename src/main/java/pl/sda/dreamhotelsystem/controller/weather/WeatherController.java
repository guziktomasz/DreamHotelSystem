package pl.sda.dreamhotelsystem.controller.weather;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import pl.sda.dreamhotelsystem.dto.weathers.WeatherDto;
import pl.sda.dreamhotelsystem.service.weather.WeatherService;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class WeatherController {
   private WeatherService weatherService;

    @Bean
    public Optional<WeatherDto> getWeatherTemparature(){
         return  weatherService.getTemperature();

    }
}
