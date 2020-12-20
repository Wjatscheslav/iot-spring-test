package com.tarasenko.iotspringtestdraft.generator;

import java.util.Random;

public class FloatValueGenerator
{

  private static final float HUMIDITY_LEFT_LIMIT = 0;
  private static final float HUMIDITY_RIGHT_LIMIT = 100;
  private static final float TEMPERATURE_LEFT_LIMIT = -50;
  private static final float TEMPERATURE_RIGHT_LIMIT = 50;
  private static final Random GENERATOR = new Random();

  public static float generateHumidity()
  {
    return generate(HUMIDITY_LEFT_LIMIT, HUMIDITY_RIGHT_LIMIT);
  }

  public static float generateTemperature()
  {
    return generate(TEMPERATURE_LEFT_LIMIT, TEMPERATURE_RIGHT_LIMIT);
  }

  private static float generate(float leftLimit, float rightLimit)
  {
    return leftLimit + GENERATOR.nextFloat() * (rightLimit - leftLimit);
  }

}
