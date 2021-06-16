public class Element <T> {
    private final T data;
    private Element<T> next;
    private Element<T> prev;

    public Element(T data) {
        this.data = data;
        next = null;
        prev = null;
    }

    public T getData() {
        return data;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    public Element<T> getPrev() {
        return prev;
    }

    public void setPrev(Element<T> prev) {
        this.prev = prev;
    }
}
