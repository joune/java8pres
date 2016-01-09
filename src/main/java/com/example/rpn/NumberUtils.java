package com.example.rpn;


public class NumberUtils
{
  private NumberUtils() {}

  public static boolean isNumeric(String str)
  {
    return str.chars().allMatch(Character::isDigit);
  }
}
