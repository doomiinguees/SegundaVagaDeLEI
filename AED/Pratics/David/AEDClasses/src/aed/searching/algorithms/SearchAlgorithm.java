package aed.searching.algorithms;

import aed.Comparison;
import aed.utils.Array;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public abstract class SearchAlgorithm<T> {

    public static final int NOT_FOUND = -1;

    protected final Comparison<T> comparator;

    public SearchAlgorithm(Comparison<T> comparator) {
        this.comparator = comparator;
    }

    public abstract int search(T element, T... elements);

    public void display(int displayElementCount, T element, T... elements) {
        int index = search(element, elements);
        System.out.print(element + " searched using " + getClass().getSimpleName()
                + (index != NOT_FOUND ? (" found at index " + index) : " not found") + " : ");
        Array.display(displayElementCount, elements);
    }
}
