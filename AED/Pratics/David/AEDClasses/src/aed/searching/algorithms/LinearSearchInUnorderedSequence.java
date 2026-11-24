package aed.searching.algorithms;

import aed.Comparison;

public class LinearSearchInUnorderedSequence<T> extends SearchAlgorithm<T> {

    public LinearSearchInUnorderedSequence(Comparison<T> comparator) {
        super(comparator);
    }

    public int search(T element, T... elements) {
        for (int i = 0; i < elements.length; i++) {
            if (comparator.compare(element, elements[i]) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
