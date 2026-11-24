package aed.collections.iterable;

import java.util.Iterator;

public interface IterableIterator<T> extends Iterator<T>, Iterable<T> {
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
