package com.tarasenko.iotspringtestdraft.analyzer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.tarasenko.iotspringtestdraft.sensor.Sensor;
import com.tarasenko.iotspringtestdraft.sensor.data.WeatherMeasurement;
import com.tarasenko.iotspringtestdraft.service.WeatherAlarmService;
import com.tarasenko.iotspringtestdraft.service.WeatherStatsService;

@Component
public class WeatherAnalyzer implements Analyzer<WeatherMeasurement>
{
  private final List<Sensor<WeatherMeasurement>> sensors;
  private final WeatherAlarmService weatherAlarmService;
  private final WeatherStatsService weatherStatsService;

  public WeatherAnalyzer(List<Sensor<WeatherMeasurement>> sensors, WeatherAlarmService weatherAlarmService,
                         WeatherStatsService weatherStatsService)
  {
    this.sensors = sensors;
    this.sensors.forEach(sensor -> sensor.registerAnalyzer(this));
    this.weatherAlarmService = weatherAlarmService;
    this.weatherStatsService = weatherStatsService;
  }

  @Override
  public void updateState(WeatherMeasurement measurement)
  {
    weatherStatsService.updateStats(measurement);
    weatherAlarmService.updateAlarms(measurement);
  }
}
