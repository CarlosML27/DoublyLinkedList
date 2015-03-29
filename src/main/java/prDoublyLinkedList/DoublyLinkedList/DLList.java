package prDoublyLinkedList.DoublyLinkedList;

public class DLList<T> {
  private static class Node<E> {
    private E elem;
    private Node<E> next;
    private Node<E> prev;

    public Node(E elem, Node<E> next, Node<E> prev) {
      this.elem = elem;
      this.next = next;
      this.prev = prev;
    }
  }

  private Node<T> first, last;

  public DLList() {
    this.first = null;
    this.last = null;
  }

  public boolean isEmpty() {
    return this.first == null && this.last == null;
  }

  public int listSize() {
    Node<T> node = this.first;
    int result = 0;

    while (node != null) {
      node = node.next;
      result++;
    }
    return result;
  }

  public T first() throws DLListException {
    if (this.isEmpty()) {
      throw new DLListException("First on empty queue");
    } else {
      return this.first.elem;
    }
  }

  public T last() throws DLListException {
    if (this.isEmpty()) {
      throw new DLListException("Last on empty queue");
    } else {
      return this.last.elem;
    }
  }

  // Positions from 0 to (size-1)
  public T elementAtPosition(int position) throws DLListException {
    if (this.listSize() <= position) {
      throw new DLListException("Requested position is bigger than list size");
    }

    Node<T> result = this.first;
    for (int counter = 0; counter < position; counter++) {
      result = result.next;
    }
    return result.elem;
  }

  public void deleteFirst() {
    if (this.first == this.last) {
      this.first = null;
      this.last = null;
    } else {
      this.first = this.first.next;
      this.first.prev = null;
    }
  }

  public void deleteLast() {
    if (this.first == this.last) {
      this.first = null;
      this.last = null;
    } else {
      this.last = this.last.prev;
      this.last.next = null;
    }
  }

}
