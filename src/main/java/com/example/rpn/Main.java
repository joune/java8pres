package com.example.rpn;

import java.util.Arrays;


public class Main
{
  public static void main(String[] args)
  {
    Calculator calculator = new Calculator(AlgebraicOperators.OPERATORS);
    Arrays.stream(args).forEach( expr -> {
      try {
        double result = calculator.calculate(expr);
        System.out.printf("%s = %.2f\n", expr, result);
      }
      catch (IllegalArgumentException e) {
        System.out.printf("Error in expression: `%s`: %s\n", expr, e.getMessage());
      }
    });
  }
}
