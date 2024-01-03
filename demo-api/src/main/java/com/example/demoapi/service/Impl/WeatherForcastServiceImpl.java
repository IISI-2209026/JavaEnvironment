package com.example.demoapi.service.Impl;

import com.bestvike.linq.Linq;
import com.example.demoapi.controller.WeatherForcast;
import com.example.demoapi.service.WeatherForcastService;
import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class WeatherForcastServiceImpl implements WeatherForcastService {

    String[] summaries = new String[] {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    @Override
    public WeatherForcast[] getWeatherForcast() {
        WeatherForcast[] weatherForcasts = Linq.range(1, 5)
            .select(index -> {
                Calendar calendar = Calendar.getInstance();
                calendar.add(Calendar.DAY_OF_YEAR, index);

                WeatherForcast weatherForcast = new WeatherForcast();
                weatherForcast.setDate(calendar.getTime());
                weatherForcast.setTemperatureC(new Random().nextInt(-20, 55));
                weatherForcast.setSummary(summaries[new Random().nextInt(summaries.length)]);
                return weatherForcast;
            })
            .toArray(WeatherForcast.class);
        return weatherForcasts;
    }
}
