package com.tarasenko.iotspringtestdraft.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tarasenko.iotspringtestdraft.repository.WeatherAlarmRepository;
import com.tarasenko.iotspringtestdraft.sensor.data.SensorData;
import com.tarasenko.iotspringtestdraft.sensor.data.WeatherMeasurement;
import com.tarasenko.iotspringtestdraft.service.threshold.ThresholdProvider;
import com.tarasenko.iotspringtestdraft.data.WeatherAlarm;

@Service
public class WeatherAlarmService
{

  private static final Logger LOG = LoggerFactory.getLogger(WeatherAlarmService.class);

  private final WeatherAlarmRepository weatherAlarmRepository;
  private final ThresholdProvider thresholdProvider;

  public WeatherAlarmService(WeatherAlarmRepository weatherAlarmRepository, ThresholdProvider thresholdProvider)
  {
    this.weatherAlarmRepository = weatherAlarmRepository;
    this.thresholdProvider = thresholdProvider;
  }

  public List<WeatherAlarm> getWeatherAlarms()
  {
    return weatherAlarmRepository.getWeatherAlarms();
  }

  public void updateAlarms(WeatherMeasurement measurement)
  {
    if (isThresholdExceeded(measurement))
    {
      Float value = measurement.getValue();
      SensorData sensorData = measurement.getSensorData();
      weatherAlarmRepository.getWeatherAlarms().add(new WeatherAlarm(sensorData.getType().name(), value));
      LOG.debug("Alarm was generated. {value: \"{}\", sensor: \"{}\"}", value, sensorData.getId());
    }
  }

  public void clearWeatherAlarms()
  {
    weatherAlarmRepository.clearAlarms();
  }

  private boolean isThresholdExceeded(WeatherMeasurement measurement)
  {
    Float threshold = thresholdProvider.getThresholdBySensorType(measurement.getSensorData().getType());
    return measurement.getValue() > threshold;
  }

}
