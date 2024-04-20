package codingbootcamp.week2.day1.view;

public interface Reader {
  int getNumber() throws NumberFormatException;
  String getText();
}
