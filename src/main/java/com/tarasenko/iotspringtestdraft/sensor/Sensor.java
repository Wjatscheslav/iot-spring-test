package com.tarasenko.iotspringtestdraft.sensor;

import com.tarasenko.iotspringtestdraft.analyzer.Analyzer;

public interface Sensor<T>
{

  void registerAnalyzer(Analyzer<T> analyzer);
  void removeAnalyzer(Analyzer<T> analyzer);
  void notifyAnalyzers();

}