package com.weather.weatherapi.util;

import com.opencsv.CSVReader;
import com.weather.weatherapi.exception.CsvImportException;
import com.weather.weatherapi.model.FullCsvWeather;
import com.weather.weatherapi.model.Weather;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    public static List<Weather> read(MultipartFile file) {

        try (CSVReader reader =
                     new CSVReader(new InputStreamReader(file.getInputStream()))) {

            List<Weather> result = new ArrayList<>();
            reader.readNext(); // skip header

            String[] row;
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyyMMdd-HH:mm");

            while ((row = reader.readNext()) != null) {

                FullCsvWeather raw = new FullCsvWeather();

                raw.setDatetimeUtc(row[0]);
                raw.setConds(row[1]);
                raw.setDewptm(parse(row[2]));
                raw.setFog(parseInt(row[3]));
                raw.setHail(parseInt(row[4]));
                raw.setHeatindexm(parse(row[5]));
                raw.setHum(parse(row[6]));
                raw.setPrecipm(parse(row[7]));
                raw.setPressurem(parse(row[8]));
                raw.setRain(parseInt(row[9]));
                raw.setSnow(parseInt(row[10]));
                raw.setTempm(parse(row[11]));

                // ---- Convert RAW → Weather ----

                Weather w = new Weather();

                w.setDate(LocalDateTime.parse(raw.getDatetimeUtc(), formatter));
                w.setCondition(raw.getConds());
                w.setTemperature(raw.getTempm());
                w.setHumidity(raw.getHum());
                w.setPressure(raw.getPressurem());

                result.add(w);
            }

            return result;

        } catch (Exception e) {
            throw new CsvImportException("CSV format invalid");
        }
    }

    private static double parse(String v) {
        if (v == null || v.isBlank() || v.equals("-9999")) return 0;
        return Double.parseDouble(v);
    }

    private static int parseInt(String v) {
        if (v == null || v.isBlank() || v.equals("-9999")) return 0;
        return Integer.parseInt(v);
    }
}