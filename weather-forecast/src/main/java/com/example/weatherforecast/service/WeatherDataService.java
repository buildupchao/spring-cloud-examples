package com.example.weatherforecast.service;

import com.example.weatherforecast.bean.WeatherResponse;

/**
 * @author buildupchao
 * @date 2019-06-02 23:10
 * @since JDK 1.8
 */
public interface WeatherDataService {

    WeatherResponse getDataByCityId(Integer cityId);

    WeatherResponse getDataByCityName(String cityName);

    void syncDataByCityId(String cityId);
}
