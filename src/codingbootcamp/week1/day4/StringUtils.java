package codingbootcamp.week1.day4;

public class StringUtils {

  public static boolean isAsciiUppercase(char ch) {
    if (ch < 0 || ch > 128) {
      throw new IllegalArgumentException();
    }
    return ch >= 'A' && ch <= 'Z';
  }

  public static boolean isAsciiLowercase(char ch) {
    if (ch < 0 || ch > 128) {
      throw new IllegalArgumentException();
    }
    return ch >= 'a' && ch <= 'z';
  }

  public static boolean isAsciiNumeric(char ch) {
    if (ch < 0 || ch > 128) {
      throw new IllegalArgumentException();
    }
    return ch >= '0' && ch <= '9';
  }

  public static boolean isAsciiAlphabetic(char ch) {
    return isAsciiLowercase(ch) || isAsciiUppercase(ch);
  }

  public static char toAsciiUppercase(char ch) {
    if (isAsciiLowercase(ch)) {
      ch = (char) (ch - 32);
    }
    return ch;
  }

  public static char toAsciiLowercase(char ch) {
    if (isAsciiUppercase(ch)) {
      ch = (char) (ch + 32);
    }
    return ch;
  }

  public static StringBuilder makeUppercase(char[] input) {
    StringBuilder naruto = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      naruto.append(toAsciiUppercase(input[i]));
    }
    return naruto;
  }

  public static StringBuilder makeCamel(char[] input) {
    StringBuilder comboNaruto = new StringBuilder();
    for (int i = 0; i < input.length; i++) {
      if (i % 2 == 0) {
        comboNaruto.append(toAsciiLowercase(input[i]));
      } else {
        comboNaruto.append(toAsciiUppercase(input[i]));
      }

    }
    return comboNaruto;
  }

  public static boolean isStringAlphaNumerical(char[] input) {
    for (int i = 0; i < input.length; i++) {
      if (!(isAsciiAlphabetic(input[i]) || isAsciiNumeric(input[i]) || input[i] == ' ')) {
        return false;
      }
    }
    return true;
  }

  public static char[] concatStrings(char[][] input) {
    int sasuke = 0;
    for (int i = 0; i < input.length; i++) {
      sasuke += input[i].length;
    }
    char[] array = new char[sasuke];
    int index = 0;
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        if (input[i][j] > 256) {
          throw new IllegalArgumentException();
        }
        array[index++] = input[i][j];
      }

    }
    return array;
  }
  public static int toInt(char[] input) {
    if (input.length == 0) {
      throw new IllegalArgumentException();
    }
    int result = 0;
    boolean isNegative = input[0] == '-';
    for (int i = isNegative ? 1 : 0; i < input.length; i++) {
      char c = input[i];
      if (!isAsciiNumeric(c)) {
        throw new NumberFormatException();
      }
      if (isAsciiNumeric(c)) {
        int digitValue = c - '0';
        result = result * 10 + digitValue;
      }
    }
    if (isNegative) {
      result = -result;
    }
    return result;
  }
}


