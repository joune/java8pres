package com.example.rpn;


public interface Operator
{
  String designation();

  double apply(double operand1, double operand2);
}
