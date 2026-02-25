package com.weather.weatherapi.util;

import com.opencsv.CSVReader;
import com.weather.weatherapi.exception.CsvImportException;
import com.weather.weatherapi.model.Weather;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Weather> read(MultipartFile file) {

        try {

            List<Weather> list = new ArrayList<>();

            CSVReader reader =
                    new CSVReader(new InputStreamReader(file.getInputStream()));

            String[] row;

            reader.readNext();

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");

            while ((row = reader.readNext()) != null) {

                Weather w = new Weather();

                w.setDate(LocalDateTime.parse(row[0], formatter));
                w.setCondition(row[1]);

                w.setTemperature(parseDoubleSafe(row[2]));
                w.setHumidity(parseDoubleSafe(row[3]));
                w.setPressure(parseDoubleSafe(row[4]));

                list.add(w);
            }

            return list;

        } catch (Exception e) {
            throw new CsvImportException(
                    "CSV file format is invalid or contains bad data"
            );
        }
    }
    private static double parseDoubleSafe(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(value.trim());
    }
}