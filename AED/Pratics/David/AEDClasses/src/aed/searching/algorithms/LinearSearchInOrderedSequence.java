package aed.searching.algorithms;

import aed.Comparison;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class LinearSearchInOrderedSequence<T> extends SearchAlgorithm<T> {

    public LinearSearchInOrderedSequence(Comparison<T> comparator) {
        super(comparator);
    }

    public int search(T element, T... elements) {
        if (elements.length == 0 ||
                comparator.compare(element, elements[elements.length - 1]) > 0) {
            return NOT_FOUND;
        }
        for (int i = 0; i < elements.length; i++) {
            int cp = comparator.compare(element, elements[i]);
            if (cp < 0) {
                return NOT_FOUND;
            }
            if (cp == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
