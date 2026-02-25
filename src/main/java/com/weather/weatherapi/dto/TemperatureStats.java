package com.weather.weatherapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TemperatureStats {

    private double max;
    private double median;
    private double min;
}