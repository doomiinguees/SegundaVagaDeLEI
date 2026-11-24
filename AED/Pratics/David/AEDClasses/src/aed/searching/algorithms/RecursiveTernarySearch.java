package aed.searching.algorithms;

import aed.Comparison;

public class RecursiveTernarySearch<T> extends SearchAlgorithm<T> {
    public RecursiveTernarySearch(Comparison<T> comparator) {
        super(comparator);
    }

    @Override
    public int search(T element, T... elements) {
        return searchRecursive(element, 0, elements.length - 1, elements);
    }

    private int searchRecursive(T element, int leftBound, int rightBound, T... elements) {
        if (leftBound > rightBound) {
            return NOT_FOUND;
        }

        int third = (rightBound - leftBound) / 3;
        int firstMiddle = leftBound + third;

        int comparison = comparator.compare(element, elements[firstMiddle]);
        if (comparison < 0) {
            return searchRecursive(element, leftBound, firstMiddle - 1, elements);
        }
        if (comparison > 0) {
            int secondMiddle = rightBound - third;

            comparison = comparator.compare(element, elements[secondMiddle]);
            if (comparison < 0) {
                return searchRecursive(element, firstMiddle + 1, secondMiddle - 1, elements);
            }
            if (comparison > 0) {
                return searchRecursive(element, secondMiddle + 1, rightBound, elements);
            }
            return secondMiddle;
        }
        return firstMiddle;
    }
}
