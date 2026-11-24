package aed.sorting.examples;

import aed.IntegerComparator;
import aed.sorting.algorithms.InsertionSort;
import aed.utils.IntegerArray;

public class PracticeMainInsertionSort {

    public static void main(String[] args) {
        InsertionSort<Integer> insertionSort = new InsertionSort<>(IntegerComparator.COMPARATOR);

        System.out.println("\nArray sent to ordering: [5, 2, 4, 6, 1, 3]\n");

        insertionSort.display(20, 5, 2, 4, 6, 1, 3);

        //insertionSort.display(20, IntegerArray.createRandomInteger(100, -100, 100, false));
    }
}
