package com.example.demoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoapi.service.WeatherForcastService;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(value = "/weatherforcast")
@Component
public class WeatherForcastController {
    String[] summaries = new String[] {
        "Freezing", "Bracing", "Chilly", "Cool", "Mild", "Warm", "Balmy", "Hot", "Sweltering", "Scorching"
    };

    private final WeatherForcastService weatherForcastService;

    @Autowired
    public WeatherForcastController(WeatherForcastService weatherForcastService) {
        this.weatherForcastService = weatherForcastService;
    }

    @GetMapping
    public WeatherForcast[] getWeatherForcast() {
        return this.weatherForcastService.getWeatherForcast();
    }
}