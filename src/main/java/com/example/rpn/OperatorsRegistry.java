package com.example.rpn;


import java.util.*;
import java.util.function.BinaryOperator;


public class OperatorsRegistry
{
  private Map<String,BinaryOperator<Double>> operators;

  private OperatorsRegistry(Map<String,BinaryOperator<Double>> operators)
  {
    this.operators = operators;
  }

  public static OperatorsRegistry empty()
  {
    return new OperatorsRegistry(new HashMap<>());
  }

  public OperatorsRegistry withOperator(String designation, BinaryOperator<Double> operator)
  {
    Map<String, BinaryOperator<Double>> newOperators = new HashMap<>(operators);
    newOperators.put(designation, operator);
    return new OperatorsRegistry(Collections.unmodifiableMap(newOperators));
  }

  public BinaryOperator<Double> find(String designation)
  {
    return operators.get(designation);
  }
}
