package pl.michaldurlak.RestApiLearningWeatherMD.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.michaldurlak.RestApiLearningWeatherMD.model.WeatherDto;
import pl.michaldurlak.RestApiLearningWeatherMD.service.WeatherService;

//@RestController
@RequiredArgsConstructor
@Controller
public class WeatherController {

    private  final WeatherService weatherService;



//    @GetMapping(value = "/pogoda")
//    public WeatherDto getWeather(@RequestParam String city){
//        return weatherService.getWeather(city);
//    }

    @GetMapping("/weather")
    String weather (@RequestParam(name="city", required=false, defaultValue="Warszawa") String city, Model model){
        model.addAttribute("city", city.substring(0, 1).toUpperCase() + city.substring(1));
        String infoWeatherSpecifyCity = weatherService.getWeatherForCity(city);
        model.addAttribute("infoWeatherSpecifyCity", infoWeatherSpecifyCity);
        return "weather";
    }

}
