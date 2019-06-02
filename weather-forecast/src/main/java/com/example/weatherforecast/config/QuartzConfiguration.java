package com.example.weatherforecast.config;

import com.example.weatherforecast.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author buildupchao
 * @date 2019-06-02 23:17
 * @since JDK 1.8
 */
@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(WeatherDataSyncJob.class)
                .withIdentity(WeatherDataSyncJob.JOB_ID)
                .storeDurably()
                .build();
    }


    @Bean
    public Trigger weatherDataSyncTrigger() {
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(30).repeatForever();
        return TriggerBuilder.newTrigger()
                .withIdentity(WeatherDataSyncJob.JOB_TRIGGER_ID)
                .forJob(weatherDataSyncJobDetail())
                .withSchedule(simpleScheduleBuilder)
                .build();
    }
}
