package pl.michaldurlak.RestApiLearningWeatherMD.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michaldurlak.RestApiLearningWeatherMD.model.WeatherDto;

import java.net.http.HttpClient;

@Service
@Slf4j
public class WeatherService {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";
    private static final String API = "PRIVATE";


    private RestTemplate restTemplate = new RestTemplate();



    public WeatherDto getWeather(String city) {

        String response = getWeatherForCity(city);
        log.info(response);
        return null;
    }

    public String getWeatherForCity(String city) {
        return restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={apiKey}&units=metric&lang=pl", String.class, city, API);
    }
}
