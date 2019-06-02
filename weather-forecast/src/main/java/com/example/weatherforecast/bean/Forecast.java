package com.example.weatherforecast.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author buildupchao
 * @date 2019-06-02 23:12
 * @since JDK 1.8
 */
@Data
public class Forecast implements Serializable {

    private String date;
    private String high;
    private String fengli;
    private String low;
    private String fengxiang;
    private String type;
}
