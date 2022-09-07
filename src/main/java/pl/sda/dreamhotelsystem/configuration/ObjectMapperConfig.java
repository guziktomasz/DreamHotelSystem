package pl.sda.dreamhotelsystem.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.sda.dreamhotelsystem.dto.weathers.WeatherDeserializer;
import pl.sda.dreamhotelsystem.dto.weathers.WeatherDto;

@Configuration
public class ObjectMapperConfig{

    @Bean
    public ObjectMapper objectMapper() {
        //TODO
        //ObjectMapper mapper = new ObjectMapper();

        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(WeatherDto.class, new WeatherDeserializer());
        mapper.registerModule(module);
        return new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /*@Bean
    public void weatherDtoDeserializer() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(WeatherDto.class, new WeatherDeserializer(WeatherDto.class));
        objectMapper().registerModule(module);*/

    //}



}
