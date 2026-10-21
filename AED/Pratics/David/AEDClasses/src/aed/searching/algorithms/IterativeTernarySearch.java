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
public class IterativeTernarySearch<T> extends SearchAlgorithm<T> {
    public IterativeTernarySearch(Comparison<T> comparator) {
        super(comparator);
    }

    @Override
    public int search(T element, T... elements) {
        // todo Ficha Prática 3 - 3.b)
        return NOT_FOUND;
    }
}
