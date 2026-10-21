package aed.collections.iterable.linear;

import aed.collections.iterable.IterableCollection;

/**
 * @author Actual code:
 * Carlos Urbano<carlos.urbano@ulo.pt>
 * Catarina Reis<catarina.reis@ulo.pt>
 * Marco Ferreira<marco.ferreira@ulo.pt>
 * João Ramos<joao.f.ramos@ulo.pt>
 * Sónia Luz<sonia.luz@ulo.pt>
 * Original code: José Magno<jose.magno@ulo.pt>
 */
public interface LinearIterableCollection<T> extends IterableCollection<T> {
    void insert(T item);

    T remove(T item);

    T removeByReference(T item);

    T removeByIndex(int index);

    T getByIndex(int index);

    boolean contains(T item);

    boolean containsReference(T item);
}
