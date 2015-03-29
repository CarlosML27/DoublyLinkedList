package prDoublyLinkedList.DoublyLinkedList;

/**
 * Hello world!
 *
 */
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
    first = null;
    last = null;
  }

  public boolean isEmpty() {
    return first == null && last == null;
  }



}
