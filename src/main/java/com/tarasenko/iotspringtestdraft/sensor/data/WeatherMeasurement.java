package com.tarasenko.iotspringtestdraft.sensor.data;

public class WeatherMeasurement
{
  private SensorData sensorData;
  private Float value;
  private MeasureUnit unit;

  public WeatherMeasurement(SensorData sensorData, Float value, MeasureUnit unit)
  {
    this.sensorData = sensorData;
    this.value = value;
    this.unit = unit;
  }

  public SensorData getSensorData()
  {
    return sensorData;
  }

  public Float getValue()
  {
    return value;
  }

  public MeasureUnit getUnit()
  {
    return unit;
  }
}
