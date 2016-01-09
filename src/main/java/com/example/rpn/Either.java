package com.example.rpn;

import java.util.function.Consumer;
import java.util.function.Function;


public abstract class Either<L,R>
{
  private Either() {}

  public abstract boolean isLeft();
  public boolean isRight() { return !isLeft(); }
  public abstract R getRight();
  public abstract L getLeft();
  public abstract void forEach(Consumer<R> forResult, Consumer<L> forError);
  public abstract <M> Either<L,M> flatMap(Function<R,Either<L,M>> fn);

  public static class Left<L,R> extends Either<L,R>
  {
    private L leftValue;
    public Left(L leftValue) { this.leftValue = leftValue; }
    public boolean isLeft() { return true; }
    public R getRight() { throw new UnsupportedOperationException("Left.getRight()"); }
    public L getLeft() { return leftValue; }
    public void forEach(Consumer<R> forResult, Consumer<L> forError) { forError.accept(leftValue); }
    public <M> Either<L,M> flatMap(Function<R,Either<L,M>> fn) { return new Left<>(leftValue); }
  }

  public static class Right<L,R> extends Either<L,R>
  {
    private R rightValue;
    public Right(R rightValue) { this.rightValue = rightValue; }
    public boolean isLeft() { return false; }
    public R getRight() { return rightValue; }
    public L getLeft() { throw new UnsupportedOperationException("Right.getLeft()"); }
    public void forEach(Consumer<R> forResult, Consumer<L> forError) { forResult.accept(rightValue); }
    public <M> Either<L,M> flatMap(Function<R,Either<L,M>> fn) { return fn.apply(rightValue); }
  }
}
