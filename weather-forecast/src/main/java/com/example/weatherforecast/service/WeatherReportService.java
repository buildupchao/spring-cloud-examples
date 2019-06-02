package com.example.weatherforecast.service;

import com.example.weatherforecast.bean.Weather;

/**
 * @author buildupchao
 * @date 2019-06-02 23:10
 * @since JDK 1.8
 */
public interface WeatherReportService {

    Weather getDataByCityId(Integer cityId);
}
