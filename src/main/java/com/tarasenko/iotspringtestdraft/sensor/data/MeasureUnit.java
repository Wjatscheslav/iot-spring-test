package com.tarasenko.iotspringtestdraft.sensor.data;

public enum MeasureUnit
{
  PERCENT("%"),
  DEGREES_CELSIUS("℃");

  private String measureSign;

  MeasureUnit(String measureSign)
  {
    this.measureSign = measureSign;
  }
}
