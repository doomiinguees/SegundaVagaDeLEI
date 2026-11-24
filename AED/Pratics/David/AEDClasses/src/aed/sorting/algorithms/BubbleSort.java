package aed.sorting.algorithms;

import aed.Comparison;

public class BubbleSort<T> extends SortingAlgorithm<T> {

    public BubbleSort(Comparison<T> comparator) {
        super(comparator);
    }

    public void sort(T... elements) {
        int lastSwapIndex = elements.length;

        do {
            int swapIndex = 0;
            for (int i = 1; i < lastSwapIndex; i++) {
                if (comparator.compare(elements[i], elements[i - 1]) < 0) {
                    swap(elements, i, i - 1);
                    swapIndex = i;
                }
            }
            lastSwapIndex = swapIndex;
        } while (lastSwapIndex > 1);
    }

}
