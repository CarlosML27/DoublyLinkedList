# DoublyLinkedList
Doubly-Linked List implementation with Java using Eclipse, Maven, JUnit, SonarQube and JaCoCo.

#### Nested Class Summary
    private class DLNode<E>

#### Field Summary
    - DLNode<T> first
    - DLNode<T> last
    
#### Constructor Summary
    + DLList()

#### Method Summary
    + boolean isEmpty()
    + int listSize()
    + T first()
    + T last()
    - void verifySize(int size, int position)
    - DLNode<T> getNodeAtPosition(int position)
    + T getElementAtPosition(int position)
    + void setElementAtPosition(int position, T element)
    - void insertElementAtEmpty(T element)
    + void insertElementBeforePosition(T element, int position)
    + void insertElementAfterPosition(T element, int position)
    + void insertFirst(T element)
    + void insertLast(T element)
    + void deleteFirst()
    + void deleteLast()
    + void deleteElementAtPosition(int position)
    + String toString()
    + String toStringReverse()
    + void showList()
    + void showReverseList()
    
Implementation by **Carlos Morente Lozano (SW-A)**

JUnit testing by **David Rubio Cortés (SW-A)**

JaCoCo coverage report is in folder jacoco. Use [htmlpreview.github.io](http://htmlpreview.github.io/?https://raw.githubusercontent.com/CarlosML27/DoublyLinkedList/testing/jacoco/index.html) to have a look at the results in your web browser, or check the screenshots in the root of the repo. You can generate your own report by running "mvn install".
