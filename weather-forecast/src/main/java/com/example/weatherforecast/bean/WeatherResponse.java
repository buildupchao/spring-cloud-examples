package com.example.weatherforecast.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author buildupchao
 * @date 2019-06-02 23:13
 * @since JDK 1.8
 */
@Data
public class WeatherResponse implements Serializable {
    private Weather data;
    private Integer status;
    private String desc;
}
