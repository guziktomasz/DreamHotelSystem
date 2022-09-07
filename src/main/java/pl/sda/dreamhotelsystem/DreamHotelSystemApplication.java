package pl.sda.dreamhotelsystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sda.dreamhotelsystem.configuration.HttpClientConfig;
import pl.sda.dreamhotelsystem.configuration.ObjectMapperConfig;
import pl.sda.dreamhotelsystem.providers.ExternalApiWeather;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import java.io.IOException;
import java.net.Authenticator;
import java.net.CookieHandler;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@SpringBootApplication
public class DreamHotelSystemApplication {

    public static void main(String[] args) {

        SpringApplication.run(DreamHotelSystemApplication.class, args);
        System.out.println("Hello World");



    }

}
