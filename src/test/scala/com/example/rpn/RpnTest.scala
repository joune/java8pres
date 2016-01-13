package com.example.rpn

import org.junit.Test
import org.junit.Assert._


class RpnTest
{
  val calculator = Calculator(AlgebraicOperators.OPERATORS)

  @Test def testOperators =
  {
    assertEquals( 5.0, calculator.calculate("2 3 +").right.get, 0.01)
    assertEquals(-1.0, calculator.calculate("2 3 -").right.get, 0.01)
    assertEquals( 6.0, calculator.calculate("2 3 *").right.get, 0.01)
    assertEquals(0.66, calculator.calculate("2 3 /").right.get, 0.01)
  }

  @Test def testExpressions =
  {
    assertEquals(-4.0, calculator.calculate("10 4 3 + 2 * -").right.get, 0.01)
  }

  @Test def testUnknownOperator =
  {
    assertTrue(calculator.calculate("1 2 ?").isLeft)
  }

  @Test def testNotEnoughOperators =
  {
    assertTrue(calculator.calculate("1 2").isLeft)
  }

  @Test def testNotEnoughArguments =
  {
    assertTrue(calculator.calculate("1 +").isLeft)
  }
}
