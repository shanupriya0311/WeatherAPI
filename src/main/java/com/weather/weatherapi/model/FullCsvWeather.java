package com.weather.weatherapi.model;

import lombok.Data;

@Data
public class FullCsvWeather {

    private String datetimeUtc;
    private String conds;
    private double dewptm;
    private int fog;
    private int hail;
    private double heatindexm;
    private double hum;
    private double precipm;
    private double pressurem;
    private int rain;
    private int snow;
    private double tempm;
    private int thunder;
    private int tornado;
    private double vism;
    private int wdird;
    private String wdire;
    private double wgustm;
    private double windchillm;
    private double wspdm;
}