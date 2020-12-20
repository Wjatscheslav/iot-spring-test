package com.tarasenko.iotspringtestdraft.data;

import java.util.Date;

public class WeatherAlarm
{

  private String sensorType;
  private Date alarmDate;
  private Float value;

  public WeatherAlarm(String sensorType, Float value)
  {
    this.sensorType = sensorType;
    this.alarmDate = new Date();
    this.value = value;
  }

  public String getSensorType()
  {
    return sensorType;
  }

  public Date getAlarmDate()
  {
    return alarmDate;
  }

  public Float getValue()
  {
    return value;
  }
}
