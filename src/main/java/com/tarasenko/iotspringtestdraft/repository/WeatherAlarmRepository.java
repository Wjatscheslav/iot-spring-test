package com.tarasenko.iotspringtestdraft.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tarasenko.iotspringtestdraft.data.WeatherAlarm;

@Repository
public class WeatherAlarmRepository
{

  private final List<WeatherAlarm> weatherAlarms = new ArrayList<>();

  public void clearAlarms()
  {
    weatherAlarms.clear();
  }

  public List<WeatherAlarm> getWeatherAlarms()
  {
    return weatherAlarms;
  }

}
