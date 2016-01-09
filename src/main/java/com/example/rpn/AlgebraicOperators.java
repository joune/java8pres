package com.example.rpn;


public final class AlgebraicOperators
{
  private AlgebraicOperators() {}

  public static OperatorsRegistry OPERATORS = OperatorsRegistry.empty()
      .withOperator("+", (op1, op2) -> op1 + op2)
      .withOperator("-", (op1, op2) -> op1 - op2)
      .withOperator("*", (op1, op2) -> op1 * op2)
      .withOperator("/", (op1, op2) -> op1 / op2);
}
