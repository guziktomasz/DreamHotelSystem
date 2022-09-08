package pl.sda.dreamhotelsystem.providers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.dreamhotelsystem.config.AppConfig;
import pl.sda.dreamhotelsystem.configuration.ObjectMapperConfig;
import pl.sda.dreamhotelsystem.dto.weathers.WeatherDeserializer;
import pl.sda.dreamhotelsystem.dto.weathers.WeatherDto;
import pl.sda.dreamhotelsystem.service.weather.WeatherService;

@Service
@AllArgsConstructor
public class ExternalApiWeather implements WeatherService {

    private ObjectMapper objectMapper;
    private HttpClient httpClient;

    private AppConfig appConfig;

    @Override
    public Optional<WeatherDto> getTemperature() {

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("http://dataservice.accuweather.com/forecasts/v1/daily/1day/275788?apikey="
                            + appConfig.getApiKey()))
                    .GET()
                    .build();
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return Optional.ofNullable(objectMapper.readValue(response.body(), WeatherDto.class));

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.ofNullable(new WeatherDto(50, "F"));
        }
    }
}
