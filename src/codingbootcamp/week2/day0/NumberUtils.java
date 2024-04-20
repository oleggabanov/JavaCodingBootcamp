package codingbootcamp.week2.day0;

public class NumberUtils {

  public static long getFactorial(final int number) {
    if (number < 0 || number > 20) {
      throw new IllegalArgumentException();
    }
    long factorial = 1;
    for (int i = 1; i <= number; i++) {
      factorial = (long) factorial * i;
    }
    return factorial;
  }

  public static long factorialRecursive(int number) {
    if (number < 0 || number > 20) {
      throw new IllegalArgumentException();
    }
    long factorial;
    factorial = number <= 1 ? 1 : number * factorialRecursive(number - 1);
    return factorial;
  }

  public static double power(int base, int power) {
    double result = 1;
    boolean isPowerNegative = power <= 0;
    if (isPowerNegative) {
      power = power * -1;
    }
    for (int i = 1; i <= power; i++) {
      result = result * base;
    }
    return isPowerNegative ? 1 / result : result;
  }

  public static double powerRecursive(int base, int power) {
    if (power == 0) {
      return 1;
    }
    if (power < 0) {
      power = -power;
      return 1 / (base * powerRecursive(base, power - 1));
    }
    return base * powerRecursive(base, power - 1);
  }

  public static int fibRecursive(int index) {
    if (index < 0) {
      throw new IllegalArgumentException();
    }
    if (index <= 1) {
      return index;
    }
    return fibRecursive(index - 1) + fibRecursive(index - 2);
  }

  public static int[] fibSequence(int length) {
    if (length < 0) {
      throw new IllegalArgumentException();
    }
    int[] fibResult = new int[length];
    if (length > 1) {
      fibResult[1] = 1;
    }
    for (int i = 2; i < length; i++) {
      fibResult[i] = fibResult[i - 1] + fibResult[i - 2];
    }
    return fibResult;
  }

  public static void sort(int[] target) {
    if (target == null) {
      return;
    }
    int temp = 0;
    boolean isGoing = false;
    while (!isGoing) {
      isGoing = true;
      for (int i = 0; i < target.length - 1; i++) {
        if (target[i] > target[i + 1]) {
          isGoing = false;
          temp = target[i];
          target[i] = target[i + 1];
          target[i + 1] = temp;
        }
      }
    }
  }



















  public static int sqrt(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    if (target == 1) {
      return 1;
    }
    int result = 0;
    for (int i = 0; i <= target / 2; i++) {
      if (power(result, 2) == target) {
        return result;
      }
      result++;
    }
    return -1;
  }

  public static boolean isPrime(int target) {
    if (target < 0) {
      throw new IllegalArgumentException();
    }
    if (target < 2) {
      return false;
    }
    for (int i = 2; i <= target / 2; i++) {
      if (target % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static int findNextPrime(int target) {
    while (!isPrime(target)) {
      target++;
    }
    return target;
  }
}
