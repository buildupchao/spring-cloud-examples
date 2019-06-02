package com.example.weatherforecast.service;

import com.example.weatherforecast.bean.City;

import java.util.List;

/**
 * @author buildupchao
 * @date 2019-06-02 23:09
 * @since JDK 1.8
 */
public interface LoadCityDataService {

    List<City> loadData();
}
