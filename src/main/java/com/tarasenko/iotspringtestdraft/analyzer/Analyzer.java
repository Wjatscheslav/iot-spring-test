package com.tarasenko.iotspringtestdraft.analyzer;

public interface Analyzer<T>
{

  void updateState(T t);

}
