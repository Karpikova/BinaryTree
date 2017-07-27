public class Element<T> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Element(T element) {
        this.value = element;
    }
}
