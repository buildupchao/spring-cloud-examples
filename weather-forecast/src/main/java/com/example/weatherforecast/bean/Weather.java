package com.example.weatherforecast.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author buildupchao
 * @date 2019-06-02 23:11
 * @since JDK 1.8
 */
@Data
public class Weather implements Serializable {

    private String city;
    private String aqi;
    private String wendu;
    private String ganmao;
    private Yesterday yeaterday;
    private List<Forecast> forecast;
}
