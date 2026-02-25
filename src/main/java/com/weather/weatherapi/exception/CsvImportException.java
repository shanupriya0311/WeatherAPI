package com.weather.weatherapi.exception;

public class CsvImportException extends RuntimeException {

    public CsvImportException(String message) {
        super(message);
    }
}