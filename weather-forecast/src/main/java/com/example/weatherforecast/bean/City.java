package com.example.weatherforecast.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author buildupchao
 * @date 2019-06-02 23:10
 * @since JDK 1.8
 */
@Data
public class City implements Serializable {
    private String cityName;
    private String cityId;
}
