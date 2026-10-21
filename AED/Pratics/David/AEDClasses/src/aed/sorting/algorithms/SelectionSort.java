package aed.sorting.algorithms;

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
public class SelectionSort<T> extends SortingAlgorithm<T> {

    public SelectionSort(Comparison<T> comparator) {
        super(comparator);
    }

    public void sort(T... elements) {
        for (int i = 0; i < elements.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (comparator.compare(elements[j], elements[smallest]) < 0) {
                    smallest = j;
                }
            }
            if (smallest != i) {
                swap(elements, i, smallest);
            }
        }
    }
}
