package com.example.rpn;


public final class AlgebraicOperators
{
  private AlgebraicOperators() {}

  public static Operator[] OPERATORS = new Operator[] {
    new Sum(), new Subtraction(), new Multiplication(), new Division()
  };

  public static class Sum implements Operator
  {
    @Override
    public String designation()
    {
      return "+";
    }

    @Override
    public double apply(double operand1, double operand2)
    {
      return operand1 + operand2;
    }
  }

  public static class Subtraction implements Operator
  {
    @Override
    public String designation()
    {
      return "-";
    }

    @Override
    public double apply(double operand1, double operand2)
    {
      return operand1 - operand2;
    }
  }

  public static class Multiplication implements Operator
  {
    @Override
    public String designation()
    {
      return "*";
    }

    @Override
    public double apply(double operand1, double operand2)
    {
      return operand1 * operand2;
    }
  }

  public static class Division implements Operator
  {
    @Override
    public String designation()
    {
      return "/";
    }

    @Override
    public double apply(double operand1, double operand2)
    {
      return operand1 / operand2;
    }
  }
}
