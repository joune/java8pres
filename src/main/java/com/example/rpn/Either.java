package com.example.rpn;

import java.util.function.Consumer;


public abstract class Either<L,R>
{
  private Either() {}

  public abstract boolean isLeft();
  public boolean isRight() { return !isLeft(); }
  public abstract R getRight();
  public abstract L getLeft();
  public abstract void forEach(Consumer<R> forResult, Consumer<L> forError);

  public static class Left<L,R> extends Either<L,R>
  {
    private L error;
    public Left(L error) { this.error = error; }
    public boolean isLeft() { return true; }
    public R getRight() { throw new UnsupportedOperationException("Left.getRight()"); }
    public L getLeft() { return error; }
    public void forEach(Consumer<R> forResult, Consumer<L> forError) { forError.accept(error); }
  }

  public static class Right<L,R> extends Either<L,R>
  {
    private R result;
    public Right(R result) { this.result = result; }
    public boolean isLeft() { return false; }
    public R getRight() { return result; }
    public L getLeft() { throw new UnsupportedOperationException("Right.getLeft()"); }
    public void forEach(Consumer<R> forResult, Consumer<L> forError) { forResult.accept(result); }
  }
}
