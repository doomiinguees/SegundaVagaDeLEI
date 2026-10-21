package aed.collections.iterable;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
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
