package storage;

public class Value<T> {
    private final T value;

    public  Value(T value){
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public double toDouble() {
        return (double) getValue();
    }
    public int toInt() {
        return (int) getValue();
    }
    public boolean toBoolean() {
        return (boolean) getValue();
    }

    public String toString() {
        return getValue().toString();
    }
}

