package com.example.demoapi.controller;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class WeatherForcast
{
    private int temperatureC;
    private String summary;
    private Date date;

    public WeatherForcast() {

    }
    public WeatherForcast(int temperatureC, String summary, Date date) {
        this.temperatureC = temperatureC;
        this.summary = summary;
        this.date = date;
    }

    @JsonProperty("temperatureF")
    public int TemperatureF() {
        return 32 + (int)(temperatureC / 0.5556);
    }
}