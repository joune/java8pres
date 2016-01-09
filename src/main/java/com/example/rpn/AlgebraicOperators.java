package com.example.rpn;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;


public final class AlgebraicOperators
{
  private AlgebraicOperators() {}

  public static Map<String,BinaryOperator<Double>> OPERATORS = new HashMap<>();
  static {
    OPERATORS.put("+", (op1, op2) -> op1 + op2);
    OPERATORS.put("-", (op1, op2) -> op1 - op2);
    OPERATORS.put("*", (op1, op2) -> op1 * op2);
    OPERATORS.put("/", (op1, op2) -> op1 / op2);
  }
}
