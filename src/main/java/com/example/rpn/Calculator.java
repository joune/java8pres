package com.example.rpn;

public interface Calculator
{
  Either<String,Double> calculate(String expression);
}
