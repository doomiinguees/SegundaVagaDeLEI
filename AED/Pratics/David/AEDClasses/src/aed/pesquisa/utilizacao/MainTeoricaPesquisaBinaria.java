package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.pesquisa.algoritmos.PesquisaBinaria;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainTeoricaPesquisaBinaria {

    public static void main(String[] args) {
        PesquisaBinaria<Integer> binarySearch = new PesquisaBinaria<>(ComparacaoInteiros.COMPARATOR);
        binarySearch.display(20, 7, 7);
        binarySearch.display(20, 7, 1, 2, 4, 5, 6, 7, 8, 9);
        binarySearch.display(20, 3, 1, 2, 4, 5, 6, 7, 8, 9);
    }
}
