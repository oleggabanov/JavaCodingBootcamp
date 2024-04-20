package codingbootcamp.week1.day0;

public class Point implements Comparable<Point> {
  private final int coordinateX;
  private final int coordinateY;

  public Point(final int coordinateX, final int coordinateY) {
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }

  public int getX() {
    return this.coordinateX;
  }

  public int getY() {
    return this.coordinateY;
  }

  public Point sum(final Point that) {
    int newCoordinateX = this.coordinateX + that.coordinateX;
    int newCoordinateY = this.coordinateY + that.coordinateY;
    return new Point(newCoordinateX, newCoordinateY);
  }

  public Point updateX(int newX) {
    return new Point(newX, this.coordinateY);
  }

  public Point updateY(int newY) {
    return new Point(this.coordinateX, newY);
  }


  public int distanceTo(Point that) {
    int distanceX = this.coordinateX - that.coordinateX;
    int distanceY = this.coordinateY - that.coordinateY;
    return distanceX * distanceX + distanceY * distanceY;
  }


  @Override
  public boolean equals(Object o) {

    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Point point = (Point) o;
    return this.coordinateX == point.coordinateX && this.coordinateY == point.coordinateY;
  }

  @Override
  public int hashCode() {
    return this.coordinateX + this.coordinateY;
  }

  @Override
  public String toString() {
    return "Point{X:" + coordinateX + ", Y:" + coordinateY + "}";

  }

  @Override
  public int compareTo(Point that) {
    int thisCoordinates = this.coordinateX + this.coordinateY;
    int thatCoordinates = that.coordinateX + that.coordinateY;
    return thisCoordinates - thatCoordinates;
  }


}


