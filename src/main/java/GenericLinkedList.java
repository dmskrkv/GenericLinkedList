public class GenericLinkedList <T> {
    private Element<T> first;
    private Element<T> last;
    private int size;

    public GenericLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void addLastElement(T data) {
        Element<T> newElement = new Element<> (data);
        if (first == null) {
            first = newElement;
        } else {
            last.setNext(newElement);
            newElement.setPrev(last);
        }
        last = newElement;
        size++;
    }

    public void addFirstElement(T data) {
        Element<T> newElement = new Element<>(data);
        if (first == null) {
            first = newElement;
            last = first;
        } else {
            first.setPrev(newElement);
            newElement.setNext(first);
            first = newElement;
        }
        size++;
    }

    public void insertAtPos(T data, int pos) {
        Element<T> newElement = new Element<> (data);
        //if (pos == 1) { ---- индексирование было с 1, т.к. предполагалось, что это user friendly, более естественно, что если элемент всего одни, то он первый
        if (pos > size) {
            throw new IllegalArgumentException();
        } else if (pos == 0) {
            addFirstElement(data);
        } else if (pos == size) {
            addLastElement(data);
        } else {
            Element<T> elementAtPos = first;
            for (int i = 1; i < size; i++) {
                if (i == pos) {
                    Element<T> tmp = elementAtPos.getNext();
                    elementAtPos.setNext(newElement);
                    newElement.setPrev(elementAtPos);
                    newElement.setNext(tmp);
                    tmp.setPrev(newElement);
                    break;
                } else {
                    elementAtPos = elementAtPos.getNext();
                }
            }
            size++;
        }
    }

    public void deleteAtPos(int pos) {
        if (pos >= size) {
            throw new IllegalArgumentException();
        } else if (pos == 0) {
            if (size == 1) {
                first = null;
                last = null;
                size = 0;
            } else {
                first = first.getNext();
                first.setPrev(null);
                size--;
            }
        } else if (pos == size-1) {
            last = last.getPrev();
            last.setNext(null);
            size--;
        } else {
            Element<T> elementAtPos = first.getNext();
            for (int i = 1; i < size; i++) {
                if (i == pos) {
                    Element<T> p = elementAtPos.getPrev();
                    Element<T> n = elementAtPos.getNext();
                    p.setNext(n);
                    n.setPrev(p);
                    size--;
                    return;
                }
                elementAtPos = elementAtPos.getNext();
            }
        }
    }

    public T getElement(int pos) {
        if (pos >= size) {
            throw new IllegalArgumentException();
        } else if (pos == 0) {
            return first.getData();
        } else if (pos == size-1) {
            return last.getData();
        } else {
            Element<T> elementAtPos = first.getNext();
            for (int i = 1; i < size; i++) {
                if (i == pos) {
                    break;
                } else {
                    elementAtPos = elementAtPos.getNext();
                }
            }
            return elementAtPos.getData();
        }
    }
}
