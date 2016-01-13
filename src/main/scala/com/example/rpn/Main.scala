package com.example.rpn

class Main extends App
{
  val calculator = Calculator(AlgebraicOperators.OPERATORS)
  args.toList.foreach { expr =>
    calculator.calculate(expr) match {
      case Left(error) => println(s"Error in expression:'$expr': $error")
      case Right(res) => println(s"$expr = $res")
    }
  }
}
