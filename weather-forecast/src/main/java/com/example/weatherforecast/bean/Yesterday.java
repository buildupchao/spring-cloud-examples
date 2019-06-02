package com.example.weatherforecast.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author buildupchao
 * @date 2019-06-02 23:11
 * @since JDK 1.8
 */
@Data
public class Yesterday implements Serializable {
    private String date;
    private String high;
    private String fx;
    private String low;
    private String fl;
    private String type;
}
