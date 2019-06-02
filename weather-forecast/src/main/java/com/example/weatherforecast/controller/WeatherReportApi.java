package com.example.weatherforecast.controller;

import com.example.weatherforecast.service.LoadCityDataService;
import com.example.weatherforecast.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author buildupchao
 * @date 2019-06-02 23:33
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/report")
public class WeatherReportApi {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private LoadCityDataService loadCityDataService;

    @GetMapping("/city/default")
    public ModelAndView getDefaultReport(Model model) {
        return getReportByCityId(101010100, model);
    }

    @GetMapping("/city/id/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable Integer cityId, Model model) {
        model.addAttribute("title", "Weather Report");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", loadCityDataService.loadData());
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
