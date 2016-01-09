package com.example.rpn;


import java.util.*;
import java.util.function.BinaryOperator;


public class OperatorsRegistry
{
  private Map<String,BinaryOperator<Double>> operators = new HashMap<>();

  private OperatorsRegistry(Map<String,BinaryOperator<Double>> operators)
  {
    this.operators = operators;
  }

  /*public static OperatorsRegistry of(Operator... ops)
  {
    Map<String, Operator> operators = Arrays.stream(ops).collect(
        Collectors.toMap(Operator::designation, Function.identity()));
    return new OperatorsRegistry(operators);
  }*/

  public static OperatorsRegistry of(Map<String,BinaryOperator<Double>> operators)
  {
    return new OperatorsRegistry(operators);
  }

  public BinaryOperator<Double> find(String designation)
  {
    return operators.get(designation);
  }
}
