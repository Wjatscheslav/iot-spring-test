package com.tarasenko.iotspringtestdraft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tarasenko.iotspringtestdraft.service.WeatherAlarmService;
import com.tarasenko.iotspringtestdraft.service.WeatherStatsService;

@Controller
public class WeatherController
{

  private final WeatherStatsService weatherStatsService;
  private final WeatherAlarmService weatherAlarmService;

  public WeatherController(WeatherStatsService weatherStatsService, WeatherAlarmService weatherAlarmService)
  {
    this.weatherStatsService = weatherStatsService;
    this.weatherAlarmService = weatherAlarmService;
  }

  @GetMapping("/")
  public String home(Model model)
  {
    return "index";
  }

  @GetMapping("/weather")
  public String stats(Model model)
  {
    addWeatherStats(model);
    addWeatherAlarms(model);
    return "weather";
  }

  @GetMapping("/reset")
  public String reset(Model model)
  {
    weatherStatsService.clearWeatherStats();
    weatherAlarmService.clearWeatherAlarms();
    return "index";
  }

  private void addWeatherStats(Model model)
  {
    model.addAttribute("weatherStats", weatherStatsService.getWeatherStats());
  }

  private void addWeatherAlarms(Model model)
  {
    model.addAttribute("weatherAlarms", weatherAlarmService.getWeatherAlarms());
  }
}
