package codingbootcamp.week1.day4;

public class StdString2 extends StdString1 {
  public StdString2(char[] base) {
    super(base);
  }

  public StdString2() {
    String emptyString = new String();
  }

  public StdString2(StdString2 that) {
    super(that);
  }

  public StdString2 toAsciiLowerCase() {
    char[] cloneBase = super.toCharArray();
    for (int i = 0; i < cloneBase.length; i++) {
      cloneBase[i] = StringUtils.toAsciiLowercase(cloneBase[i]);
    }
    return new StdString2(cloneBase);
  }

  public StdString2 toAsciiUpperCase() {
    char[] cloneBase = super.toCharArray();
    for (int i = 0; i < cloneBase.length; i++) {
      cloneBase[i] = StringUtils.toAsciiUppercase(cloneBase[i]);
    }
    return new StdString2(cloneBase);
  }

  public StdString2 subString(int from, int to) {
    if (from < 0 || to < 0 || from > to) {
      throw new IllegalArgumentException();
    }
    char[] array1 = new char[to - from];
    System.arraycopy(super.toCharArray(), from, array1, 0, to - from);
    return new StdString2(array1);
  }

  public StdString2 concat(StdString2... that) {
    StdString1 result = new StdString1(super.toCharArray());
    for (StdString2 strings : that) {
      result = result.append(new StdString1(strings.toCharArray()));
    }
    return new StdString2(result.toCharArray());
  }

  public static void main(String[] args) {
    String s = "\n\n\n\n\n\n";
    StdString2 string2 = new StdString2(s.toCharArray());
     string2.split('\n');
    System.out.println(string2);
  }
  public StdString2[] split(char separator) {
    int size = 0;
    int tempSize = 0;
    for (int i = this.length() - 1; this.charAt(i) == separator && i > 0; i--) {
      tempSize++;
    }
    char[] temp = this.subString(0, this.length() - tempSize).toCharArray();
    for (char c : temp) {
      if (c == separator) {
        size++;
      }
    }
    if (size == 0) {
      return new StdString2[]{this};
    }
    int counter = 0;
    StdString2[] result = new StdString2[size + 1];
    StringBuilder builder = new StringBuilder();
    for (char c : temp) {
      if (c == separator && counter <= result.length) {
        char[] temp2 = new char[builder.length()];
        builder.getChars(0, builder.length(), temp2, 0);
        result[counter++] = new StdString2(temp2);
        builder.setLength(0);
      } else {
        builder.append(c);
      }
    }
    if (builder.length() > 0) {
      char[] temp3 = new char[builder.length()];
      builder.getChars(0, builder.length(), temp3, 0);
      result[counter++] = new StdString2(temp3);
    }
    return result;
  }


  public static boolean isWhitespace(char ch) {
    return ch == ' ' || ch == '\t' || ch == '\n' || ch == '\f' || ch == '\r';
  }

  public StdString2 trim() {
    char[] naruto = super.toCharArray();
    int counter = 0;
    int arrayLength = naruto.length;
    while (isWhitespace(naruto[counter])) {
      counter++;
    }
    while (isWhitespace(naruto[arrayLength - 1])) {
      arrayLength--;
    }
    return subString(counter, arrayLength);
  }
  //Метод считает сколько элементов в массиве
  //потом создаем новый массив на n количество эл-в без нужного символа

  public StdString2 removeCharacter(char toRemove) {
    char[] naruto = super.toCharArray();
    int counter = 0;
    for (int i = 0; i < naruto.length; i++) {
      if (naruto[i] == toRemove) {
        counter++;
      }
    }
    char[] newArray = new char[naruto.length - counter];
    counter = 0;
    for (int i = 0; i < naruto.length; i++) {
      if (naruto[i] != toRemove) {
        newArray[counter++] = naruto[i];
      }
    }
    return new StdString2(newArray);
  }
}




