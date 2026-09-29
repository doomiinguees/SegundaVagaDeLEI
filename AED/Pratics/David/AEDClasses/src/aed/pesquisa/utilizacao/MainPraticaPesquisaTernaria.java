package aed.pesquisa.utilizacao;

import aed.ComparacaoInteiros;
import aed.ordenacao.algoritmos.QuickSort;
import aed.pesquisa.algoritmos.AlgoritmoPesquisa;
import aed.pesquisa.algoritmos.PesquisaTernariaIterativa;
import aed.pesquisa.algoritmos.PesquisaTernariaRecursiva;
import aed.utils.VetorDeInteiros;

import java.util.Random;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public class MainPraticaPesquisaTernaria {

    public static void main(String[] args) {
        Random random = new Random();

        AlgoritmoPesquisa<Integer> recursiveTernarySearch = new PesquisaTernariaRecursiva<>(ComparacaoInteiros.COMPARATOR);
        AlgoritmoPesquisa<Integer> iterativeTernarySearch = new PesquisaTernariaIterativa<>(ComparacaoInteiros.COMPARATOR);

        recursiveTernarySearch.display(20, -5, -12, -8, -5, 0, 3, 6);

        Integer[] elements = VetorDeInteiros.createRandomInteger(10, -10, 10, false);
        new QuickSort<>(ComparacaoInteiros.COMPARATOR).display(20, elements);

        int element = random.nextInt(21) - 10;
        recursiveTernarySearch.display(20, element, elements);
        iterativeTernarySearch.display(20, element, elements);
    }
}
