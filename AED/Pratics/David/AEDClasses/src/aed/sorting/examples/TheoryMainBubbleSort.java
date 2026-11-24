package aed.sorting.examples;

import aed.IntegerComparator;
import aed.sorting.algorithms.BubbleSort;

public class TheoryMainBubbleSort {

    public static void main(String[] args) {
        BubbleSort<Integer> bubbleSort = new BubbleSort<>(IntegerComparator.COMPARATOR);
        bubbleSort.display(20, 3, 7, 2, 5, 4, 1, 6, 8, 9);
    }
}
