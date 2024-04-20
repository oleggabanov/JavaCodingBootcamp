package codingbootcamp.week2.day1;

import codingbootcamp.week2.day1.controllers.BoxController;
import codingbootcamp.week2.day1.models.Box;
import codingbootcamp.week2.day1.view.BoxView;
import codingbootcamp.week2.day1.view.ConsolePrinter;
import codingbootcamp.week2.day1.view.KeyboardReader;

public class ExternalUser {


  public static void main(String[] args) {
    BoxView view = new BoxView(new ConsolePrinter(), new KeyboardReader());
    BoxController controller = new BoxController();
    Box dutyBox = null;

    view.showMessage("Welcome to the divine box!\n");
    var item = 0;
    do {
      item = view.getMenuPoint();
      switch (item) { // switch statement
        case 1 -> {
          var subItem = view.getSmallMenuPoint();
          dutyBox = switch (subItem) { // switch expression
            case 1 -> controller.madeBoxWithText(view.getText());
            case 2 -> {
              var wall = view.getWall();
              var corner = view.getCorner();
              var text = view.getText();
              yield controller.madeBoxWithText(text, wall, corner);
            }
            default -> {
              view.showMessage(BoxView.MENU_ERROR);
              yield null;
            }
          };
          assert dutyBox != null;
          view.drawBox(dutyBox);
        }
        case 2 -> {

          if (dutyBox != null) {
            dutyBox = controller.replaceMessage(dutyBox, view.getText());
            view.drawBox(dutyBox);
          } else {
            view.showMessage(BoxView.NEED_BOX);
          }
        }
        case 3 -> {
          if (dutyBox != null) {
            view.showMessage(BoxView.OLD_BOX);
            view.drawBox(dutyBox);
            view.showMessage(BoxView.NEW_BOX);
            dutyBox = controller.shiftNumberInTheTextInBox(dutyBox);
            view.drawBox(dutyBox);
          } else {
            view.showMessage(BoxView.NEED_BOX);
          }
        }
        case 4 -> view.showMessage(BoxView.GOODBYE);
        default -> view.showMessage(BoxView.MENU_ERROR);
      }
    } while (item != 4);
  }
}

