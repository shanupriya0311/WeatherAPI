package com.weather.weatherapi.util;

import com.opencsv.CSVReader;
import com.weather.weatherapi.model.Weather;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Weather> read(MultipartFile file) throws Exception {

        List<Weather> list = new ArrayList<>();

        CSVReader reader =
                new CSVReader(new InputStreamReader(file.getInputStream()));

        String[] row;
        reader.readNext(); // skip header

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
    }

    // ✅ THIS MUST BE OUTSIDE read()
    private static double parseDoubleSafe(String value) {
        if (value == null || value.trim().isEmpty()) {
            return 0.0;
        }
        return Double.parseDouble(value.trim());
    }
}