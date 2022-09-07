package pl.sda.dreamhotelsystem.dto.weathers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;

public class WeatherDeserializer extends StdDeserializer<WeatherDto> {


    public WeatherDeserializer() {
        this(null);
    }

    public WeatherDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WeatherDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        float temperature = (float) node.get("DailyForecasts").get(0).get("Temperature").get("Minimum").get("Value").asDouble();
        System.out.println("Temperatura w WeatherDeserializer: " + temperature);
        return new WeatherDto(temperature);
    }
}
