package aed.sorting.algorithms;

import aed.Comparison;

public class InsertionSort<T> extends SortingAlgorithm<T> {

    public InsertionSort(Comparison<T> comparator) {
        super(comparator);
    }

    public void sort(T... elements) {
        for (int i = 1; i < elements.length; i++) {
            T selected = elements[i];
            int j = i - 1;

            do {
                elements[j + 1] = elements[j];
                j--;
            } while (j >= 0 && comparator.compare(elements[j], selected) > 0);


            elements[j + 1] = selected;
        }
    }
}
