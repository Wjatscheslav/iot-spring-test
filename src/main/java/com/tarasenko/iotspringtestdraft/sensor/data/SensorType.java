package com.tarasenko.iotspringtestdraft.sensor.data;

public enum SensorType
{
  TEMPERATURE("Temperature"),
  HUMIDITY("Humidity");

  private String sensorName;

  SensorType(String sensorName)
  {
    this.sensorName = sensorName;
  }
}
