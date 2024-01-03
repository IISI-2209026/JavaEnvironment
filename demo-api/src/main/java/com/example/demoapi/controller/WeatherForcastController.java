package com.example.demoapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demoapi.service.WeatherForcastService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/weatherforcast")
@Component
@Slf4j
public class WeatherForcastController {
    // private static final Logger log =
    //     LoggerFactory.getLogger(WeatherForcastController.class);

    private final WeatherForcastService weatherForcastService;

    @Autowired
    public WeatherForcastController(WeatherForcastService weatherForcastService) {
        this.weatherForcastService = weatherForcastService;
    }

    @GetMapping
    public WeatherForcast[] getWeatherForcast() {
        log.info("call getWeatherForcast");
        return this.weatherForcastService.getWeatherForcast();
    }
}