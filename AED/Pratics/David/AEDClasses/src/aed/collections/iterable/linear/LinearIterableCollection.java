package aed.collections.iterable.linear;

import aed.collections.iterable.IterableCollection;

public interface LinearIterableCollection<T> extends IterableCollection<T> {
    void insert(T item);

    T remove(T item);

    T removeByReference(T item);

    T removeByIndex(int index);

    T getByIndex(int index);

    boolean contains(T item);

    boolean containsReference(T item);
}
