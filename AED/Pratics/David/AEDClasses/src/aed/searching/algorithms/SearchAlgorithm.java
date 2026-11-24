package aed.searching.algorithms;

import aed.Comparison;
import aed.utils.Array;

public abstract class SearchAlgorithm<T> {

    public static final int NOT_FOUND = -1;

    protected final Comparison<T> comparator;

    public SearchAlgorithm(Comparison<T> comparator) {
        this.comparator = comparator;
    }

    public abstract int search(T element, T... elements);

    public void display(int displayElementCount, T element, T... elements) {
        int index = search(element, elements);
        System.out.print(element + " searched using " + getClass().getSimpleName()
                + (index != NOT_FOUND ? (" found at index " + index) : " not found") + " : ");
        Array.display(displayElementCount, elements);
    }
}
