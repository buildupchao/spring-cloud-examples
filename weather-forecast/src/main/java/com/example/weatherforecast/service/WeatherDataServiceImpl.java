package com.example.weatherforecast.service;

import com.example.weatherforecast.bean.WeatherResponse;
import com.example.weatherforecast.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author buildupchao
 * @date 2019-06-02 23:25
 * @since JDK 1.8
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    @Value("${WEATHER_URL_BY_CITYID}")
    private String WEATHER_URL_BY_CITYID;

    @Value("${WEATHER_URL_BY_CITYNAME}")
    private String WEATHER_URL_BY_CITYNAME;

    @Value("${REDIS_EVIT_TIME}")
    private Long REDIS_EVIT_TIME;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(Integer cityId) {
        log.info("get data by city id start...");
        String url = WEATHER_URL_BY_CITYID + cityId;
        return doGetWeather(url);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        log.info("get data by city name start...");
        String url = WEATHER_URL_BY_CITYNAME + cityName;
        return doGetWeather(url);
    }

    @Override
    public void syncDataByCityId(String cityId) {
        saveWeatherData(WEATHER_URL_BY_CITYID + cityId);
    }

    private WeatherResponse doGetWeather(String url) {
        String key = url;
        String jsonData = null;
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)) {
            log.info("Redis has data, get data from redis.");
            jsonData = opsForValue.get(key);
        } else {
            log.info("Cannot get data from redis.");
            jsonData = restTemplate.getForObject(url, String.class);
            opsForValue.set(key, jsonData, REDIS_EVIT_TIME, TimeUnit.SECONDS);
        }
        WeatherResponse response = JsonUtils.jsonToBean(jsonData, WeatherResponse.class);
        return response;
    }

    private void saveWeatherData(String url) {
        log.info("load data into redis for url={}.", url);
        String key = url;
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String jsonData = restTemplate.getForObject(url, String.class);
        ops.set(key, jsonData, REDIS_EVIT_TIME, TimeUnit.SECONDS);;
    }
}
