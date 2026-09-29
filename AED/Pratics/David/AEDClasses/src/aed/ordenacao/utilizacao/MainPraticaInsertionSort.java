package aed.ordenacao.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.InsertionSort;
import aed.utils.VetorDeInteiros;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainPraticaInsertionSort {

    public static void main(String[] args) {
        InsertionSort<Integer> insertionSort = new InsertionSort<>(ComparacaoInteiros.COMPARATOR);

        insertionSort.display(20, 5, 2, 4, 6, 1, 3);

        insertionSort.display(20, VetorDeInteiros.createRandomInteger(100, -100, 100, false));
    }
}
