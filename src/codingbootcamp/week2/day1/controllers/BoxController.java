package codingbootcamp.week2.day1.controllers;

import codingbootcamp.week2.day1.models.Box;

public class BoxController {
  public Box madeBoxWithText(String message) {
    return madeBoxWithText(message, "#", "%");
  }

  public Box madeBoxWithText(String message, String wall, String corner) {
    return new Box.Builder()
            .wall(wall)
            .message(message)
            .height(3)
            .corner(corner)
            .width(message.length() + 4)
            .build();
  }

  public Box shiftNumberInTheTextInBox(Box box) {
    char[] array = box.message().toCharArray();
    for (int i = 0; i < array.length; i++) {
      if (array[i] >= '0' && array[i] < '9') {
        array[i]++;
      } else if (array[i] == '9') {
        array[i] = '0';
      }
    }
    return new Box.Builder(box)
            .message(String.valueOf(array))
            .build();
  }

  public Box replaceMessage(Box box, String message) {
    return madeBoxWithText(message, box.wall(), box.corner());
  }
}
