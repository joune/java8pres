package com.example.rpn

import scala.util.{Either, Left, Right}
import NumberUtils._

case class Calculator(operators:OperatorsRegistry)
{
  val empty: Either[String,List[Double]] = Right(Nil)

  def calculate(expr:String): Either[String,Double] = 
    expr.split(" ").toList.foldLeft(empty) { (either,token) =>
      either.right.flatMap(stack => applyToken(stack, token))
    } match {
      case Right(stack) => stack match {
                              case res::Nil => Right(res)
                              case _ => Left(s"no operator found but result is not final: ${stack.toString}")
                           }
      case Left(err) => Left(err) //right types differ!
    }

  def applyToken(stack:List[Double], token:String) :Either[String,List[Double]] =
    if (token.isNumeric) {
      Right(token.toDouble +: stack)
    } else stack match {
      case op2::op1::tail =>
        if (operators.find(token).isDefined) 
          Right(operators.find(token).get.apply(op1, op2) :: tail)
        else 
          Left(String.format("cannot parse element %s", token))
      case _ => Left(String.format("not enough arguments for %s", token))
    }
}
