package com.example.demoapi.controller;

import java.util.*;
import lombok.Data;

@Data
public class WeatherForcast
{
    private int temperatureC;
    private String summary;
    private Date date;

    public int TemperatureF() {
        return 32 + (int)(temperatureC / 0.5556);
    }
}