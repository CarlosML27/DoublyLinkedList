package prdoublylinkedlist.doublylinkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DLListTest {
    private DLList<Character> list;

    @Before
    public void createNewEmptyList() {
        list = new DLList<Character>();
    }

    @Test
    public void isEmptyNewList() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void sizeIsZeroNewList() {
        assertEquals(0, list.listSize());
    }

    @Test
    public void sizeIsOneInsertItemInEmptyList() throws DLListException {
        Character item = 'a';
        list.insertLast(item);
        assertEquals(1, list.listSize());
    }

    @Test
    public void sizeIsXInsertXItemsInEmptyList() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        assertEquals(items.length, list.listSize());
    }

    @Test(expected = NullPointerException.class)
    public void firstNodeIsNullEmptyListFirstElemThrowsNullPointerException() {
        list.first();
    }

    @Test(expected = NullPointerException.class)
    public void lastNodeIsNullEmptyListLastElemThrowsNullPointerException() {
        list.last();
    }

    @Test(expected = DLListException.class)
    public void getElementAtNegativePositionThrowsDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.getElementAtPosition(-2);
    }

    @Test(expected = DLListException.class)
    public void getElementPositionAtSizeOrMoreThrowsDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.getElementAtPosition(list.listSize());
    }

    @Test(expected = DLListException.class)
    public void getElementAtPositionZeroEmptyListThrowsDLListException()
            throws DLListException {
        list.getElementAtPosition(0);
    }

    @Test
    public void getElementAtPositionZeroEqualsFirstNonEmptyList()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        assertEquals(list.first(), list.getElementAtPosition(0));
    }

    @Test
    public void getElementAtPositionSizeMinusOneEqualsLastNonEmptyList()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        assertEquals(list.last(),
                list.getElementAtPosition(list.listSize() - 1));
    }

    @Test
    public void getElementAtPositionXEqualsItemXthItem() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int x = 2;
        assertEquals(items[x], list.getElementAtPosition(x));
    }

    @Test(expected = DLListException.class)
    public void setElementAtNegativePositionThrowsDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.setElementAtPosition(-2, 'a');
    }

    @Test(expected = DLListException.class)
    public void setElementAtSizeOrMoreThrowsDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.setElementAtPosition(list.listSize(), 'a');
    }

    @Test(expected = DLListException.class)
    public void setElementAtPositionZeroEmptyListThrowsDLListException()
            throws DLListException {
        list.setElementAtPosition(0, 'a');
    }

    @Test
    public void setElementAtPositionZeroEqualsFirstNonEmptyList()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character newItem = 'a';
        list.setElementAtPosition(0, newItem);
        assertEquals(newItem, list.first());
    }

    @Test
    public void setElementAtPositionSizeMinusOneEqualsLastNonEmptyList()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character newItem = 'a';
        list.setElementAtPosition(list.listSize() - 1, newItem);
        assertEquals(newItem, list.last());
    }

    @Test
    public void setElementAtPositionXEqualsItemXthItem() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character newItem = 'a';
        int x = 2;
        list.setElementAtPosition(x, newItem);
        assertEquals(newItem, list.getElementAtPosition(x));
    }

    @Test(expected = DLListException.class)
    public void insertElementBeforeNegativePositionThrowsDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.insertElementBeforePosition('a', -2);
    }

    @Test(expected = DLListException.class)
    public void insertElementBeforePositionSizeOrMoreThrowsDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.insertElementBeforePosition('a', list.listSize());
    }

    @Test
    public void insertElementBeforePositionZeroEqualsFirst()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character item = 'a';
        list.insertElementBeforePosition(item, 0);
        assertEquals(item, list.first());
    }

    @Test
    public void insertElementBeforePositionXEqualsGetElementAtX()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character item = 'a';
        int x = 2;
        list.insertElementBeforePosition(item, x);
        assertEquals(item, list.getElementAtPosition(x));
    }

    @Test
    public void insertElementBeforePositionXMakePreviousAtXPlusOne()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character itemAtX;
        int x = 2;
        itemAtX = list.getElementAtPosition(x);
        list.insertElementBeforePosition('a', x);
        assertEquals(itemAtX, list.getElementAtPosition(x + 1));
    }

    @Test
    public void insertElementBeforePositionXSizeIncrementOne()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int sizeBefore = list.listSize();
        list.insertElementBeforePosition('a', 2);
        assertEquals(sizeBefore + 1, list.listSize());
    }

    @Test(expected = DLListException.class)
    public void insertElementAfterNegativePositionThrowsDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.insertElementAfterPosition('a', -2);
    }

    @Test(expected = DLListException.class)
    public void insertElementAfterPositionSizeOrMoreThrowsDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.insertElementAfterPosition('a', list.listSize());
    }

    @Test
    public void insertElementAfterPositionSizeMinusOneEqualsLast()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character item = 'a';
        list.insertElementAfterPosition(item, list.listSize() - 1);
        assertEquals(item, list.last());
    }

    @Test
    public void insertElementAfterPositionXEqualsGetElementAtXPlusOne()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character item = 'a';
        int x = 2;
        list.insertElementAfterPosition(item, x);
        assertEquals(item, list.getElementAtPosition(x + 1));
    }

    @Test
    public void insertElementAfterPositionXNoChangeElementAtX()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int x = 2;
        Character itemAtX = list.getElementAtPosition(x);
        list.insertElementAfterPosition('a', x);
        assertEquals(itemAtX, list.getElementAtPosition(x));
    }

    @Test
    public void insertElementAfterPositionXSizeIncrementOne()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int sizeBefore = list.listSize();
        list.insertElementAfterPosition('a', 2);
        assertEquals(sizeBefore + 1, list.listSize());
    }

    @Test
    public void insertFirstItemEqualsFirst() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character item = 'a';
        list.insertFirst('a');
        assertEquals(item, list.first());
    }

    @Test
    public void insertFirstItemEqualsLastEmptyList() throws DLListException {
        Character item = 'a';
        list.insertFirst('a');
        assertEquals(item, list.last());
    }

    @Test
    public void insertFirstElementAtPositionOneEqualsPreviousFirst()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character previousFirst = list.first();
        list.insertFirst('a');
        assertEquals(previousFirst, list.getElementAtPosition(1));
    }

    @Test
    public void insertFirstSizeIncrementOne() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int sizeBefore = list.listSize();
        list.insertFirst('a');
        assertEquals(sizeBefore + 1, list.listSize());
    }

    @Test
    public void insertLastItemEqualsLast() throws DLListException {
        Character item = 'a';
        list.insertLast(item);
        assertEquals(item, list.last());
    }

    @Test
    public void insertLastItemEqualsLastEmptyFirst() throws DLListException {
        Character item = 'a';
        list.insertLast(item);
        assertEquals(item, list.first());
    }

    @Test
    public void insertLastElementAtPositionSizeMinusTwoEqualsPreviousLast()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character previousLast = list.last();
        list.insertLast('a');
        assertEquals(previousLast,
                list.getElementAtPosition(list.listSize() - 2));
    }

    @Test
    public void insertLastSizeIncrementOne() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int sizeBefore = list.listSize();
        list.insertLast('a');
        assertEquals(sizeBefore + 1, list.listSize());
    }

    @Test
    public void deleteFirstNewFirstEqualsPreviousElementAtPositionOne()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character previousPositionOne = list.getElementAtPosition(1);
        list.deleteFirst();
        assertEquals(previousPositionOne, list.first());
    }

    @Test
    public void deleteFirstSizeDecrementOneNonEmptyList()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int sizeBefore = list.listSize();
        list.deleteFirst();
        assertEquals(sizeBefore - 1, list.listSize());
    }

    @Test
    public void deleteLastNewLastEqualsPreviousElementAtPositionSizeMinusTwo()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        Character previousPositionSizeMinusTwo = list.getElementAtPosition(list
                .listSize() - 2);
        list.deleteLast();
        assertEquals(previousPositionSizeMinusTwo, list.last());
    }

    @Test
    public void deleteLastSizeDecrementOneNonEmptyList() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int sizeBefore = list.listSize();
        list.deleteLast();
        assertEquals(sizeBefore - 1, list.listSize());
    }

    @Test(expected = DLListException.class)
    public void deleteElementAtNegativePositionThrowDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.deleteElementAtPosition(-2);
    }

    @Test(expected = DLListException.class)
    public void deleteElementAtSizeOrMoreThrowDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.deleteElementAtPosition(list.listSize());
    }

    @Test(expected = DLListException.class)
    public void deleteElementAtPositionZeroEmptyListThrowDLListException()
            throws DLListException {
        list.deleteElementAtPosition(0);
    }

    @Test
    public void deleteElementAtPositionXElementAtXEqualsPreviousElementAtXPlusOne()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        int x = 2;
        Character itemAtXPlusOne = list.getElementAtPosition(x + 1);
        list.deleteElementAtPosition(x);
        assertEquals(itemAtXPlusOne, list.getElementAtPosition(x));
    }

    @Test
    public void toStringApropriateRepresentationOfList() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        assertEquals("(x,y,z,t)", list.toString());
    }

    @Test
    public void toStringReverseApropriate() throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        assertEquals("(t,z,y,x)", list.toStringReverse());
    }
}
