package com.example.rpn;


public class NumberUtils
{
  private NumberUtils() {}

  public static boolean isNumeric(String str)
  {
    for (char c : str.toCharArray()) {
      if (!Character.isDigit(c)) return false;
    }
    return true;
  }
}
