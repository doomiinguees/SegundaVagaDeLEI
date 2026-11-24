package aed.collections.iterable;

public interface BidirectionalIterableIterator<T> extends IterableIterator<T> {
    /**
     * Verifica se pode recuar para o elemento anterior.
     *
     * @return true caso ainda existam elementos a percorrer;
     * false caso contrário
     */
    boolean canRetreat();

    /**
     * Devolve o elemento anterior.
     * Caso não exista lança uma exceção NoSuchElementException
     *
     * @return o elemento anterior
     */
    T retreat();
}
