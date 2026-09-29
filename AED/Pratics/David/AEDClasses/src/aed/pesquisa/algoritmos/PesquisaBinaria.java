package aed.pesquisa.algoritmos;

import aed.Comparacao;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class PesquisaBinaria<T> extends AlgoritmoPesquisa<T> {

    public PesquisaBinaria(Comparacao<T> comparator) {
        super(comparator);
    }

    public int search(T element, T... elements) {
        int lastElementIndex = elements.length - 1;
        if (elements.length == 0 ||
                comparator.compare(element, elements[0]) < 0 ||
                comparator.compare(element, elements[lastElementIndex]) > 0) {
            return NOT_FOUND;
        }
        return searchRecursive(element, 0, lastElementIndex, elements);
    }

    public int searchRecursive(T element, int leftBound, int rightBound, T... elements) {
        if (leftBound > rightBound) {
            return NOT_FOUND;
        }
        int middle = (leftBound + rightBound) / 2;
        int cp = comparator.compare(element, elements[middle]);
        if (cp > 0) {
            return searchRecursive(element, middle + 1, rightBound, elements);
        }
        if (cp < 0) {
            return searchRecursive(element, leftBound, middle - 1, elements);
        }
        return middle;
    }

}
