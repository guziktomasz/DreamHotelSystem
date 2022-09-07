package pl.sda.dreamhotelsystem.dto.weathers;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class WeatherDto {
    private float temperatureValue;
}
