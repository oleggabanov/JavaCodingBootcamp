package codingbootcamp.week2.day3;

public class Calculator {

  public static void main(String... arguments) {
    if (arguments.length != 3) {
      System.out.println("Please provide 3 input arguments, example: 2 + 3");
      return;
    }
    Double first = Double.parseDouble(arguments[0]);
    Double second = Double.parseDouble(arguments[2]);
    boolean isDouble = arguments[0].contains(".") || arguments[2].contains(".");
    String result = "result: %s%n";
    switch (arguments[1]) {
      case "+" -> System.out.printf(result, isDouble ? (first + second)
              : String.valueOf(first.longValue() + second.longValue()));
      case "-" -> System.out.printf(result, isDouble ? (first - second)
              : String.valueOf(first.longValue() - second.longValue()));
      case "*" -> System.out.printf(result, isDouble ? (first * second)
              : String.valueOf(first.longValue() * second.longValue()));
      case "/" -> division(first, second, isDouble, result);
      case "%" -> divisionWithRemainder(first, second, isDouble, result);
      default -> throw new NumberFormatException("You should provide operators: +, -, *, /, %");
    }
  }

  
  private static void divisionWithRemainder(Double first, Double second, boolean isDouble, String result) {
    if (second == 0 || isDouble) {
      System.out.println(isDouble ? "result: " + (first % second) : "Division by zero is impossible!");
    } else {
      System.out.printf(result, first.longValue() % second.longValue());
    }
  }

  private static void division(double first, double second, boolean isDouble, String result) {
    if (second == 0) {
      System.out.println(isDouble ? "result: " + (first / second) : "Division by zero is impossible!");
    } else {
      System.out.printf(result, first / second);
    }
  }

}