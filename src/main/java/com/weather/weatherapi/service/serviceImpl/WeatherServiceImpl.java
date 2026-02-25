package com.weather.weatherapi.service.serviceImpl;
import com.weather.weatherapi.dto.TemperatureStats;
import com.weather.weatherapi.model.Weather;
import com.weather.weatherapi.repository.WeatherRepository;
import com.weather.weatherapi.service.WeatherService;
import com.weather.weatherapi.util.CsvReader;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.weather.weatherapi.dto.MonthlyTemperatureStats;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repo;

    public WeatherServiceImpl(WeatherRepository repo) {
        this.repo = repo;
    }
   @Override
public List<MonthlyTemperatureStats> getYearStats(int year) {

    List<MonthlyTemperatureStats> result = new ArrayList<>();

    for (int month = 1; month <= 12; month++) {

        List<Double> temps =
                getByMonth(year, month)
                        .stream()
                        .map(Weather::getTemperature)
                        .sorted()
                        .collect(Collectors.toList());

        if (temps.isEmpty()) continue;

        double min = temps.get(0);
        double max = temps.get(temps.size() - 1);

        double median =
                temps.size() % 2 == 0 ?
                        (temps.get(temps.size() / 2 - 1) + temps.get(temps.size() / 2)) / 2
                        : temps.get(temps.size() / 2);

        result.add(new MonthlyTemperatureStats(month, max, median, min));
    }

    return result;
}
    @Override
    public void importCsv(MultipartFile file) throws Exception {
        repo.saveAll(CsvReader.read(file));
    }

    @Override
    public List<Weather> getByMonth(int year, int month) {

        YearMonth ym = YearMonth.of(year, month);

        LocalDateTime start = ym.atDay(1).atStartOfDay();
        LocalDateTime end = ym.atEndOfMonth().atTime(23, 59);

        return repo.findByDateBetween(start, end);
    }

    @Override
    public TemperatureStats getStats(int year, int month) {

        List<Double> temps =
                getByMonth(year, month)
                        .stream()
                        .map(Weather::getTemperature)
                        .sorted()
                        .collect(Collectors.toList());

        if (temps.isEmpty())
            return new TemperatureStats(0, 0, 0);

        double min = temps.get(0);
        double max = temps.get(temps.size() - 1);

        double median =
                temps.size() % 2 == 0 ?
                        (temps.get(temps.size() / 2 - 1) + temps.get(temps.size() / 2)) / 2
                        : temps.get(temps.size() / 2);

        return new TemperatureStats(max, median, min);
    }
}