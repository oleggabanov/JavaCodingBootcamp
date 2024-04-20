package codingbootcamp.week1.day1;

import codingbootcamp.week1.day0.Point;

public class PointWithLabel extends PointWithValue<String> {

  public PointWithLabel(int coordinateX, int coordinateY, String value) {
    super(coordinateX, coordinateY, value);
  }

  public String getLabel() {
    return getValue();
  }

  public int compareTo(Point obj) {
    if (obj instanceof PointWithLabel link) {
      return link.getLabel().compareTo(this.getLabel());
    } else {
      return super.compareTo(obj);
    }
  }
}