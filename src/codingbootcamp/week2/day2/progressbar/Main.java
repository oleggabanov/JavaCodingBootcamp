package codingbootcamp.week2.day2.progressbar;

import java.util.Random;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    String[] args1 = new  String[]{"10 2"};
    main1(args1);
  }

  public static void main1(String[] args) throws InterruptedException {
    //аргументы передаются в первой ячейке массива через пробел
    String[] arguments = args[0].split(" ");
    if (arguments.length < 2) {
      System.out.println("Need at least two arguments");
      return;
    }
    int[] intArgs = new int[arguments.length];
    for (int i = 0; i < intArgs.length; i++) {
      intArgs[i] = Integer.parseInt(arguments[i]);
    }
    Progressbar progressbar1 = new Progressbar(intArgs[0]);
    DrawProgressbar.show(progressbar1);
    Random random = new Random();
    for (int i = 0; i < progressbar1.getMaxParts(); i++) {
      Thread.sleep(intArgs[random.nextInt(1, intArgs.length)] * 1000);
      progressbar1.update();
      DrawProgressbar.show(progressbar1);
    }
  }
}
