package aed.colecoes.iteraveis;

import aed.colecoes.Colecao;

import java.util.Iterator;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface ColecaoIteravel<T> extends Colecao<T>, Iterable<T> {
    IteradorIteravel<T> getIterator();

    @Override
    default Iterator<T> iterator() {
        return getIterator();
    }

    int getElementCount();

    default boolean isEmpty() {
        return getElementCount() == 0;
    }
}
