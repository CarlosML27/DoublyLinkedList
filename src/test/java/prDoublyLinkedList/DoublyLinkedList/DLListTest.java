package prdoublylinkedlist.doublylinkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DLListTest {
    private DLList<Character> list;

    @Before
    public void createNewEmptyList() {
        this.list = new DLList<Character>();
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
        list.getElementAtPosition(4);
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
    public void setElementAtNegativePositionThrowDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.setElementAtPosition(-2, 'a');
    }

    @Test(expected = DLListException.class)
    public void setElementAtSizeOrMoreThrowDLListException()
            throws DLListException {
        Character[] items = { 'x', 'y', 'z', 't' };
        for (Character item : items) {
            list.insertLast(item);
        }
        list.setElementAtPosition(4, 'a');
    }

    @Test(expected = DLListException.class)
    public void setElementAtPositionZeroEmptyListThrowDLListException()
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
        assertEquals(list.first(), newItem);
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
        assertEquals(list.last(), newItem);
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
        assertEquals(list.getElementAtPosition(x), newItem);
    }
}
