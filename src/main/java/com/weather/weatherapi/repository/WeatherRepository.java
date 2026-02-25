package com.weather.weatherapi.repository;

import com.weather.weatherapi.model.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.time.LocalDateTime;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends MongoRepository<Weather,String> {
List<Weather> findByDateBetween(LocalDateTime start, LocalDateTime end);
}