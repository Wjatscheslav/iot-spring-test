package com.tarasenko.iotspringtestdraft.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tarasenko.iotspringtestdraft.data.WeatherStats;

@Repository
public class WeatherStatsRepository
{

  private final Map<String, WeatherStats> weatherStatsBySensorId = new HashMap<>();

  public WeatherStats getWeatherStats(String sensorId)
  {
    return weatherStatsBySensorId.get(sensorId);
  }

  public WeatherStats putWeatherStats(String seniorId, WeatherStats stats)
  {
    return weatherStatsBySensorId.put(seniorId, stats);
  }

  public List<WeatherStats> getAllWeatherStats()
  {
    return new ArrayList<>(weatherStatsBySensorId.values());
  }

  public void clearStats()
  {
    weatherStatsBySensorId.clear();
  }

}
