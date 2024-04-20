package codingbootcamp.week2.day1.models;

public class Solution {
  public static void main(String[] args) {
    Box box1 = new Box(10,5,"j","o","Hello World");
    Box box = new Box.Builder()
            .width(10)
            .corner("o")
            .height(3)
            .message("Happy New Year")
            .wall("%")
            .build();
  }
}
