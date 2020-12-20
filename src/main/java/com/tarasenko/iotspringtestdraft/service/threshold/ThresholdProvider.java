package com.tarasenko.iotspringtestdraft.service.threshold;

import static com.tarasenko.iotspringtestdraft.sensor.data.SensorType.HUMIDITY;
import static com.tarasenko.iotspringtestdraft.sensor.data.SensorType.TEMPERATURE;

import java.util.Map;
import java.util.function.Supplier;

import org.springframework.stereotype.Service;

import com.tarasenko.iotspringtestdraft.sensor.data.SensorType;

@Service
public class ThresholdProvider
{
  private ThresholdConfiguration thresholdConfiguration;

  public ThresholdProvider(ThresholdConfiguration thresholdConfiguration)
  {
    this.thresholdConfiguration = thresholdConfiguration;
  }

  private final Map<SensorType, Supplier<Float>> THRESHOLD_BY_TYPE = Map.of(
      TEMPERATURE, () -> thresholdConfiguration.getTemperatureThreshold(),
      HUMIDITY, () -> thresholdConfiguration.getHumidityThreshold());

  public Float getThresholdBySensorType(SensorType sensorType)
  {
    return THRESHOLD_BY_TYPE.get(sensorType).get();
  }

}
