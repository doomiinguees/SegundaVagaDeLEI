package aed.collections.iterable;

import aed.collections.Collection;

import java.util.Iterator;

public interface IterableCollection<T> extends Collection<T>, Iterable<T> {
    IterableIterator<T> getIterator();

    @Override
    default Iterator<T> iterator() {
        return getIterator();
    }

    int getElementCount();

    default boolean isEmpty() {
        return getElementCount() == 0;
    }
}
