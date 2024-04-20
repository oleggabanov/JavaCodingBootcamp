package codingbootcamp.week2.day1.view;

import java.util.Scanner;

public class KeyboardReader implements Reader {
  private final Scanner scanner = new Scanner(System.in);

  @Override
  public int getNumber() throws NumberFormatException {
    return Integer.parseInt(scanner.nextLine().trim());
  }

  @Override
  public String getText() {
    return scanner.nextLine();
  }
}
