package com.example.rpn


object NumberUtils
{
  implicit class RichString(str:String) {
    def isNumeric = str.forall(_.isDigit)
  }
}
