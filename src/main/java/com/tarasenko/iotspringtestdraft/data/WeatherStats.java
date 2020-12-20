package com.tarasenko.iotspringtestdraft.data;

public class WeatherStats {
  private float minValue;
  private float maxValue;
  private float average;
  private int measurementsCount;
  private String sensorType;

  public WeatherStats(float initValue, String sensorType) {
    minValue = initValue;
    maxValue = initValue;
    average = initValue;
    measurementsCount = 1;
    this.sensorType = sensorType;
  }

  public void recalculateStats(Float newValue) {
    updateMin(newValue);
    updateMax(newValue);
    updateAverage(newValue);
    measurementsCount++;
  }

  private void updateMin(float newValue) {
    if (newValue < minValue) {
      minValue = newValue;
    }
  }

  private void updateMax(float newValue) {
    if (newValue > maxValue) {
      maxValue = newValue;
    }
  }

  private void updateAverage(float newValue) {
    average = (average * measurementsCount + newValue) / (measurementsCount + 1);
  }

  public float getMinValue() {
    return minValue;
  }

  public float getMaxValue() {
    return maxValue;
  }

  public float getAverage()
  {
    return average;
  }

  public String getSensorType()
  {
    return sensorType;
  }
}
