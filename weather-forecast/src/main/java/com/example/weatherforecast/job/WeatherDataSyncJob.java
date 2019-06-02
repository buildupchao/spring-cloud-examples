package com.example.weatherforecast.job;

import com.example.weatherforecast.bean.City;
import com.example.weatherforecast.service.LoadCityDataService;
import com.example.weatherforecast.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * @author buildupchao
 * @date 2019-06-02 23:14
 * @since JDK 1.8
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    public static final String JOB_ID = "weatherDataSyncJob";
    public static final String JOB_TRIGGER_ID = "weatherDataSyncTrigger";

    @Autowired
    private LoadCityDataService loadCityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Start sync weather data job>>>>>>{}", System.currentTimeMillis());
        List<City> cities = loadCityDataService.loadData();
        if (CollectionUtils.isNotEmpty(cities)) {
            for (City city : cities) {
                weatherDataService.syncDataByCityId(city.getCityId());
            }
        }
        log.info("End sync weather data job>>>>>>{}", System.currentTimeMillis());
    }
}
