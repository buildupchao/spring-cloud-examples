package com.example.weatherforecast.controller;

import com.example.weatherforecast.bean.WeatherResponse;
import com.example.weatherforecast.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author buildupchao
 * @date 2019-06-02 23:32
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/weather")
public class WeatherApi {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/city/id/{cityId}")
    public WeatherResponse getWeatherDataByCityId(@PathVariable Integer cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/city/name/{cityName}")
    public WeatherResponse getWeatherDataByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }
}
