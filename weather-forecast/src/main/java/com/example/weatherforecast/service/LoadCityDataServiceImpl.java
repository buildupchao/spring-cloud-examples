package com.example.weatherforecast.service;

import com.example.weatherforecast.bean.City;
import com.example.weatherforecast.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author buildupchao
 * @date 2019-06-02 23:22
 * @since JDK 1.8
 */
@Slf4j
@Service
public class LoadCityDataServiceImpl implements LoadCityDataService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public List<City> loadData() {
        String filepath = System.getProperty("user.dir") + "/weather-forecast/src/main/resources/city.json";
        List<City> cityList = new ArrayList<>(0);
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(filepath));
            cityList = JsonUtils.jsonToBeanList(new String(bytes), City.class);
            log.info(
                    "load city data success, size={}.",
                    Optional.ofNullable(cityList).orElse(new ArrayList<>(0)).size()
            );
        } catch (IOException e) {
            log.error("load city data error!", e);
        }
        return cityList;
    }
}
