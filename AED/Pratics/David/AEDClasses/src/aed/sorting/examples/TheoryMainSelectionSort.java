package aed.sorting.examples;

import aed.IntegerComparator;
import aed.sorting.algorithms.SelectionSort;

public class TheoryMainSelectionSort {

    public static void main(String[] args) {
        SelectionSort<Integer> selectionSort = new SelectionSort<>(IntegerComparator.COMPARATOR);
        selectionSort.display(20, 3, 7, 2, 5, 4, 1, 6, 8, 9);
    }
}
