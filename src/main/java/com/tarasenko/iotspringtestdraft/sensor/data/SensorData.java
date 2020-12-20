package com.tarasenko.iotspringtestdraft.sensor.data;

public class SensorData
{

  private String id;
  private SensorType type;

  public SensorData(String id, SensorType type)
  {
    this.id = id;
    this.type = type;
  }

  public String getId()
  {
    return id;
  }

  public SensorType getType()
  {
    return type;
  }
}
