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
public class PesquisaLinearEmSequenciaNaoOrdenada<T> extends AlgoritmoPesquisa<T> {

    public PesquisaLinearEmSequenciaNaoOrdenada(Comparacao<T> comparator) {
        super(comparator);
    }

    public int search(T element, T... elements) {
        for (int i = 0; i < elements.length; i++) {
            if (comparator.compare(element, elements[i]) == 0) {
                return i;
            }
        }
        return NOT_FOUND;
    }
}
