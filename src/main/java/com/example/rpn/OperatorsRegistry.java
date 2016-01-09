package com.example.rpn;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class OperatorsRegistry
{
  private Map<String,Operator> operators = new HashMap<>();

  private OperatorsRegistry(Map<String,Operator> operators)
  {
    this.operators = operators;
  }

  public static OperatorsRegistry of(Operator... ops)
  {
    Map<String, Operator> operators = Arrays.stream(ops).collect(
        Collectors.toMap(Operator::designation, Function.identity()));
    return new OperatorsRegistry(operators);
  }

  public Operator find(String designation)
  {
    return operators.get(designation);
  }
}
