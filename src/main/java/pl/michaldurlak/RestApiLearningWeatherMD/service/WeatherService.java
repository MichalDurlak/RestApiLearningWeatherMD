package pl.michaldurlak.RestApiLearningWeatherMD.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.michaldurlak.RestApiLearningWeatherMD.controller.ReadSecrets;
import pl.michaldurlak.RestApiLearningWeatherMD.model.WeatherDto;

@Service
@Slf4j
public class WeatherService {

    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/";

//    @Autowired
//    private pl.michaldurlak.RestApiLearningWeatherMD.ReadSecrets ReadSecrets;

    private static final String API = ReadSecrets.getProperty("API_KEY");


    private final RestTemplate restTemplate = new RestTemplate();



    public WeatherDto getWeather(String city) {

        String response = getWeatherForCity(city);
        log.info(response);
        return null;
    }

    public String getWeatherForCity(String city) {
        return restTemplate.getForObject(WEATHER_URL + "weather?q={city}&appid={apiKey}&units=metric&lang=pl", String.class, city, API);
    }
}
