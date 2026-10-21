package aed.sorting.algorithms;

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
public abstract class SortingAlgorithm<T> {

    protected final Comparison<T> comparator;

    public SortingAlgorithm(Comparison<T> comparator) {
        this.comparator = comparator;
    }

    public abstract void sort(T... elements);

    public void display(int displayElementCount, T... elements) {
        sort(elements);
        System.out.print("Sequence sorted by " + getClass().getSimpleName() + ": ");
        Array.display(displayElementCount, elements);
    }

    protected void swap(T[] elements, int index1, int index2) {
        T aux = elements[index1];
        elements[index1] = elements[index2];
        elements[index2] = aux;
    }
}