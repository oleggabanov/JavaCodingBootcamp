package codingbootcamp.week1.day3;

public class ListNode<T> {
  private ListNode<T> prev;
  private ListNode<T> next;
  private T value;



  public ListNode(ListNode<T> prev, ListNode<T> next, T value) {
    setNext(next);
    setPrev(prev);
    this.value = value;
  }

  public void setPrev(ListNode<T> prev) {
    this.prev = prev;
    if (prev != null) {
      prev.next = this;
    }
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
    if (next != null) {
      next.prev = this;
    }
  }

  public ListNode<T> getNext() {
    return this.next;
  }

  public ListNode<T> getPrev() {
    return this.prev;
  }

  public T getValue() {
    return this.value;
  }

  @Override
  public String toString() {
    String prevValue = prev != null && prev.value != null ? prev.value.toString() : "null";
    String nextValue = next != null && next.value != null ? next.value.toString() : "null";
    String strValue = value != null ? value.toString() : "null";
    return "Node{prevValue=" + prevValue + ", nextValue=" + nextValue + ", thisValue=" + strValue + "}";
  }
}


