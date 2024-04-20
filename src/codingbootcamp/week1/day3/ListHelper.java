package codingbootcamp.week1.day3;

import java.util.function.Function;

public class ListHelper {
  public static <T> ListNode<T> createOne(T value) {
    return new ListNode<>(null, null, value);

  }

  public static <T> void connect(ListNode<T> left, ListNode<T> right) {
    if (left != null ) {
      left.setNext(right);
    }
    if (right != null) {
      right.setPrev(left);
    }
  }

  public static <T> int length(ListNode<T> someNode) {
    int size = 1;
    ListNode<T> currentNode = someNode.getNext();
    while (currentNode != null) {
      currentNode = currentNode.getNext();
      size++;
    }
    currentNode = someNode.getPrev();
    while (currentNode != null) {
      currentNode = currentNode.getPrev();
      size++;
    }
    return size;
  }

  public static <T> ListNode<T> addToEnd(ListNode<T> someNode, T newValue) {
    ListNode<T> currentNode1 = someNode;
    while (currentNode1.getNext() != null) {
      currentNode1 = currentNode1.getNext();
    }
    return new ListNode<T>(currentNode1, null, newValue);
  }

  public static <T> ListNode<T> addToStart(ListNode<T> someNode, T newValue) {
    ListNode<T> currentNode2 = someNode;
    while (currentNode2.getPrev() != null) {
      currentNode2 = currentNode2.getPrev();

    }
    return new ListNode<T>(null, currentNode2, newValue);

  }

  //сontains
  //Этот метод ищет значение в двунаправленном связном списке. Если находит — true, если нет — false. На вход ему подается значение,
  // которое нужно найти и нода, которая связана с другими такими же нодами. В одной из таких нод может быть или не быть искомое значение.
  //Входная нода может иметь различное количество нод перед и после себя, даже ноль. Сигнатура метода:
  public static <T> boolean contains(ListNode<T> someNode, T value) {
    if (someNode == null) {
      throw new NullPointerException();
    }
    ListNode<T> naruto = someNode;
    while (naruto != null) {
      if (naruto.getValue().equals(value)) {
        return true;
      }
      naruto = naruto.getNext();
    }
    naruto = someNode;
    while (naruto != null) {
      if (naruto.getValue().equals(value)) {
        return true;
      }
      naruto = naruto.getPrev();
    }
    return false;
  }



  public static <T, R> ListNode<R> map(ListNode<T> someNode, Function<T, R> mapFunction) {
    ListNode<T> currentNode = getFirst(someNode);
    ListNode<R> newCurrentNode = createOne(mapFunction.apply(currentNode.getValue()));
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
      connect(newCurrentNode, createOne(mapFunction.apply(currentNode.getValue())));
      newCurrentNode = newCurrentNode.getNext();
    }
    return newCurrentNode;
  }

  private static <T> ListNode<T> getFirst(ListNode<T> currentNode) {
    while (currentNode.getPrev() != null) {
      currentNode = currentNode.getPrev();
    }
    return currentNode;
  }

  public static <T> ListNode<T> insertAfter(ListNode<T> prev, T newValue) {
    return new ListNode<>(prev, prev.getNext(), newValue);
  }

  public static <T> void insertAfter(ListNode<T> prev, T[] newValues) {
    for (T newValue : newValues) {
      prev = insertAfter(prev, newValue);
    }
  }

  public static <T> T delete(ListNode<T> current) {
    connect(current.getPrev(), current.getNext());
    current.setPrev(null);
    current.setNext(null);
    return current.getValue();
  }
}