package pl.sda.dreamhotelsystem.controller.weather;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.dreamhotelsystem.domain.Weather;
import pl.sda.dreamhotelsystem.dto.weathers.WeatherDto;
import pl.sda.dreamhotelsystem.service.weather.WeatherService;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/weatherToday")
@AllArgsConstructor
public class WeatherController {
    private WeatherService weatherService;
    @GetMapping
    public Weather getActuallyWeatherInCelsius(){
        float celsiusTemperature = (weatherService.getTemperature().get().getTemperatureValue() - 32) * 5/9;
        celsiusTemperature = Math.round(celsiusTemperature);
        Weather weatherMan = new Weather(celsiusTemperature,"C");

        System.out.println(weatherMan);
        return weatherMan;
    }
}


