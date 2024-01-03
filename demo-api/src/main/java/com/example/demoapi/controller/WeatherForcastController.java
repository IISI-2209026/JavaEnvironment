package com.example.demoapi.controller;

import java.util.Date;
import java.util.Calendar;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestvike.linq.Linq;
// import io.reactivex.rxjava3.core.*;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/weatherforcast")
public class WeatherForcastController {
    String[] summaries = new String[] {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    @GetMapping
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