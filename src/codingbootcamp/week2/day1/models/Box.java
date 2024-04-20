package codingbootcamp.week2.day1.models;
public record Box(int width,
                  int height,
                  String wall,
                  String corner,
                  String message) {
  //Box[width=%d, height=%d, wall=%s, corner=%s, message=%s]
  @Override
  public String toString() {
    return "Box[width=%d, height=%d, wall=%s, corner=%s, message=%s]"
            .formatted(width, height, wall, corner, message);
  }

  public static class Builder {
    private int width;
    private int height;
    private String wall;
    private String corner;
    private String message = " ";

    public Builder() {
    }

    public Builder(Box box) {
      this.width = box.width();
      this.height = box.height();
      this.wall = box.wall();
      this.corner = box.corner();
      this.message = box.message();
    }

    public Builder width(int width) {
      if (width < 5) {
        throw new IllegalArgumentException();
      }
      this.width = width;
      return this;
    }

    public Builder height(int height) {

      if (height < 3) {
        throw new IllegalArgumentException();
      }
      this.height = height;
      return this;
    }

    public Builder wall(String wall) {
      if (wall.length() != 1 || wall.isBlank()) {
        throw new IllegalArgumentException();
      }
      this.wall = wall;
      return this;
    }

    public Builder corner(String corner) {
      if (corner.length() != 1 || corner.isBlank()) {
        throw new IllegalArgumentException();
      }
      this.corner = corner;
      return this;
    }

    public Builder message(String message) {
      if (message == null || message.equals("")) {
        message = " ";
      }
      this.message = message;
      return this;
    }

    public Box build() {
      if (width < 5) {
        throw new IllegalArgumentException("weight can't be < 5");
      }
      if (height < 3) {
        throw new IllegalArgumentException("height can't be < 3");
      }
      if (wall == null) {
        throw new IllegalArgumentException("wall symbol can't be empty");
      }
      if (corner == null) {
        throw new IllegalArgumentException("corner symbol can't be empty");
      }
      return new Box(width, height, wall, corner, message);
    }
  }
}
