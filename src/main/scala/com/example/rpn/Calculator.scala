package com.example.rpn

import scala.util.{Either, Left, Right}
import scala.collection.immutable.Queue
import NumberUtils._

case class Calculator(operators:OperatorsRegistry)
{
  val empty: Either[String,Queue[Double]] = Right(Queue())

  def calculate(expr:String): Either[String,Double] = 
    expr.split(" ").toList.foldLeft(empty) { (either,token) =>
      either.right.flatMap(stack => applyToken(stack, token))
    } match {
      case Right(stack) => if (stack.size == 1) Right(stack.dequeue._1)
                           else Left(s"no operator found but result is not final: ${stack.toString}")
      case Left(err) => Left(err) //right types differ!
    }

  def applyToken(stack:Queue[Double], token:String) :Either[String,Queue[Double]] =
    if (token.isNumeric) {
      Right(token.toDouble +: stack)
    } else if (operators.find(token).isDefined && stack.size >= 2) {
      val (op2,q) = stack.dequeue
      val (op1,q2) = q.dequeue
      Right(operators.find(token).get.apply(op1, op2) +: q2)
    } else if (operators.find(token).isDefined) {
      Left(String.format("not enough arguments for %s", token))
    } else {
      Left(String.format("cannot parse element %s", token))
    }
}
