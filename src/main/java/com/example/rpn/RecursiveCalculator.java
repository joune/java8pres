package com.example.rpn;

import java.util.*;


public class RecursiveCalculator implements Calculator
{
  private OperatorsRegistry operators;

  public RecursiveCalculator(OperatorsRegistry operators)
  {
    this.operators = operators;
  }

  public Either<String, Double> calculate(String expression)
  {
    List<String> expressionAsList = Arrays.asList(expression.split(" "));
    Queue<Double> stack = Collections.asLifoQueue(new ArrayDeque<>());
    return calculate(expressionAsList, stack);
  }

  private Either<String,Double> calculate(List<String> expression, Queue<Double> stack)
  {
    if (expression.isEmpty()) {
      return stack.size() == 1 ?
          new Either.Right<>(stack.poll()) :
          new Either.Left<>(String.format("no operator found but result is not final: %s", stack.toString()));
    } else {
      String token = expression.get(0);
      List<String> restOfExpression = expression.subList(1, expression.size());
      return consumeToken(stack, token).flatMap(nextStack -> calculate(restOfExpression, nextStack));
    }
  }

  private Either<String,Queue<Double>> consumeToken(Queue<Double> stack, String token)
  {
    Either<String,Queue<Double>> next;
    if (NumberUtils.isNumeric(token)) {
      stack.add(Double.parseDouble(token));
      next = new Either.Right<>(stack);
    } else if (operators.find(token).isPresent() && stack.size() >= 2) {
      Double op2 = stack.poll();
      Double op1 = stack.poll();
      Double nextResult = operators.find(token).get().apply(op1, op2);
      stack.add(nextResult);
      next = new Either.Right<>(stack);
    } else if (operators.find(token).isPresent()) {
      next = new Either.Left<>(String.format("not enough arguments for %s", token));
    } else {
      next = new Either.Left<>(String.format("cannot parse element %s", token));
    }
    return next;
  }
}
