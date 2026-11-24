package aed.collections.noniterable;

import aed.collections.Collection;

public interface NonIterableCollection<T> extends Collection<T> {
    void insert(T item);

    T remove();

    T get();

    boolean isEmpty();
}
