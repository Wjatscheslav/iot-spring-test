package com.tarasenko.iotspringtestdraft.sensor;

import static com.tarasenko.iotspringtestdraft.generator.FloatValueGenerator.generateHumidity;
import static com.tarasenko.iotspringtestdraft.sensor.data.MeasureUnit.PERCENT;
import static com.tarasenko.iotspringtestdraft.sensor.data.SensorType.HUMIDITY;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.tarasenko.iotspringtestdraft.sensor.data.SensorData;
import com.tarasenko.iotspringtestdraft.sensor.data.WeatherMeasurement;

@Component
public class HumiditySensor extends AbstractWeatherSensor<WeatherMeasurement>
{
  @PostConstruct
  public void init()
  {
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(humidityTimerTask(), 0, 3000);
  }

  private TimerTask humidityTimerTask()
  {
    return new TimerTask()
    {
      @Override
      public void run()
      {
        SensorData sensorData = new SensorData(getSensorId(), HUMIDITY);
        WeatherMeasurement measurement = new WeatherMeasurement(sensorData, generateHumidity(), PERCENT);
        setState(measurement);
      }
    };
  }

}
