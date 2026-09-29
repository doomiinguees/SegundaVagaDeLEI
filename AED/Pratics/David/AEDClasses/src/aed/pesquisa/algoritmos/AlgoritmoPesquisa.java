package aed.pesquisa.algoritmos;

import aed.Comparacao;
import aed.utils.Vetor;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public abstract class AlgoritmoPesquisa<T> {

    public static final int NOT_FOUND = -1;

    protected final Comparacao<T> comparator;

    public AlgoritmoPesquisa(Comparacao<T> comparator) {
        this.comparator = comparator;
    }

    public abstract int search(T element, T... elements);

    public void display(int displayElementCount, T element, T... elements) {
        int index = search(element, elements);
        System.out.print(element + " pesquisado por " + getClass().getSimpleName()
                + (index != NOT_FOUND ? (" encontrado no índice " + index) : " não encontrado") + " : ");
        Vetor.display(displayElementCount, elements);
    }
}
