package com.weather.weatherapi.service;

import com.weather.weatherapi.dto.MonthlyTemperatureStats;
import com.weather.weatherapi.dto.TemperatureStats;
import com.weather.weatherapi.model.Weather;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface WeatherService {

    void importCsv(MultipartFile file) throws Exception;

    List<Weather> getByMonth(int year, int month);

    TemperatureStats getStats(int year, int month);

    List<MonthlyTemperatureStats> getYearStats(int year);
}