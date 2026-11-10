package ua.opnu;

public class MyOptional<T> {
    private final T value;
    private final boolean present;

    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    public boolean isPresent() {
        return present;
    }

    public boolean isEmpty() {
        return !present;
    }

    public T get() {
        if (!present) {
            throw new IllegalStateException("Значення відсутнє");
        }
        return value;
    }

    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    @Override
    public String toString() {
        return present ? "MyOptional[value=" + value + "]" : "MyOptional[empty]";
    }
}
