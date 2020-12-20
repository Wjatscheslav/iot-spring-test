package com.tarasenko.iotspringtestdraft.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tarasenko.iotspringtestdraft.repository.WeatherStatsRepository;
import com.tarasenko.iotspringtestdraft.sensor.data.SensorData;
import com.tarasenko.iotspringtestdraft.sensor.data.WeatherMeasurement;
import com.tarasenko.iotspringtestdraft.data.WeatherStats;

@Service
public class WeatherStatsService
{

  private static final Logger LOG = LoggerFactory.getLogger(WeatherStatsService.class);

  private final WeatherStatsRepository weatherStatsRepository;

  public WeatherStatsService(WeatherStatsRepository weatherStatsRepository)
  {
    this.weatherStatsRepository = weatherStatsRepository;
  }

  public List<WeatherStats> getWeatherStats()
  {
    return weatherStatsRepository.getAllWeatherStats();
  }

  public void updateStats(WeatherMeasurement measurement)
  {
    Float value = measurement.getValue();
    SensorData sensorData = measurement.getSensorData();
    Optional.ofNullable(weatherStatsRepository.getWeatherStats(sensorData.getId()))
        .ifPresentOrElse(stats -> stats.recalculateStats(value), () -> initStatsForSensor(sensorData, value));
    LOG.debug("Stats were updated. {value: \"{}\", sensor: \"{}\"}", value, sensorData.getId());
  }

  private void initStatsForSensor(SensorData sensorData, Float value)
  {
    weatherStatsRepository.putWeatherStats(sensorData.getId(), new WeatherStats(value, sensorData.getType().name()));
  }

  public void clearWeatherStats()
  {
    weatherStatsRepository.clearStats();
  }
}
