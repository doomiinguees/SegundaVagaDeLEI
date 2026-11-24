package aed.collections.iterable.linear.unordered;


import aed.collections.iterable.linear.LinearIterableCollection;

public interface UnorderedLinearIterableCollection<T> extends LinearIterableCollection<T> {
    void insertAtBeginning(T item);

    void insertAtEnd(T item);

    void insertByIndex(int index, T item);

    @Override
    default void insert(T item) {
        insertAtEnd(item);
    }

    T removeFromBeginning();

    T removeFromEnd();
}
