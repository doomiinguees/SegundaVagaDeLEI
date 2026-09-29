package aed.colecoes.iteraveis;

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
public interface IteradorIteravel<T> extends Iterator<T>, Iterable<T> {
    /**
     * Reinicia o iterador.
     */
    void reset();

    /**
     * Devolve o elemento atual.
     * Caso não exista lança uma exceção NoSuchElementException
     *
     * @return o elemento atual
     */
    T current();

    /**
     * Verifica se pode avançar para o próximo elemento.
     *
     * @return true caso ainda existam elementos a percorrer;
     * false caso contrário
     */
    boolean canAdvance();

    /**
     * Devolve o próximo elemento.
     * Caso não exista lança uma exceção NoSuchElementException
     *
     * @return o próximo elemento
     */
    T advance();


    @Override
    default boolean hasNext() {
        return canAdvance();
    }

    @Override
    default T next() {
        return advance();
    }

    @Override
    default Iterator<T> iterator() {
        return this;
    }
}
