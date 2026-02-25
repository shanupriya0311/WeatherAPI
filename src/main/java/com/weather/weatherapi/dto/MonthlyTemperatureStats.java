package com.weather.weatherapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlyTemperatureStats {

    private int month;
    private double max;
    private double median;
    private double min;
}