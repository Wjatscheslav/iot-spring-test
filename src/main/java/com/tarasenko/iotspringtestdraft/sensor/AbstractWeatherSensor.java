package com.tarasenko.iotspringtestdraft.sensor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tarasenko.iotspringtestdraft.analyzer.Analyzer;

public abstract class AbstractWeatherSensor<T> implements Sensor<T>
{

  private T state;
  private final List<Analyzer<T>> analyzers = new ArrayList<>();
  private String sensorId = UUID.randomUUID().toString();

  @Override
  public void registerAnalyzer(Analyzer<T> analyzer)
  {
    analyzers.add(analyzer);
  }

  @Override
  public void removeAnalyzer(Analyzer<T> analyzer)
  {
    analyzers.remove(analyzer);
  }

  @Override
  public void notifyAnalyzers()
  {
    analyzers.forEach(analyzer -> analyzer.updateState(state));
  }

  public void setState(T state)
  {
    this.state = state;
    notifyAnalyzers();
  }

  protected String getSensorId()
  {
    return sensorId;
  }

}
