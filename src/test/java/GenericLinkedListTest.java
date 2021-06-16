import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GenericLinkedListTest {

    @Test
    void getSize() {
        GenericLinkedList<String> gll = new GenericLinkedList<>();
        gll.addFirstElement("one");
        gll.addLastElement("Two");
        gll.insertAtPos("three", 1);
        Assertions.assertEquals(3, gll.getSize());
    }

    @Test
    void addLastElement() {
        GenericLinkedList<Character> gll = new GenericLinkedList<>();
        gll.addFirstElement('o');
        gll.addLastElement('T');
        gll.insertAtPos('t', 1);
        Assertions.assertEquals('T', gll.getElement(2));
    }

    @Test
    void addFirstElement() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.addLastElement(10);
        list.addLastElement(20);
        list.addLastElement(30);
        list.addFirstElement(0);
        Assertions.assertEquals(0, list.getElement(0));
    }

    @Test
    void insertAtPos() {
        GenericLinkedList<Number> list = new GenericLinkedList<>();
        list.addLastElement(10);
        list.addLastElement(20);
        list.addLastElement(30);
        list.insertAtPos(50,2);
        Assertions.assertEquals(30, list.getElement(3));
        list.addFirstElement(100);
        Assertions.assertEquals(10, list.getElement(1));
    }

    @Test
    void deleteAtPos() {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();
        list.addLastElement(10);
        list.addLastElement(20);
        list.addLastElement(30);
        list.addLastElement(40);
        list.deleteAtPos(2);
        Assertions.assertEquals(40, list.getElement(2));
        Assertions.assertEquals(3, list.getSize());

    }

    @Test
    void getElement() {
        GenericLinkedList<String> gll = new GenericLinkedList<>();
        gll.addFirstElement("one");
        gll.addLastElement("Two");
        gll.insertAtPos("three", 1);
        gll.insertAtPos("zero", 0);
        Assertions.assertEquals("zero", gll.getElement(0));
        Assertions.assertEquals("one", gll.getElement(1));
    }
}