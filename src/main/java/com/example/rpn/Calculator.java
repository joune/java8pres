package com.example.rpn;

import java.util.*;


public class Calculator
{
  private OperatorsRegistry operators;

  public Calculator(OperatorsRegistry operators)
  {
    this.operators = operators;
  }

  public Either<String,Double> calculate(String expr)
  {
    return Arrays.stream(expr.split(" ")).reduce(
        new Either.Right<>(Collections.asLifoQueue(new ArrayDeque<>())),
        (Either<String,Queue<Double>> errorOrStack, String token) ->
            errorOrStack.flatMap(stack -> this.applyToken(stack, token)),
        (stack1, stack2) -> { throw new UnsupportedOperationException(); }
    ).flatMap(stack -> stack.size() == 1 ?
        new Either.Right<>(stack.poll()) :
        new Either.Left<>(String.format("no operator found but result is not final: %s", stack.toString()))
    );
  }

  private Either<String,Queue<Double>> applyToken(Queue<Double> stack, String token)
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
