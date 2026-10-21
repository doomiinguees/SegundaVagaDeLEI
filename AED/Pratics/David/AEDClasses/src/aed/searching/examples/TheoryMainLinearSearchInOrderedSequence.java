package aed.searching.examples;

import aed.IntegerComparator;
import aed.searching.algorithms.LinearSearchInOrderedSequence;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class TheoryMainLinearSearchInOrderedSequence {

    public static void main(String[] args) {
        LinearSearchInOrderedSequence<Integer> linearSearch =
                new LinearSearchInOrderedSequence<>(IntegerComparator.COMPARATOR);
        linearSearch.display(20, 7, 1, 2, 4, 5, 6, 7, 8, 9);
        linearSearch.display(20, 12, 1, 2, 4, 5, 6, 7, 8, 9);
    }
}
