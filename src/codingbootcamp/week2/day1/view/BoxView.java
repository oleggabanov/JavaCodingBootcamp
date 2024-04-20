package codingbootcamp.week2.day1.view;

import codingbootcamp.week2.day1.models.Box;

public class BoxView {
  public static final String MENU = """
          1. Create a box & put a text in it
          2. Replace text in the box
          3. Shift numbers in a message in a box
          4. Exit
          YOUR CHOICE:\040""";
  public static final String SMALL_MENU = """
          Put text in the box:
            1. Use box with default walls & corners: "#", "%"
            2. Use my symbols for walls & corners
            YOUR CHOICE:\040""";
  public static final String LINE_REQUEST = "Please, input some line: \n";
  public static final String TRY_AGAIN = "TRY AGAIN!\n";
  public static final String GOODBYE = "Goodbye!";
  public static final String OLD_BOX = "Old box: \n";
  public static final String NEW_BOX = "New box: \n";
  public static final String NEED_BOX = "###You should create the box first!###\n";
  public static final String MENU_ERROR = "It is not an expected menu's number!\n";
  public static final String NEED_WALL = "Input walls symbol: ";
  public static final String NEED_CORNER = "Input corners symbol: ";
  private Printer printer;
  private Reader reader;

  public BoxView(Printer printer, Reader reader) {
    this.printer = printer;
    this.reader = reader;
  }

  public void drawBox(Box box) {
    if (box.message().length() > box.width()) {
      throw new IllegalArgumentException();
    }
    String box1 = String.format("""
                    %s%s%s
                    %s %s %s
                    %s%s%s
                    """,
            box.corner(),
            box.wall().repeat(box.width() - 2),
            box.corner(),
            box.wall(),
            box.message(),
            box.wall(),
            box.corner(),
            box.wall().repeat(box.width() - 2),
            box.corner());
    printer.showMessage(box1);
  }

  public void showMessage(String message) {
    printer.showMessage(message);
  }

  public int getMenuPoint() {
    int menuPoint;
    printer.showMessage(MENU);
    while (true) {
      try {
        menuPoint = reader.getNumber();
        if (menuPoint > 0 && menuPoint < 5) {
          return menuPoint;
        }
        printer.showMessage(MENU_ERROR);
        printer.showMessage(TRY_AGAIN);
        printer.showMessage(MENU);
      } catch (NumberFormatException e) {
        printer.showMessage(TRY_AGAIN);
        printer.showMessage(MENU);
      }
    }
  }

  public int getSmallMenuPoint() {
    int menuPoint;
    printer.showMessage(SMALL_MENU);
    while (true) {
      try {
        menuPoint = reader.getNumber();
        if (menuPoint > 0 && menuPoint < 3) {
          return menuPoint;
        }
        printer.showMessage(MENU_ERROR);
        printer.showMessage(TRY_AGAIN);
        printer.showMessage(SMALL_MENU);
      } catch (NumberFormatException e) {
        printer.showMessage(TRY_AGAIN);
        printer.showMessage(SMALL_MENU);
      }
    }
  }

  public String getWall() {
    return getSymbol(NEED_WALL);
  }

  public String getCorner() {
    return getSymbol(NEED_CORNER);
  }

  private String getSymbol(String input) {
    printer.showMessage(input);
    String someLine = reader.getText();
    while (someLine.length() != 1) {
      printer.showMessage(TRY_AGAIN);
      printer.showMessage(input);
      someLine = reader.getText();
    }
    return someLine;
  }

  public String getText() {
    printer.showMessage(LINE_REQUEST);
    return reader.getText();
  }
}