package aed.searching.examples;

import aed.IntegerComparator;
import aed.searching.algorithms.LinearSearchInUnorderedSequence;

public class TheoryMainLinearSearchInUnorderedSequence {

    public static void main(String[] args) {
        LinearSearchInUnorderedSequence<Integer> linearSearch = new LinearSearchInUnorderedSequence<>(IntegerComparator.COMPARATOR);
        linearSearch.display(20, 1, 7, 2, 5, 4, 1, 6, 8, 9);
        linearSearch.display(20, 3, 7, 2, 5, 4, 1, 6, 8, 9);
        linearSearch.display(20, 3, 1, 2, 4, 5, 6, 7, 8, 9);
    }
}
