package com.example.rpn;


import java.util.HashMap;
import java.util.Map;


public class OperatorsRegistry
{
  private Map<String,Operator> operators = new HashMap<>();

  private OperatorsRegistry(Map<String,Operator> operators)
  {
    this.operators = operators;
  }

  public static OperatorsRegistry of(Operator... ops)
  {
    Map<String,Operator> operators = new HashMap<>();
    for (Operator op : ops) {
      operators.put(op.designation(), op);
    }
    return new OperatorsRegistry(operators);
  }

  public Operator find(String designation)
  {
    return operators.get(designation);
  }
}
