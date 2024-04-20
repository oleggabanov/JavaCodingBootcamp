package codingbootcamp.week1.day2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class StdString1 implements Iterable<Character> {
  private final char[] base;


  public StdString1(char[] base) {
    this.base = base.clone();
  }

  public StdString1() {
    this.base = new char[0];
  }

  public StdString1(StdString1 stdString1) {
    this.base = stdString1.toCharArray();
  }

  public int length() {
    return base.length;

  }

  public StdString1 append(StdString1 that) {
    if (that == null) {
      throw new NullPointerException();
    }
    int arrayLength = length() + that.length();
    char[] naruto = new char[arrayLength];
    for (int i = 0; i < length(); i++) {
      naruto[i] = this.base[i];
    }

    for (int i = length(), j = 0; i < arrayLength; i++) {
      naruto[i] = that.base[j];
      j++;
    }

    return new StdString1(naruto);
  }

  public char[] toCharArray() {
    return base.clone();
  }

  public char charAt(int index) {
    if (index > length()) {
      throw new IndexOutOfBoundsException();
    }
    return base[index];
  }

  public int indexOf(char target) {
    for (int i = 0; i < length(); i++) {
      if (charAt(i) == target) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public boolean equals(final Object otherObj) {
    if (this == otherObj) {
      return true;

    }
    if (otherObj == null || getClass() != otherObj.getClass()) {
      return false;
    }
    StdString1 inputObj = (StdString1) otherObj;
    return Arrays.equals(this.base, inputObj.base);
  }

  @Override
  public int hashCode() {
    int hashCode = 0;
    for (int i = 0; i < length(); i++) {
      hashCode += charAt(i);
    }
    return hashCode;
  }

  @Override
  public String toString() {
    return String.valueOf(this.base);
  }

  @Override
  public Iterator<Character> iterator() {
    return new Iterator<>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < length();
      }

      @Override
      public Character next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        return charAt(index++);
      }
    };
  }


  @Override
  public void forEach(final Consumer<? super Character> action) {
    for (int i = 0; i < base.length; i++) {
      action.accept(base[i]);
    }
  }

}
