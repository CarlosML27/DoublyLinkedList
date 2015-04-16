package prdoublylinkedlist.doublylinkedlist;

public class DLList<T> {
  private static class DLNode<E> {
    private E elem;
    private DLNode<E> next;
    private DLNode<E> prev;

    public DLNode(E elem, DLNode<E> next, DLNode<E> prev) {
      this.elem = elem;
      this.next = next;
      this.prev = prev;
    }
  }

  private DLNode<T> first, last;

  public DLList() {
    this.first = null;
    this.last = null;
  }

  public boolean isEmpty() {
    return this.first == null && this.last == null;
  }

  public int listSize() {
    DLNode<T> node = this.first;
    int result = 0;

    while (node != null) {
      node = node.next;
      result++;
    }
    return result;
  }

  public T first() {
    return this.first.elem;
  }

  public T last() {
    return this.last.elem;
  }

  private void verifySize(int size, int position) throws DLListException {
    if (size <= position || position < 0) {
      throw new DLListException("Requested position is not in the list.");
    }
  }

  // Positions from 0 to (size-1)
  private DLNode<T> getNodeAtPosition(int position) throws DLListException {
    verifySize(this.listSize(), position);
    DLNode<T> result = this.first;
    for (int counter = 0; counter < position; counter++) {
      result = result.next;
    }
    return result;
  }

  public T getElementAtPosition(int position) throws DLListException {
    return this.getNodeAtPosition(position).elem;
  }

  public void setElementAtPosition(int position, T element) throws DLListException {
    this.getNodeAtPosition(position).elem = element;
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

  public void deleteElementAtPosition(int position) throws DLListException {
    verifySize(this.listSize(), position);
    if (position == 0) {
      this.deleteFirst();
    } else if (position == this.listSize() - 1) {
      this.deleteLast();
    } else {
      DLNode<T> actualNode = this.first;
      int counter = 0;
      while (counter < position) {
        actualNode = actualNode.next;
        counter++;
      }
      actualNode.prev.next = actualNode.next;
      actualNode.next.prev = actualNode.prev;
      actualNode = null;
    }
  }

  @Override
  public String toString() {
    String result = "(";
    DLNode<T> node = this.first;
    while (node != null) {
      result += node.elem;
      if (node.next != null) {
        result += ",";
      }
      node = node.next;
    }
    result += ")";
    return result;
  }

  public String toStringReverse() {
    String result = "(";
    DLNode<T> node = this.last;
    while (node != null) {
      result += node.elem;
      if (node.prev != null) {
        result += ",";
      }
      node = node.prev;
    }
    result += ")";
    return result;
  }

}
