package aed.searching.algorithms;

import aed.Comparison;

public class IterativeTernarySearch<T> extends SearchAlgorithm<T> {
    public IterativeTernarySearch(Comparison<T> comparator) {
        super(comparator);
    }

    @Override
    public int search(T element, T... elements) {
        int leftBound = 0;
        int rightBound = elements.length - 1;

        while (leftBound <= rightBound) {
            int third = (rightBound - leftBound) / 3;
            int firstMiddle = leftBound + third;

            int comparison = comparator.compare(element, elements[firstMiddle]);
            if (comparison < 0) {
                rightBound = firstMiddle - 1;
                continue;
            }

            if (comparison > 0) {
                int secondMiddle = rightBound - third;

                comparison = comparator.compare(element, elements[secondMiddle]);
                if (comparison < 0) {
                    leftBound = firstMiddle + 1;
                    rightBound = secondMiddle - 1;
                } else if (comparison > 0) {
                    leftBound = secondMiddle + 1;
                    continue;
                } else {
                    return secondMiddle;
                }
            } else {
                return firstMiddle;
            }
        }

        return NOT_FOUND;
    }
}
