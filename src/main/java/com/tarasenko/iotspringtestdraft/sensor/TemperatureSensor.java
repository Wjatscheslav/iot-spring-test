package com.tarasenko.iotspringtestdraft.sensor;

import static com.tarasenko.iotspringtestdraft.generator.FloatValueGenerator.generateTemperature;
import static com.tarasenko.iotspringtestdraft.sensor.data.MeasureUnit.DEGREES_CELSIUS;
import static com.tarasenko.iotspringtestdraft.sensor.data.SensorType.TEMPERATURE;

import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.tarasenko.iotspringtestdraft.sensor.data.SensorData;
import com.tarasenko.iotspringtestdraft.sensor.data.WeatherMeasurement;

@Component
public class TemperatureSensor extends AbstractWeatherSensor<WeatherMeasurement>
{
  @PostConstruct
  public void init()
  {
    Timer timer = new Timer();
    timer.scheduleAtFixedRate(temperatureTimerTask(), 0, 3000);
  }

  private TimerTask temperatureTimerTask()
  {
    return new TimerTask()
    {
      @Override
      public void run()
      {
        SensorData sensorData = new SensorData(getSensorId(), TEMPERATURE);
        WeatherMeasurement measurement = new WeatherMeasurement(sensorData, generateTemperature(), DEGREES_CELSIUS);
        setState(measurement);
      }
    };
  }

}
