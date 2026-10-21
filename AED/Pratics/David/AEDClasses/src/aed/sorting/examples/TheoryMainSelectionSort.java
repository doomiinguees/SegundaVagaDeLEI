package aed.sorting.examples;

import aed.IntegerComparator;
import aed.sorting.algorithms.SelectionSort;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class TheoryMainSelectionSort {

    public static void main(String[] args) {
        SelectionSort<Integer> selectionSort = new SelectionSort<>(IntegerComparator.COMPARATOR);
        selectionSort.display(20, 3, 7, 2, 5, 4, 1, 6, 8, 9);
    }
}
