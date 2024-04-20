package codingbootcamp.week1.day1;

import codingbootcamp.week1.day0.Point;

import java.util.function.Function;

public class PointWithValue<T> extends Point {
  private final T value;

  public PointWithValue(int coordinateX, int coordinateY, T value) {
    super(coordinateX, coordinateY);
    this.value = value;
  }


  public T getValue() {
    return value;
  }

  public <R> PointWithValue<R> mapPoint(Function<T, R> mapFunction) {
    return new PointWithValue<>(getX(), getY(), mapFunction.apply(value));
  }

  @Override
  public String toString() {
    return "PointWithValue{X: %d, Y: %d, value: %s}".formatted(getX(), getY(), getValue());
  }


}




