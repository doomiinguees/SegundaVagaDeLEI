package aed.sorting.algorithms;

import aed.Comparison;

public class SelectionSort<T> extends SortingAlgorithm<T> {

    public SelectionSort(Comparison<T> comparator) {
        super(comparator);
    }

    public void sort(T... elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (comparator.compare(elements[j], elements[smallest]) < 0) {
                    smallest = j;
                }
            }
            if (smallest != i) {
                swap(elements, i, smallest);
            }
        }
    }
}
