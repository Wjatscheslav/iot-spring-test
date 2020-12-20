package com.tarasenko.iotspringtestdraft.service.threshold;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThresholdConfiguration
{

  @Value("${weather.analyzer.threshold.temperature}")
  private float temperatureThreshold;
  @Value("${weather.analyzer.threshold.humidity}")
  private float humidityThreshold;

  public float getTemperatureThreshold()
  {
    return temperatureThreshold;
  }

  public float getHumidityThreshold()
  {
    return humidityThreshold;
  }
}
