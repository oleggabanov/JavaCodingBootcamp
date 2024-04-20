package codingbootcamp.week1.day1;

import java.util.Comparator;

public class Sorting {


  public static <T> void sort(T[] target, Comparator<T> comparator) {

    boolean isGoing = false;
    while (!isGoing) {
      isGoing = true;
      for (int i = 0; i < target.length - 1; i++) {
        if (comparator.compare(target[i], target[i + 1]) > 0) {
          isGoing = false;
          T temp = target[i];
          target[i] = target[i + 1];
          target[i + 1] = temp;
        }
        System.out.println(target);
      }
    }
  }

  //default Comparator<T> reversed() {
  //        return Collections.reverseOrder(this)
  public static <T> void sortReversedOrder(T[] target, Comparator<T> comparator) {
    sort(target, comparator.reversed());
  }

}