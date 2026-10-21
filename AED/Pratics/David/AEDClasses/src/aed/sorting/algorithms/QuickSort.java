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
public class QuickSort<T> extends SortingAlgorithm<T> {

    public QuickSort(Comparison<T> comparator) {
        super(comparator);
    }

    public void sort(T... elements) {
        if (elements.length < 2) {
            return;
        }
        sortRecursive(0, elements.length - 1, elements);
    }

    private void sortRecursive(int leftBound, int rightBound, T... elements) {
        int i = leftBound;
        int j = rightBound;
        int middle = (i + j) / 2;
        T pivot = elements[middle];

        do {
            while (comparator.compare(elements[i], pivot) < 0) {
                i++;
            }
            while (comparator.compare(elements[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(elements, i, j);
                i++;
                j--;
            }
        } while (i <= j);
        if (leftBound < j) {
            sortRecursive(leftBound, j, elements);
        }
        if (i < rightBound) {
            sortRecursive(i, rightBound, elements);
        }
    }
}
