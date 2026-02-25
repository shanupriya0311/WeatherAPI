package com.weather.weatherapi.controller;

import com.weather.weatherapi.dto.TemperatureStats;
import com.weather.weatherapi.model.Weather;
import com.weather.weatherapi.service.WeatherService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartFile;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service){
        this.service = service;
    }

    
 @PostMapping("/import")
public String importCsv(@RequestParam("file") MultipartFile file) throws Exception {
    service.importCsv(file);
    return "CSV Imported Successfully";
}
    
    @GetMapping("/month")
    public List<Weather> byMonth(@RequestParam int year,@RequestParam int month){
        return service.getByMonth(year,month);
    }

  
    @GetMapping("/stats")
    public TemperatureStats stats(@RequestParam int year,@RequestParam int month){
        return service.getStats(year,month);
    }
}