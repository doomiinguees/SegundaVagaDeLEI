package aed.searching.examples;

import aed.IntegerComparator;
import aed.sorting.algorithms.QuickSort;
import aed.searching.algorithms.SearchAlgorithm;
import aed.searching.algorithms.IterativeTernarySearch;
import aed.searching.algorithms.RecursiveTernarySearch;
import aed.utils.IntegerArray;

import java.util.Random;

public class PracticeMainTernarySearch {

    public static void main(String[] args) {
        /*
        Random random = new Random();

        SearchAlgorithm<Integer> recursiveTernarySearch = new RecursiveTernarySearch<>(IntegerComparator.COMPARATOR);
        SearchAlgorithm<Integer> iterativeTernarySearch = new IterativeTernarySearch<>(IntegerComparator.COMPARATOR);

        recursiveTernarySearch.display(20, -5, -12, -8, -5, 0, 3, 6);

        Integer[] elements = IntegerArray.createRandomInteger(10, -10, 10, false);
        new QuickSort<>(IntegerComparator.COMPARATOR).display(20, elements);

        int element = random.nextInt(21) - 10;
        recursiveTernarySearch.display(20, element, elements);
        //iterativeTernarySearch.display(20, element, elements);

        */

        Integer[] elements = {-12, -8, -5, 0, 3, 6, 9, 12, 15, 22};
        int element = 0;

        SearchAlgorithm<Integer> recursiveTernarySearch =
                new RecursiveTernarySearch<>(IntegerComparator.COMPARATOR);
        recursiveTernarySearch.display(20, element, elements);
        return;
    }
}
