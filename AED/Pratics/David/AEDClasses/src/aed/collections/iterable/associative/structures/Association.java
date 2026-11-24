package aed.collections.iterable.associative.structures;

import java.io.Serializable;

public class Association<C, V> implements Serializable {

    private static final long serialVersionUID = 1L;

    private final C key;
    private V value;

    public Association(C key, V value) {
        this.key = key;
        this.value = value;
    }

    public C getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "[" + key + ", " + value + "]";
    }
}
