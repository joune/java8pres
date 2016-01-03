package com.example.rpn;

public class Main
{
  public static void main(String[] args)
  {
    Calculator calculator = new Calculator(OperatorsRegistry.of(AlgebraicOperators.OPERATORS));
    for (String expr : args) {
      try {
        double result = calculator.calculate(expr);
        System.out.printf("%s = %.2f\n", expr, result);
      }
      catch (IllegalArgumentException e) {
        System.out.printf("Error in expression: `%s`: %s\n", expr, e.getMessage());
      }
    }
  }
}
