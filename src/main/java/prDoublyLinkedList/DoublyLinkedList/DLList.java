package prdoublylinkedlist.doublylinkedlist;

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

  private void verifySize(int size, int position) throws DLListException {
    if (size <= position) {
      throw new DLListException("Requested position is not in the list.");
    }
  }

  public T first() throws DLListException {
    return elementAtPosition(0);
  }

  public T last() throws DLListException {
    return elementAtPosition(this.listSize()-1);
  }

  // Positions from 0 to (size-1)
  public T elementAtPosition(int position) throws DLListException {
    verifySize(this.listSize(), position);
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

  public void deleteElementAtPosition(int position) {
    if (position < this.listSize()) {
      if(position == 0){
        this.deleteFirst();
      } else if(position == this.listSize()-1){
        this.deleteLast();
      } else{
        Node<T> actualNode = this.first;
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
  }

  @Override
  public String toString() {
    String result = "(";
    Node<T> node = this.first;
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

  public String showReverse() {
    String result = "(";
    Node<T> node = this.last;
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
