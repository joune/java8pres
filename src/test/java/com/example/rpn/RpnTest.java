package com.example.rpn;

import org.junit.Test;
import static org.junit.Assert.*;


public class RpnTest
{
  private Calculator calculator = new Calculator(OperatorsRegistry.of(AlgebraicOperators.OPERATORS));

  @Test
  public void testOperators()
  {
    assertEquals( 5.0, calculator.calculate("2 3 +"), 0.01);
    assertEquals(-1.0, calculator.calculate("2 3 -"), 0.01);
    assertEquals( 6.0, calculator.calculate("2 3 *"), 0.01);
    assertEquals(0.66, calculator.calculate("2 3 /"), 0.01);
  }

  @Test
  public void testExpressions()
  {
    assertEquals(-4.0, calculator.calculate("10 4 3 + 2 * -"), 0.01);
  }

  @Test(expected=IllegalArgumentException.class)
  public void testUnknownOperator()
  {
    calculator.calculate("1 2 ?");
  }

  @Test(expected=IllegalArgumentException.class)
  public void testNotEnoughOperators()
  {
    calculator.calculate("1 2");
  }

  @Test(expected=IllegalArgumentException.class)
  public void testNotEnoughArguments()
  {
    calculator.calculate("1 +");
  }
}
