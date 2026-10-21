package aed.collections.noniterable;

import aed.collections.Collection;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface NonIterableCollection<T> extends Collection<T> {
    void insert(T item);

    T remove();

    T get();

    boolean isEmpty();
}
