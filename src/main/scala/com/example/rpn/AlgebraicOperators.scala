package com.example.rpn


object AlgebraicOperators
{
  val OPERATORS = OperatorsRegistry.empty
      .withOperator("+", (op1:Double, op2:Double) => op1 + op2)
      .withOperator("-", (op1:Double, op2:Double) => op1 - op2)
      .withOperator("*", (op1:Double, op2:Double) => op1 * op2)
      .withOperator("/", (op1:Double, op2:Double) => op1 / op2)
}
