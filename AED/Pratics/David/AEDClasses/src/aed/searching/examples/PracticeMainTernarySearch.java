package aed.searching.examples;

import aed.IntegerComparator;
import aed.sorting.algorithms.QuickSort;
import aed.searching.algorithms.SearchAlgorithm;
import aed.searching.algorithms.IterativeTernarySearch;
import aed.searching.algorithms.RecursiveTernarySearch;
import aed.utils.IntegerArray;

import java.util.Random;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PracticeMainTernarySearch {

    public static void main(String[] args) {
        Random random = new Random();

        SearchAlgorithm<Integer> recursiveTernarySearch = new RecursiveTernarySearch<>(IntegerComparator.COMPARATOR);
        SearchAlgorithm<Integer> iterativeTernarySearch = new IterativeTernarySearch<>(IntegerComparator.COMPARATOR);

        recursiveTernarySearch.display(20, -5, -12, -8, -5, 0, 3, 6);

        Integer[] elements = IntegerArray.createRandomInteger(10, -10, 10, false);
        new QuickSort<>(IntegerComparator.COMPARATOR).display(20, elements);

        int element = random.nextInt(21) - 10;
        recursiveTernarySearch.display(20, element, elements);
        iterativeTernarySearch.display(20, element, elements);
    }
}
