package com.example.weatherforecast.service;

import com.example.weatherforecast.bean.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author buildupchao
 * @date 2019-06-02 23:26
 * @since JDK 1.8
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getDataByCityId(Integer cityId) {
        return weatherDataService.getDataByCityId(cityId).getData();
    }
}
