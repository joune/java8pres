package com.example.rpn


object OperatorsRegistry
{
  type F2[A] = (A,A) => A
  type Op = F2[Double]

  def empty = new OperatorsRegistry(Map[String,Op]())
}

import OperatorsRegistry._

class OperatorsRegistry(ops:Map[String,Op])
{
  def withOperator(designation:String, operator:Op) = 
    new OperatorsRegistry(ops + (designation -> operator))

  def find(designation:String) = ops.get(designation)
}
