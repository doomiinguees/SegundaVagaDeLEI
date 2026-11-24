package aed.sorting.examples;

import aed.IntegerComparator;
import aed.sorting.algorithms.QuickSort;

public class TheoryMainQuickSort {

    public static void main(String[] args) {
        QuickSort<Integer> quickSort = new QuickSort<>(IntegerComparator.COMPARATOR);
        quickSort.display(20, 3, 7, 2, 5, 4, 1, 6, 8, 9);
    }
}
